package tech.jiangtao.backstage.model.json;

import java.io.Serializable;
import tech.jiangtao.backstage.utils.InviteType;
import tech.jiangtao.backstage.utils.SexType;

/**
 * @class: Account </br>
 * @description:  账户公共类 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/4/7 下午4:17</br>
 * @version: 0.0.1 </br>
 **/
public class Account implements Serializable {
  private Integer uid;
  private String userId;
  private String nickName;
  private String avatar;
  private boolean relative;
  private InviteType inviteType;
  private String signature;
  private SexType sex;

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public SexType getSex() {
    return sex;
  }

  public void setSex(SexType sex) {
    this.sex = sex;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public InviteType getInviteType() {
    return inviteType;
  }

  public void setInviteType(InviteType inviteType) {
    this.inviteType = inviteType;
  }

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
