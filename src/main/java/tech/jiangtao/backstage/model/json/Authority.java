package tech.jiangtao.backstage.model.json;

import java.io.Serializable;

/**
 * @class: Authority </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 18/04/2017 9:15 PM</br>
 * @version: 0.0.1 </br>
 **/
public class Authority implements Serializable {
  public int authority;
  public int isReceived;

  public int getAuthority() {
    return authority;
  }

  public void setAuthority(int authority) {
    this.authority = authority;
  }

  public int getIsReceived() {
    return isReceived;
  }

  public void setIsReceived(int isReceived) {
    this.isReceived = isReceived;
  }
}
