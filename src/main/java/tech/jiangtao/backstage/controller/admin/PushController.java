package tech.jiangtao.backstage.controller.admin;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Result;
import tech.jiangtao.backstage.service.PushService;

/**
 * @class: PushController </br>
 * @description: 推送功能控制器 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 08/05/2017 15:24</br>
 * @version: 0.0.1 </br>
 **/
@RestController
public class PushController {

  private Logger logger = Logger.getLogger(PushController.class);

  @Autowired
  private PushService pushService;

  @RequestMapping(value = "/push", method = RequestMethod.POST)
  public @ResponseBody Result pushMessage(@RequestParam("type") String type,
      @RequestParam("message") String message, String[] userIds) {
    logger.log(Priority.DEBUG, type);
    logger.log(Priority.DEBUG, message);
    logger.log(Priority.DEBUG, userIds);
    Result result = null;
    try {
      result = pushService.push(type, message, userIds);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
