package tech.jiangtao.backstage.model.json;

/**
 * @class: Contact </br>
 * @description: 通讯录vCard信息 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 下午12:10</br>
 * @version: 0.0.1 </br>
 **/

@Deprecated
public class Contact {
  private String jid;

  private int activity;

  private String subs;

  private String preped;

  private String name;

  private int weight;

  private int lastSeen;

  public void setJid(String jid) {
    this.jid = jid;
  }

  public String getJid() {
    return this.jid;
  }

  public void setActivity(int activity) {
    this.activity = activity;
  }

  public int getActivity() {
    return this.activity;
  }

  public void setSubs(String subs) {
    this.subs = subs;
  }

  public String getSubs() {
    return this.subs;
  }

  public void setPreped(String preped) {
    this.preped = preped;
  }

  public String getPreped() {
    return this.preped;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getWeight() {
    return this.weight;
  }

  public void setLastSeen(int lastSeen) {
    this.lastSeen = lastSeen;
  }

  public int getLastSeen() {
    return this.lastSeen;
  }
}
