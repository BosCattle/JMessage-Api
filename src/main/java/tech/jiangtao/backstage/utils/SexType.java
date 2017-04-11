package tech.jiangtao.backstage.utils;

/**
 * @class: InviteType </br>
 * @description: 性别类型 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 2:36 PM</br>
 * @version: 0.0.1 </br>
 **/
public enum SexType {

  MAN("男"),
  WOMAN("女");
  private final String text;

  /**
   * @param text
   */
  private SexType(final String text) {
    this.text = text;
  }

  public static TransportType toTransportType(String textParam) {
    return TransportType.valueOf(textParam);
  }
}
