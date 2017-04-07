package tech.jiangtao.backstage.controller.addition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersCustomVo;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Friends;
import tech.jiangtao.backstage.service.TigUsersService;

/**
 * Class: UserController </br>
 * Description: 接口层次 </br>
 * Creator: jiang </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  public TigUsersService tigUsersService;

  /**
   * 根据id查询用户的好友
   * @param userId
   * @return 返回用户的好友信息
   * @throws Exception
   */
  @RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
  public @ResponseBody List<Friends> queryUserList(@RequestParam("userId") String userId)
      throws Exception {
    return tigUsersService.queryUserFriends(userId);
  }

  @RequestMapping(value = "/queryUser",method = RequestMethod.POST)
  public @ResponseBody TigUsers queryUser(String userId) throws Exception{
    return tigUsersService.queryUser(userId);
  }

  /**
   * 获取我的所有邀请
   * @param userId
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/allInvite")
  public @ResponseBody List<Account> allInvite(String userId) throws Exception{
    return tigUsersService.allInvite(userId);
  }

  /**
   * 根据昵称查询用户
   * @param nickname
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/queryAccount")
  public List<Account> queryAccount(String nickname) throws Exception{
    return tigUsersService.queryAccount(nickname);
  }
}
