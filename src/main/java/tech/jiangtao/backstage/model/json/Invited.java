package tech.jiangtao.backstage.model.json;

/**
 * @class: Invited </br>
 * @description:  邀请</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 12/04/2017 4:07 PM</br>
 * @version: 0.0.1 </br>
 **/
public class Invited {

  public Account account;
  public Groups group;

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Groups getGroup() {
    return group;
  }

  public void setGroup(Groups group) {
    this.group = group;
  }
}
