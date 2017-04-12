package tech.jiangtao.backstage.controller.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.jiangtao.backstage.model.FileResult;
import tech.jiangtao.backstage.utils.TransportType;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Class: FileUploadController </br>
 * Description: 文件上传接口 </br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
@Api(value = "上传", description = "图片，语音，视频，文件上传", tags = "文件上传")
@RestController
@RequestMapping("/file")
public class FileUploadController {

  private static final Logger logger = LoggerFactory
      .getLogger(FileUploadController.class);

  /**
   *
   * @param file
   * @param type
   * @return
   */
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ApiOperation(value = "上传文件接口", httpMethod = "POST", response = FileResult.class,
      notes = "上传文件接口")
  public FileResult uploadFile(
      @ApiParam(required = true, name = "file", value = "文件") @RequestParam("file")
          MultipartFile file,
      @ApiParam(required = true, name = "type", value = "文件类型") @RequestParam("type")
          TransportType type) {
    String name = file.getOriginalFilename();
    String resourceId =
        UUID.randomUUID().toString() + name.substring(name.indexOf("."), name.length());
    FileResult result = new FileResult();
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        String rootPath = System.getProperty("catalina.home");
        File dir = createFile(rootPath, type);
        File serverFile = new File((dir != null ? dir.getAbsolutePath() : null)
            + File.separator + resourceId);
        BufferedOutputStream stream = new BufferedOutputStream(
            new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        logger.info("文件位置"
            + serverFile.getAbsolutePath());
        result.setResourceId(resourceId);
        result.setSuccess(true);
        result.setType(type);
        return result;
      } catch (Exception e) {
        result.setSuccess(false);
        result.setErrorMessage(e.getMessage());
        return result;
      }
    } else {
      result.setSuccess(false);
      result.setErrorMessage("文件不能为空");
      return result;
    }
  }

  /**
   *
   * @param files
   * @param types
   * @return
   */
  @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
  @ApiOperation(value = "同时上传多个文件接口", httpMethod = "POST", response = FileResult.class
      , responseContainer = "List", notes = "同时上传多个文件接口")
  public List<FileResult> uploadMultipleFileHandler(
      @ApiParam(required = true, name = "files", value = "文件列表") @RequestParam("files")
          MultipartFile[] files,
      @ApiParam(required = true, name = "types", value = "文件类型") @RequestParam("types")
          TransportType[] types) {
    List<FileResult> results = new ArrayList<>();
    FileResult fileResult = new FileResult();
    fileResult.setErrorMessage("文件总数与类型总数不匹配");
    fileResult.setResourceId(null);
    results.add(fileResult);
    if (files.length != types.length) {
      return results;
    }
    for (int i = 0; i < files.length; i++) {
      MultipartFile file = files[i];
      FileResult result = new FileResult();
      try {
        byte[] bytes = file.getBytes();
        String rootPath = System.getProperty("catalina.home");
        TransportType type = types[i];
        File dir = createFile(rootPath, type);
        String name = file.getOriginalFilename();
        String resourceId =
            UUID.randomUUID().toString() + name.substring(name.indexOf("."), name.length());
        File serverFile = new File(dir.getAbsolutePath()
            + File.separator + resourceId);
        BufferedOutputStream stream = new BufferedOutputStream(
            new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        logger.info("文件位置=" + serverFile.getAbsolutePath());
        result.setResourceId(resourceId);
        result.setSuccess(true);
        result.setType(type);
        results.add(result);
      } catch (Exception e) {
        e.printStackTrace();
        result.setResourceId(null);
        result.setSuccess(false);
        result.setType(null);
        results.add(result);
      }
    }
    return results;
  }

  private File createFile(String rootPath, TransportType type) {
    File dir = null;
    if (type == TransportType.AVATAR) {
      dir = new File(rootPath + File.separator + "webapps/resource" + "/avatar");
    } else if (type == TransportType.IMAGE) {
      dir = new File(rootPath + File.separator + "webapps/resource" + "/image");
    } else if (type == TransportType.AUDIO) {
      dir = new File(rootPath + File.separator + "webapps/resource" + "/audio");
    } else if (type == TransportType.VIDEO) {
      dir = new File(rootPath + File.separator + "webapps/resource" + "/video");
    } else if (type == TransportType.FILE) {
      dir = new File(rootPath + File.separator + "webapps/resource" + "/file");
    }
    if (dir != null && !dir.exists()) dir.mkdirs();
    return dir;
  }
}
