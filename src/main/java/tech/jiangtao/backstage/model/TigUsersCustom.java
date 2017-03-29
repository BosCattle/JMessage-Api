package tech.jiangtao.backstage.model;

import tech.jiangtao.backstage.model.json.Contact;

/**
 * @class: TigUsersCustomMapper </br>
 * @description:  自定义用户查询的model</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 上午10:03</br>
 * @version: 0.0.1 </br>
 **/
public class TigUsersCustom extends TigPairs {

  private Contact contact;

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
