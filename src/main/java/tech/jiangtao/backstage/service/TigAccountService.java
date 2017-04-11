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

  /**
   * 创建用户
   * @param userJid
   * @param nickName
   * @param avatar
   * @param sex
   * @param signature
   * @param password
   * @return
   * @throws Exception
   */
  public Account insertAccount(String userJid, String nickName, String avatar, String sex,
      String signature,String password) throws Exception;
}
