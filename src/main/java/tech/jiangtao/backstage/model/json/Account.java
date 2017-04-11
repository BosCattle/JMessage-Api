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
  private long uid;
  private long nid;
  private String userId;
  private String nickName;
  private String avatar;
  private boolean relative;
  private InviteType inviteType;
  private String signature;
  // 0: Nan 1:NV
  private boolean sex;

  public long getNid() {
    return nid;
  }

  public void setNid(long nid) {
    this.nid = nid;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public boolean getSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
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
