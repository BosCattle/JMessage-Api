package tech.jiangtao.backstage.model.json;

import java.util.Date;

/**
 * @class: MessageRealm </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 09:49</br>
 * @version: 0.0.1 </br>
 **/

public class MessageRealm {

  public String id;
  // message_from
  public String sender;
  // message_to
  public String receiver;

  public String groupId;
  // 消息内容
  public String textMessage;
  // 暂时保留时间戳，备用
  public Date time;
  // 暂时保留，thread_id
  public String thread;
  // 具体到聊天类型
  public String type;
  // 消息类型
  public String messageType;
  // 消息状态 true: 表示已读，false:表示未读
  public boolean messageStatus;
  // 消息拓展类型，包含单聊，群聊，推送
  public int messageExtensionType;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getTextMessage() {
    return textMessage;
  }

  public void setTextMessage(String textMessage) {
    this.textMessage = textMessage;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getThread() {
    return thread;
  }

  public void setThread(String thread) {
    this.thread = thread;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public boolean isMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(boolean messageStatus) {
    this.messageStatus = messageStatus;
  }

  public int getMessageExtensionType() {
    return messageExtensionType;
  }

  public void setMessageExtensionType(int messageExtensionType) {
    this.messageExtensionType = messageExtensionType;
  }
}
