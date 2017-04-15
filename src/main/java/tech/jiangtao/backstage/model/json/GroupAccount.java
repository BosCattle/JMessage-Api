package tech.jiangtao.backstage.model.json;

import java.io.Serializable;

/**
 * @class: GroupAccount </br>
 * @description: 群账户 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 16/04/2017 4:14 AM</br>
 * @version: 0.0.1 </br>
 **/
public class GroupAccount extends Account implements Serializable {

  public boolean authority;

  public boolean isAuthority() {
    return authority;
  }

  public void setAuthority(boolean authority) {
    this.authority = authority;
  }
}
