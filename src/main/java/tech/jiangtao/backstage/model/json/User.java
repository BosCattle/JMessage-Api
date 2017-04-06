package tech.jiangtao.backstage.model.json;

/**
 * @class: User </br>
 * @description: 用户基类 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午9:38</br>
 * @version: 0.0.1 </br>
 **/
public class User {

  private String userId;
  private int onlineStatus;
  private String nickName;
  private String avatar;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(int onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
