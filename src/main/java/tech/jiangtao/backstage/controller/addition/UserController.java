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
   * 根据id查询用户
   */
  @RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
  public @ResponseBody List<TigUsers> queryUserList(@RequestParam("userId") String userId) {
    try {
      return tigUsersService.queryUserList(userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
