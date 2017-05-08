package tech.jiangtao.backstage.service;

import tech.jiangtao.backstage.model.json.Result;

/**
 * @class: PushService </br>
 * @description: 推送服务 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 08/05/2017 15:42</br>
 * @version: 0.0.1 </br>
 **/
public interface PushService {

  public Result push(String type, String message, String[] userIds) throws Exception;
}
