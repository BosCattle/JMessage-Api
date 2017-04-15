package tech.jiangtao.backstage.service;

import java.util.List;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.json.ChatRoom;

/**
 * @class: TigMucService </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午8:50</br>
 * @version: 0.0.1 </br>
 **/
public interface TigMucService {

  /**
   * 得到自己的聊天室
   * @param uid
   * @return
   * @throws Exception
   */
  public List<ChatRoom> findOwnerGroups(String uid) throws Exception;

  /**
   * 根据群名搜索
   * @param rootName
   * @return
   * @throws Exception
   */
  public List<ChatRoom> findSearchRootName(String rootName) throws Exception;

  /**
   * 根据群uid获取历史消息
   * @param uid
   * @return
   * @throws Exception
   */
  public List<MucHistory> findMucHistory(String uid,int page) throws Exception;
}
