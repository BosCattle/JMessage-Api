package tech.jiangtao.backstage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;
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
public class UserAdminController {

  @RequestMapping(value = "/batchAddUser",method = RequestMethod.POST)
  public ModelAndView batchAddUser(@RequestParam("user") User user) {
    return new ModelAndView();
  }

  @RequestMapping(value = "/login",method = RequestMethod.GET)
  public String login(Model model,User user) {
    model.addAttribute("user",user);
    return "login";
  }

  @RequestMapping(value = "/",method = RequestMethod.GET)
  public String index(Model model) {
    return "index";
  }
}
