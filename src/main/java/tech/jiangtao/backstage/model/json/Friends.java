package tech.jiangtao.backstage.model.json;

/**
 * @class: Friends </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 下午4:11</br>
 * @version: 0.0.1 </br>
 **/
public class Friends extends Account{

  private int onlineStatus;

  public int getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(int onlineStatus) {
    this.onlineStatus = onlineStatus;
  }
}
