package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigGroupMapper;
import tech.jiangtao.backstage.mapper.TigGroupMemberMapper;
import tech.jiangtao.backstage.model.TigGroup;
import tech.jiangtao.backstage.model.TigGroupExample;
import tech.jiangtao.backstage.model.TigGroupMember;
import tech.jiangtao.backstage.model.TigGroupMemberExample;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Authority;
import tech.jiangtao.backstage.model.json.GroupAccount;
import tech.jiangtao.backstage.service.TigGroupService;
import tech.jiangtao.backstage.service.TigUsersService;

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

  @Autowired
  private TigUsersService tigUsersService;

  /**
   * 创建群组
   *
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
   *
   * @throws Exception
   */
  @Override public List<GroupAccount> selectGroupMembers(String groupId, String userId)
      throws Exception {
    List<GroupAccount> groupAccounts = new ArrayList<>();
    TigGroupMemberExample queryMember = new TigGroupMemberExample();
    queryMember.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
    List<TigGroupMember> members = tigGroupMemberMapper.selectByExample(queryMember);
    if (members.size() > 0) {
      TigGroupMemberExample member = new TigGroupMemberExample();
      member.createCriteria().andGroupIdEqualTo(groupId);
      List<TigGroupMember> groupMembers = tigGroupMemberMapper.selectByExample(member);
      for (int i = 0; i < groupMembers.size(); i++) {
        TigGroupMember groupMember = groupMembers.get(i);
        Account account = tigUsersService.queryUser(groupMember.getUserId());
        GroupAccount groupAccount = new GroupAccount();
        BeanUtils.copyProperties(account, groupAccount);
        groupAccount.setAuthority(groupMember.getAuthority().intValue() > 0);
        groupAccounts.add(groupAccount);
      }
    }
    return groupAccounts;
  }

  /**
   * 获取我加入的群组
   *
   * @throws Exception
   */
  @Override public List<TigGroup> selectOwnGroup(String userId) throws Exception {
    List<TigGroup> groups = new ArrayList<>();
    TigGroupMemberExample queryMember = new TigGroupMemberExample();
    queryMember.createCriteria().andUserIdEqualTo(userId);
    List<TigGroupMember> members = tigGroupMemberMapper.selectByExample(queryMember);
    for (int i = 0; i < members.size(); i++) {
      TigGroupMember member = members.get(i);
      TigGroupExample example = new TigGroupExample();
      example.createCriteria().andGroupIdEqualTo(member.getGroupId());
      List<TigGroup> list = tigGroupMapper.selectByExample(example);
      if (list.size() > 0) {
        groups.add(list.get(0));
      }
    }
    return groups;
  }

  /**
   * 添加用户入群
   *
   * @throws Exception
   */
  @Override public List<GroupAccount> insertMember(List<String> accounts, String groupId,
      String userId)
      throws Exception {
    for (int i = 0; i < accounts.size(); i++) {
      String userInvitedId = accounts.get(i);
      TigGroupMember member = new TigGroupMember();
      member.setIsReceived(Byte.parseByte("1"));
      member.setAuthority(Byte.parseByte("0"));
      member.setGroupId(groupId);
      member.setUserId(userInvitedId);
      tigGroupMemberMapper.insert(member);
    }
    return selectGroupMembers(groupId, userId);
  }

  /**
   * 更新用户权限
   *
   * @throws Exception
   */
  @Override public List<GroupAccount> updateMember(int authority, String userId, String groupId)
      throws Exception {
    TigGroupMemberExample member = new TigGroupMemberExample();
    member.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
    List<TigGroupMember> members = tigGroupMemberMapper.selectByExample(member);
    if (members.size() > 0) {
      TigGroupMember groupMember = members.get(0);
      groupMember.setAuthority(Byte.parseByte("" + authority));
      tigGroupMemberMapper.updateByPrimaryKey(groupMember);
      return selectGroupMembers(groupId, userId);
    }
    return null;
  }

  @Override public Authority isReceived(String groupId, String userId) throws Exception {
    TigGroupMemberExample example = new TigGroupMemberExample();
    Authority authority = new Authority();
    example.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
    List<TigGroupMember> groupMembers = tigGroupMemberMapper.selectByExample(example);
    if (groupMembers.size() > 0) {
      TigGroupMember tigGroupMember = groupMembers.get(0);
      authority.setIsReceived(tigGroupMember.getIsReceived());
      authority.setAuthority(tigGroupMember.getAuthority());
    }
    return authority;
  }

  @Override public Authority updateIsReceived(String groupId, String userId) throws Exception {
    TigGroupMemberExample example = new TigGroupMemberExample();
    Authority authority = new Authority();
    example.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
    List<TigGroupMember> groupMembers = tigGroupMemberMapper.selectByExample(example);
    if (groupMembers.size() > 0) {
      TigGroupMember tigGroupMember = groupMembers.get(0);
      Byte isReceived = tigGroupMember.getIsReceived();
      if (isReceived.intValue() == 0) {
        tigGroupMember.setIsReceived(Byte.parseByte("1"));
      } else {
        tigGroupMember.setIsReceived(Byte.parseByte("0"));
      }
      tigGroupMemberMapper.updateByPrimaryKey(tigGroupMember);
      authority.setIsReceived(tigGroupMember.getIsReceived());
      authority.setAuthority(tigGroupMember.getAuthority());
    }
    return authority;
  }

  @Override
  public List<GroupAccount> deleteGroupMember(List<String> userIds, String groupId, String userId) {
    for (String s : userIds) {
      TigGroupMemberExample example = new TigGroupMemberExample();
      example.createCriteria().andUserIdEqualTo(s).andGroupIdEqualTo(groupId);
      tigGroupMemberMapper.deleteByExample(example);
    }
    try {
      return selectGroupMembers(groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
