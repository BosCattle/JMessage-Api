package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import tech.jiangtao.backstage.mapper.TigMaMsgsCustomMapper;
import tech.jiangtao.backstage.model.TigMaMsgsWithBLOBs;
import tech.jiangtao.backstage.model.json.MessageRealm;
import tech.jiangtao.backstage.service.TigCommonService;
import tigase.xml.Element;

/**
 * @class: TigCommonServiceImpl </br>
 * @description: 公共模块 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 10:16</br>
 * @version: 0.0.1 </br>
 **/
public class TigCommonServiceImpl implements TigCommonService {

  public final String USERID = "userId";
  public final String OTHERSIDEID = "otherSideId";
  public final String OFFSET = "offset";
  public final String LIMIT = "limit";
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
   * @param offset 开始未知
   * @param limit 长度
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryChatHistory(String userId, String otherSideId, int offset,
      int limit) throws Exception {
    Map<String, java.io.Serializable> map = new HashMap<>();
    map.put(USERID, userId);
    map.put(OTHERSIDEID, otherSideId);
    map.put(OFFSET, offset);
    map.put(LIMIT, limit);
    List<MessageRealm> messages = new ArrayList<>();
    List<TigMaMsgsWithBLOBs> tigMamsg = tigMaMsgsCustomMapper.queryChatHistory(map);
    // 解析消息
    for (TigMaMsgsWithBLOBs msg : tigMamsg) {
      MessageRealm msgRealm = new MessageRealm();
      Element element = new Element(msg.getMsg());
      Map<String, String> attrMap = element.getAttributes();
      msgRealm.setId(attrMap.get(ID));
      msgRealm.setSender(attrMap.get(FROM));
      msgRealm.setReceiver(attrMap.get(TO));
      msgRealm.setTextMessage(msg.getBody());
      msgRealm.setTime(msg.getTs());
      msgRealm.setThread(element.getChild(THREAD).getCData());
      msgRealm.setMessageExtensionType(0);
      msgRealm.setMessageStatus(true);
      msgRealm.setMessageType(element.getChild(MESSAGE_TYPE).getChild(TYPE).getCData());
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
      int offset, int limit) throws Exception {
    return null;
  }

  /**
   * 查询群聊聊天历史
   *
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryGroupChatHistory(String userId, String groupId, int offset,
      int limit) throws Exception {
    return null;
  }

  /**
   * 根据群聊消息查看聊天历史
   *
   * @throws Exception
   */
  @Override
  public List<MessageRealm> queryGroupChatHistoryByDate(long date, String userId, String groupId,
      int offset, int limit) throws Exception {
    return null;
  }
}
