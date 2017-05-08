package tech.jiangtao.backstage.model.json;

import java.io.Serializable;

/**
 * @class: TigPubsub </br>
 * @description: </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 16:42</br>
 * @version: 0.0.1 </br>
 **/
public class TigPubsub implements Serializable {

  private int id;
  private String channelName;
  private String[] bareJids;
  //Notification, CommonMessage, RichMedia
  private String pushType;
  private String body;
  private String message;
  private long date;
  // all,list
  private String valueType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public String[] getBareJids() {
    return bareJids;
  }

  public void setBareJids(String[] bareJids) {
    this.bareJids = bareJids;
  }

  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public void setPushType(String pushType) {
    this.pushType = pushType;
  }

  public String getPushType() {
    return pushType;
  }
}
