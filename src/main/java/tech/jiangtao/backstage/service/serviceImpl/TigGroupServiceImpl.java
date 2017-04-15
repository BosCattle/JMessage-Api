package tech.jiangtao.backstage.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigGroupMapper;
import tech.jiangtao.backstage.mapper.TigGroupMemberMapper;
import tech.jiangtao.backstage.model.TigGroup;
import tech.jiangtao.backstage.model.TigGroupExample;
import tech.jiangtao.backstage.model.TigGroupMember;
import tech.jiangtao.backstage.model.json.GroupAccount;
import tech.jiangtao.backstage.service.TigGroupService;

/**
 * @class: TigGroupServiceImpl </br>
 * @description: </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 16/04/2017 3:04 AM</br>
 * @version: 0.0.1 </br>
 **/
@Service("tigGroupService")
public class TigGroupServiceImpl implements TigGroupService {

  @Autowired
  private TigGroupMapper tigGroupMapper;

  @Autowired
  private TigGroupMemberMapper tigGroupMemberMapper;

  /**
   * 创建群组
   * @param groupId
   * @param userId
   * @param name
   * @param avatar
   * @param description
   * @return
   * @throws Exception
   */
  @Override
  public TigGroup insertGroup(String groupId, String userId, String name, String avatar,
      String description)
      throws Exception {
    TigGroup group = new TigGroup();
    group.setGroupId(groupId);
    group.setName(name);
    group.setAvatar(avatar);
    group.setDescription(description);
    tigGroupMapper.insert(group);
    TigGroupMember tigGroupMember = new TigGroupMember();
    tigGroupMember.setUserId(userId);
    tigGroupMember.setGroupId(groupId);
    tigGroupMember.setIsReceived(Byte.parseByte("1"));
    tigGroupMember.setAuthority(Byte.parseByte("1"));
    tigGroupMemberMapper.insert(tigGroupMember);
    TigGroupExample example = new TigGroupExample();
    example.createCriteria().andGroupIdEqualTo(groupId);
    List<TigGroup> groups = tigGroupMapper.selectByExample(example);
    return groups.get(0);
  }

  /**
   * 获取群用户列表
   * @param groupId
   * @param userId
   * @return
   * @throws Exception
   */
  @Override public List<GroupAccount> selectGroupMembers(String groupId, String userId)
      throws Exception {

    return null;
  }

  /**
   * 获取我加入的群组
   * @param userId
   * @return
   * @throws Exception
   */
  @Override public List<TigGroup> selectOwnGroup(String userId) throws Exception {
    return null;
  }

  /**
   * 添加用户入群
   * @param accounts
   * @return
   * @throws Exception
   */
  @Override public List<GroupAccount> insertMember(List<String> accounts) throws Exception {
    return null;
  }
}
