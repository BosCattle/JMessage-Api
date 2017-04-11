package tech.jiangtao.backstage.controller.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.jiangtao.backstage.model.FileResult;
import tech.jiangtao.backstage.model.json.Groups;
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
@Api(value = "上传",description = "图片，语音，视频，文件上传",tags = "文件上传")
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
    FileResult result = new FileResult();
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists()) {
          dir.mkdirs();
        }
        File serverFile = new File(dir.getAbsolutePath()
            + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(
            new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        logger.info("Server File Location="
            + serverFile.getAbsolutePath());
        result.setResourceId(file.getName());
        result.setSuccess(true);
        result.setType(TransportType.AUDIO);
        return result;
      } catch (Exception e) {
        result.setSuccess(false);
        result.setErrorMessage(e.getMessage());
        return result;
      }
    } else {
      result.setSuccess(false);
      result.setErrorMessage("You failed to upload " + name
          + " because the file was empty.");
      return result;
    }
  }

  /**
   *
   * @param files
   * @param type
   * @return
   */
  @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
  @ApiOperation(value = "同时上传多个文件接口", httpMethod = "POST", response = FileResult.class
      , responseContainer = "List", notes = "同时上传多个文件接口")
  public List<FileResult> uploadMultipleFileHandler(
      @ApiParam(required = true, name = "files", value = "文件列表") @RequestParam("files")
          MultipartFile[] files,
      @ApiParam(required = true, name = "type", value = "文件类型") @RequestParam("type")
          TransportType type) {

    return null;
  }
}
