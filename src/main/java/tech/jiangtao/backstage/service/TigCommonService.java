package tech.jiangtao.backstage.service;

import java.util.List;
import tech.jiangtao.backstage.model.json.MessageRealm;

/**
 * @class: TigCommonService </br>
 * @description: 公共服务接口 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 09:45</br>
 * @version: 0.0.1 </br>
 **/
public interface TigCommonService {

  public List<MessageRealm> queryChatHistory(String userId, String otherSideId, int offset,
      int limit) throws Exception;

  public List<MessageRealm> queryChatHistoryByDate(long date, String userId, String otherSideId,
      int offset,
      int limit) throws Exception;

  public List<MessageRealm> queryGroupChatHistory(String userId, String groupId, int offset,
      int limit) throws Exception;

  public List<MessageRealm> queryGroupChatHistoryByDate(long date, String userId, String groupId,
      int offset,
      int limit) throws Exception;
}
