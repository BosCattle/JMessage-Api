package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Friends;

/**
 * @class: CommonController </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 12/04/2017 4:52 AM</br>
 * @version: 0.0.1 </br>
 **/

@Api(value = "公共模块",description = "聊天记录，群记录等公共模块",tags = "公共模块")
@RestController
@RequestMapping("/common")
public class CommonController {

  @RequestMapping(value = "/queryChatHistory", method = RequestMethod.GET)
  @ApiOperation(value = "根据用户userId获取聊天历史", httpMethod = "POST", response = Friends.class,
      responseContainer = "List", notes = "根据用户userId获取聊天历史")
  public @ResponseBody List<Friends> queryUserList(
      @ApiParam(required = true, name = "userId", value = "用户userId") @RequestParam("userId") String userId,
      @ApiParam(required = true, name = "otherSideId", value = "对方的jid，群聊即填写群聊的jid") @RequestParam("otherSideId") String otherSideId)
      throws Exception {
    return null;
  }
}
