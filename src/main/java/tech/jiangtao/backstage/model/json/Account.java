package tech.jiangtao.backstage.model.json;

import java.io.Serializable;

/**
 * @class: Account </br>
 * @description:  账户公共类 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/4/7 下午4:17</br>
 * @version: 0.0.1 </br>
 **/
public class Account implements Serializable {
  private String userId;
  private String nickName;
  private String avatar;
  private boolean relative;

  public void setRelative(boolean relative) {
    this.relative = relative;
  }

  public boolean isRelative() {
    return relative;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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
