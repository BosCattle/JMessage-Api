package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.beanutils.NestedNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.MucHistoryMapper;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.MucHistoryExample;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigNodesExample;
import tech.jiangtao.backstage.model.json.Groups;
import tech.jiangtao.backstage.service.TigGroupService;

/**
 * @class: TigGroupServiceImpl </br>
 * @description: 群组操作 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午9:43</br>
 * @version: 0.0.1 </br>
 **/
@Service("tigGroupService")
public class TigGroupServiceImpl implements TigGroupService {

  @Autowired
  private TigNodesMapper tigNodesMapper;

  @Autowired
  private MucHistoryMapper mucHistoryMapper;

  @Override public List<Groups> findOwnerGroups(String uid) throws Exception {
    TigNodesExample example = new TigNodesExample();
    List<Groups> groups = new ArrayList<>();
    TigNodesExample.Criteria criteria = example.createCriteria().andNodeLike("%muc%");
    List<TigNodes> tigNodes = tigNodesMapper.selectByExample(example);
    return pushGroups(tigNodes);
  }

  /**
   * 搜索群
   * @param roomName
   * @return
   * @throws Exception
   */
  @Override public List<Groups> findSearchRootName(String roomName) throws Exception {
    if (roomName==null|| Objects.equals(roomName, "")){
      return null;
    }
    TigNodesExample example = new TigNodesExample();
    example.createCriteria().andNodeLike("%"+roomName+"%");
    List<TigNodes> tigNodes = tigNodesMapper.selectByExample(example);
    return pushGroups(tigNodes);
  }

  /**
   * 消息历史
   * @param uid
   * @param page
   * @return
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
   * 生产group
   * @param tigNodes
   * @return
   */
  public List<Groups> pushGroups(List<TigNodes> tigNodes){
    List<Groups> groups = new ArrayList<>();
    if (tigNodes.size() > 0) {
      for (TigNodes node : tigNodes) {
        Groups group = new Groups();
        group.setGroupUid(node.getNid() + "");
        group.setRoomName(node.getNode().substring(0, node.getNode().indexOf("@")));
        group.setNode(node.getNode());
        groups.add(group);
      }
    }
    return groups;
  }
}
