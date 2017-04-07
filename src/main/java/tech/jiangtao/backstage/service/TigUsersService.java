package tech.jiangtao.backstage.service;

import java.util.List;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Friends;

/**
 * @class: TigUsersService </br>
 * @description: 对用户的操作 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/28 下午4:21</br>
 * @version: 0.0.1 </br>
 **/
public interface TigUsersService {

  public List<TigUsers> queryUserList(String userId) throws Exception;

  public TigUsers queryUser(String userId) throws Exception;

  public List<Friends> queryUserFriends(String userId) throws Exception;

  public List<Account> allInvite(String userId) throws Exception;

  public List<Account> queryAccount(String userId) throws Exception;
}
