package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Friends;
import tech.jiangtao.backstage.model.json.Invited;
import tech.jiangtao.backstage.model.json.Result;
import tech.jiangtao.backstage.service.TigUsersService;

/**
 * Class: UserController </br>
 * Description: 接口层次 </br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
@Api(value = "用户", description = "与用户相关的接口", tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  public TigUsersService tigUsersService;

  /**
   * 根据id查询用户的好友
   *
   * @return 返回用户的好友信息
   * @throws Exception
   */
  @RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
  @ApiOperation(value = "根据用户userId获取用户好友列表", httpMethod = "POST", response = Friends.class,
      responseContainer = "List", notes = "根据用户userId获取用户好友列表")
  public @ResponseBody List<Friends> queryUserList(
      @ApiParam(required = true, name = "userId", value = "用户userId") @RequestParam("userId")
          String userId) {
    try {
      return tigUsersService.queryUserFriends(userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据用户jid查询用户自己的信息
   *
   * @throws Exception
   */
  @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
  @ApiOperation(value = "查询用户自己信息", httpMethod = "POST", response = Account.class,
      notes = "根据userId查询自己信息")
  public @ResponseBody Account queryUser(
      @ApiParam(required = true, name = "userId", value = "用户userId")
      @RequestParam("userId") String userId) throws Exception {
    return tigUsersService.queryUser(userId);
  }

  /**
   * 获取我的所有邀请
   *
   * @throws Exception
   */
  @RequestMapping(value = "/allInvite", method = RequestMethod.POST)
  @ApiOperation(value = "根据userId获取我的请求", httpMethod = "POST", response = Account.class,
      responseContainer = "List", notes = "根据用户userId获取我所有的邀请，比如好友邀请，群邀请等")
  public @ResponseBody List<Invited> allInvite(@ApiParam(required = true, name = "userId",
      value = "用户userId") @RequestParam("userId") String userId) throws Exception {
    return tigUsersService.allInvite(userId);
  }

  /**
   * 根据昵称查询用户
   *
   * @throws Exception
   */
  @RequestMapping(value = "/queryAccount", method = RequestMethod.GET)
  @ApiOperation(value = "根据昵称查询用户", httpMethod = "GET", response = Account.class,
      responseContainer = "List", notes = "根据用户昵称查询用户信息")
  public @ResponseBody List<Account> queryAccount(
      @ApiParam(required = true, name = "nickname", value = "用户昵称")
      @RequestParam("nickname") String nickname) throws Exception {
    return tigUsersService.queryAccount(nickname);
  }

  /**
   * 删除好友
   */
  @RequestMapping(value = "/deleteFriend", method = RequestMethod.POST)
  @ApiOperation(value = "删除好友", httpMethod = "POST", response = Result.class,
      notes = "根据用户uid和好友userId删除好友")
  public @ResponseBody Result deleteFriend(
      @ApiParam(required = true, name = "uid", value = "用户uid")
      @RequestParam("uid") long uid,
      @ApiParam(required = true, name = "userId", value = "好友userId")
      @RequestParam("userId") String userId) {
    try {
      return tigUsersService.deleteFriend(uid, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
