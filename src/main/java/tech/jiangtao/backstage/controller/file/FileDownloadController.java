package tech.jiangtao.backstage.controller.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.io.OutputStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import tech.jiangtao.backstage.model.json.Friends;

/**
 * Class: FileDownloadController </br>
 * Description: 文件下载接口 </br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
@Api(value = "文件下载", description = "文件下载模块", tags = "文件下载模块")
@RestController
@RequestMapping("/file")
public class FileDownloadController {

  private static final Logger logger = LoggerFactory
      .getLogger(FileUploadController.class);

  @RequestMapping(value = "/download/{resourceId}", method = RequestMethod.POST)
  @ApiOperation(value = "根据resourceId获取文件", httpMethod = "POST",
      notes = "根据resourceId获取文件")
  @ApiImplicitParam(name = "resourceId",value = "资源id",required = true)
  public @ResponseBody void download(@PathVariable("resourceId") String resourceId) {

  }
}
