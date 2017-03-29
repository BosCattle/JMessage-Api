package tech.jiangtao.backstage.model;

import org.json.JSONObject;
import org.json.XML;

/**
 * @class: TigUsersCustomVo </br>
 * @description: 处理数据库返回结果 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 上午11:55</br>
 * @version: 0.0.1 </br>
 **/
public class TigUsersCustomVo {

  private TigUsers tigUsers;
  private TigUsersCustom tigUsersCustom;

  public TigUsers getTigUsers() {
    return tigUsers;
  }

  public void setTigUsers(TigUsers tigUsers) {
    this.tigUsers = tigUsers;
  }

  public TigUsersCustom getTigUsersCustom() {
    return tigUsersCustom;
  }

  public void setTigUsersCustom(TigUsersCustom tigUsersCustom) {
    this.tigUsersCustom = tigUsersCustom;
  }
}
