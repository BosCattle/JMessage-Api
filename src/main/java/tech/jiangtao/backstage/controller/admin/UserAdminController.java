package tech.jiangtao.backstage.controller.admin;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tech.jiangtao.backstage.model.json.User;

/**
 * @class: UserAdminController </br>
 * @description: </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 13/04/2017 1:24 AM</br>
 * @version: 0.0.1 </br>
 **/
@Controller
@RequestMapping("/admin")
@Api(value = "管理员功能列表", tags = "管理员功能列表")
public class UserAdminController {

  @RequestMapping("/batchAddUser")
  public ModelAndView batchAddUser(@RequestParam("user") User user) {
    return new ModelAndView();
  }
}
