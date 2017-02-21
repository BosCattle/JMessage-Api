package tech.jiangtao.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.User;
import tech.jiangtao.backstage.service.UserService;

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
  public UserService userService;

  /**
   * 根据邮箱进行登录
   * @param nickname
   * @param email
   * @param password
   * @return
   */
  @RequestMapping(value="/login",method = RequestMethod.POST)
  public User login(@RequestParam String nickname,@RequestParam String email,@RequestParam String password){
    System.out.println("进入登录啦");
    User user = new User();
    user.setNickname(nickname);
    user.setPassword(password);
    user.setEmail(email);
    return user;
  }

  public User register(){
    return null;
  }
}
