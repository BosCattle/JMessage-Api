package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.MucHistoryMapper;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.MucHistoryExample;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigNodesExample;
import tech.jiangtao.backstage.model.json.ChatRoom;
import tech.jiangtao.backstage.service.TigMucService;

/**
 * @class: TigMucServiceImpl </br>
 * @description: 聊天室操作 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午9:43</br>
 * @version: 0.0.1 </br>
 **/
@Service("tigMucService")
public class TigMucServiceImpl implements TigMucService {

  @Autowired
  private TigNodesMapper tigNodesMapper;

  @Autowired
  private MucHistoryMapper mucHistoryMapper;

  @Override public List<ChatRoom> findOwnerGroups(String uid) throws Exception {
    TigNodesExample example = new TigNodesExample();
    List<ChatRoom> groups = new ArrayList<>();
    TigNodesExample.Criteria criteria = example.createCriteria().andNodeLike("%muc%");
    List<TigNodes> tigNodes = tigNodesMapper.selectByExample(example);
    return pushGroups(tigNodes);
  }

  /**
   * 搜索聊天室
   *
   * @throws Exception
   */
  @Override public List<ChatRoom> findSearchRootName(String roomName) throws Exception {
    if (roomName == null || Objects.equals(roomName, "")) {
      return null;
    }
    TigNodesExample example = new TigNodesExample();
    example.createCriteria().andNodeLike("%" + roomName + "%");
    List<TigNodes> tigNodes = tigNodesMapper.selectByExample(example);
    return pushGroups(tigNodes);
  }

  /**
   * 消息历史
   *
   * @throws Exception
   */
  // TODO: 10/04/2017 暂时就这样
  @Override public List<MucHistory> findMucHistory(String uid, int page) throws Exception {
    MucHistoryExample example = new MucHistoryExample();
    List<MucHistory> mucHistories;
    example.createCriteria().andRoomNameEqualTo(uid);
    mucHistories = mucHistoryMapper.selectByExample(example);
    return mucHistories;
  }

  /**
   * 生产聊天室
   */
  public List<ChatRoom> pushGroups(List<TigNodes> tigNodes) {
    List<ChatRoom> groups = new ArrayList<>();
    if (tigNodes.size() > 0) {
      for (TigNodes node : tigNodes) {
        ChatRoom group = new ChatRoom();
        group.setGroupUid(node.getNid() + "");
        group.setRoomName(node.getNode().substring(0, node.getNode().indexOf("@")));
        group.setNode(node.getNode());
        groups.add(group);
      }
    }
    return groups;
  }
}
