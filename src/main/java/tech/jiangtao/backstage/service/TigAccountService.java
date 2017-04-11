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
   *
   * @throws Exception
   */
  public Account insertAccount(String userJid, String nickName, String avatar, boolean sex,
      String signature, String password) throws Exception;

  /**
   * 更新用户信息
   * @param nickName
   * @param avatar
   * @param sex
   * @param signature
   * @return
   * @throws Exception
   */
  public Account updateAccount(long uid,String userJid,String nickName, String avatar, boolean sex, String signature)
      throws Exception;
}
