package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.mapper.TigUsersGroupMapper;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigNodesExample;
import tech.jiangtao.backstage.model.TigPairs;
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

  @Override public List<Groups> findOwnerGroups(String uid) throws Exception {
    TigNodesExample example = new TigNodesExample();
    List<Groups> groups = new ArrayList<>();
    TigNodesExample.Criteria  criteria = example.createCriteria().andNodeLike("%muc%");
    List<TigNodes> tigNodes = tigNodesMapper.selectByExample(example);
    if (tigNodes.size()!=0){
      for(TigNodes node: tigNodes){
        Groups group = new Groups();
        group.setGroupUid(node.getNid()+"");
        group.setRoomName(node.getNode().substring(0,node.getNode().indexOf("@")));
        group.setNode(node.getNode());
        groups.add(group);
      }
    }
    return groups;
  }
}
