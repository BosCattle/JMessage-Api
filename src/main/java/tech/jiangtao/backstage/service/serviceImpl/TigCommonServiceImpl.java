package tech.jiangtao.backstage.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigMaMsgsCustomMapper;
import tech.jiangtao.backstage.model.TigGroupMessage;
import tech.jiangtao.backstage.model.TigMaMsgsWithBLOBs;
import tech.jiangtao.backstage.model.json.MessageRealm;
import tech.jiangtao.backstage.service.TigCommonService;

/**
 * @class: TigCommonServiceImpl </br>
 * @description: 公共模块 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 10:16</br>
 * @version: 0.0.1 </br>
 **/
@Service("tigCommonService")
public class TigCommonServiceImpl implements TigCommonService {

  public final String USERID = "userId";
  public final String OTHERSIDEID = "otherSideId";
  public final String GROUPID = "groupId";
  public final String OFFSET = "offset";
  public final String LIMIT = "limit";
  public final String TIMESTAMP = "timestamp";
  public final String ID = "id";
  public final String FROM = "from";
  public final String TO = "to";
  public final String THREAD = "thread";
  public final String MESSAGE_TYPE = "message_type";
  public final String TYPE = "type";

  @Autowired
  private TigMaMsgsCustomMapper tigMaMsgsCustomMapper;

  /**
   * 单聊查询聊天历史
   *
   * @param userId 用户自己的id
   * @param otherSideId 聊天对方的jid
   * @param page 页数
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryChatHistory(String userId, String otherSideId, int page,long timestamp)
      throws Exception {
    Map<String, java.io.Serializable> map = new HashMap<>();
    int single = 100;
    int offset = page * single + 1;
    int limit = (page + 1) * single;
    Date date = new Date(timestamp);
    String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    map.put(USERID, userId);
    map.put(OTHERSIDEID, otherSideId);
    map.put(OFFSET, offset);
    map.put(LIMIT, limit);
    System.out.println(formatDate);
    map.put(TIMESTAMP, formatDate);
    List<MessageRealm> messages = new ArrayList<>();
    List<TigMaMsgsWithBLOBs> tigMamsg = tigMaMsgsCustomMapper.queryChatHistory(map);
    // 解析消息
    for (TigMaMsgsWithBLOBs msg : tigMamsg) {
      MessageRealm msgRealm = new MessageRealm();
      JSONObject element = XML.toJSONObject(msg.getMsg(), true);
      JSONObject object = element.getJSONObject("message");
      msgRealm.setId(object.optString(ID));
      msgRealm.setSender(object.optString(FROM));
      msgRealm.setReceiver(object.optString(TO));
      msgRealm.setTextMessage(msg.getBody());
      msgRealm.setTime(msg.getTs());
      msgRealm.setThread(object.optString(THREAD));
      msgRealm.setMessageExtensionType(0);
      msgRealm.setMessageStatus(true);
      msgRealm.setType("chat");
      try {
        JSONObject typeObject = object.getJSONObject(MESSAGE_TYPE);
        msgRealm.setMessageType(typeObject.optString(TYPE));
      } catch (JSONException e) {
        msgRealm.setMessageType("text");
      }
      messages.add(msgRealm);
    }
    return messages;
  }

  /**
   * 根据日期查询聊天历史
   *
   * @param date 时间戳
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryChatHistoryByDate(long date, String userId, String otherSideId,
      int page) throws Exception {
    return null;
  }

  /**
   * 查询群聊聊天历史
   *
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryGroupChatHistory(String userId, String groupId, int page)
      throws Exception {
    Map<String, java.io.Serializable> map = new HashMap<>();
    int single = 100;
    int offset = page * single + 1;
    int limit = (page + 1) * single;
    map.put(USERID, userId);
    map.put(GROUPID, groupId);
    map.put(OFFSET, offset);
    map.put(LIMIT, limit);
    List<MessageRealm> messages = new ArrayList<>();
    List<TigGroupMessage> tigMamsg = tigMaMsgsCustomMapper.queryGroupChatHistory(map);
    // 解析消息
    for (TigGroupMessage msg : tigMamsg) {
      MessageRealm msgRealm = new MessageRealm();
      JSONObject element = XML.toJSONObject(msg.getElement(), true);
      JSONObject object = element.getJSONObject("message");
      msgRealm.setId(object.optString(ID));
      msgRealm.setSender(object.optString(TO));
      msgRealm.setReceiver(object.optString(FROM));
      msgRealm.setGroupId(object.optString(FROM));
      msgRealm.setTextMessage(msg.getBody());
      msgRealm.setTime(msg.getTimestamp());
      msgRealm.setThread(object.optString(THREAD));
      msgRealm.setMessageExtensionType(0);
      msgRealm.setMessageStatus(true);
      msgRealm.setType("chat");
      try {
        JSONObject typeObject = object.getJSONObject(MESSAGE_TYPE);
        msgRealm.setMessageType(typeObject.optString(TYPE));
      } catch (JSONException e) {
        msgRealm.setMessageType("text");
      }
      messages.add(msgRealm);
    }
    return messages;
  }

  /**
   * 根据群聊消息查看聊天历史
   *
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryGroupChatHistoryByDate(long date, String userId, String groupId,
      int page) throws Exception {
    return null;
  }
}
