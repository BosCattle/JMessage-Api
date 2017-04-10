package tech.jiangtao.backstage.utils;

/**
 * @class: InviteType </br>
 * @description: 邀请类型 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 2:36 PM</br>
 * @version: 0.0.1 </br>
 **/
public enum  InviteType {

  FRIEND("friend"),
  GROUP("group");
  private final String text;

  /**
   * @param text
   */
  private InviteType(final String text) {
    this.text = text;
  }

  public static TransportType toTransportType(String textParam) {
    return TransportType.valueOf(textParam);
  }
}
