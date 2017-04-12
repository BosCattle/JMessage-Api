package tech.jiangtao.backstage.model.json;

import java.io.Serializable;

/**
 * @class: User </br>
 * @description: 用户基类 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午9:38</br>
 * @version: 0.0.1 </br>
 **/
public class User extends Account implements Serializable {

  private int onlineStatus;

  public int getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(int onlineStatus) {
    this.onlineStatus = onlineStatus;
  }
}
