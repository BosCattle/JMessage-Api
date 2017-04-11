package tech.jiangtao.backstage.model.json;

/**
 * @class: vCard </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 11/04/2017 8:28 PM</br>
 * @version: 0.0.1 </br>
 **/
public class vCard {
  public String xmlns;
  public String NICKNAME;
  public String AVATAR;
  public String SEX;
  public String SIGNATURE;

  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public String getNICKNAME() {
    return NICKNAME;
  }

  public void setNICKNAME(String NICKNAME) {
    this.NICKNAME = NICKNAME;
  }

  public String getAVATAR() {
    return AVATAR;
  }

  public void setAVATAR(String AVATAR) {
    this.AVATAR = AVATAR;
  }

  public String getSEX() {
    return SEX;
  }

  public void setSEX(String SEX) {
    this.SEX = SEX;
  }

  public String getSIGNATURE() {
    return SIGNATURE;
  }

  public void setSIGNATURE(String SIGNATURE) {
    this.SIGNATURE = SIGNATURE;
  }
}
