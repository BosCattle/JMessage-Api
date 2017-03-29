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
  private String activity;
  private String jid;
  private String group;
  private String subs;
  private String weight;
  private String preped;
  private String last_seen;
  private String name;

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public String getJid() {
    return jid;
  }

  public void setJid(String jid) {
    this.jid = jid;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getSubs() {
    return subs;
  }

  public void setSubs(String subs) {
    this.subs = subs;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getPreped() {
    return preped;
  }

  public void setPreped(String preped) {
    this.preped = preped;
  }

  public String getLast_seen() {
    return last_seen;
  }

  public void setLast_seen(String last_seen) {
    this.last_seen = last_seen;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
