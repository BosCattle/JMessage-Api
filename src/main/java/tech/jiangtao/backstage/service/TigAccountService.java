package tech.jiangtao.backstage.service;

import tech.jiangtao.backstage.model.json.Account;

/**
 * @class: TigAccountService </br>
 * @description: 账户相关</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 11/04/2017 1:04 PM</br>
 * @version: 0.0.1 </br>
 **/
public interface TigAccountService {

  public Account createAccount(String userJid, String nickName, String avatar, String sex,
      String signature,String password) throws Exception;
}
