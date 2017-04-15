package tech.jiangtao.backstage.service;

import java.util.List;
import tech.jiangtao.backstage.model.TigGroup;
import tech.jiangtao.backstage.model.TigGroupMember;
import tech.jiangtao.backstage.model.json.GroupAccount;

/**
 * @class: TigGroupService </br>
 * @description: 群聊service </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 16/04/2017 3:03 AM</br>
 * @version: 0.0.1 </br>
 **/
public interface TigGroupService {

  // 创建群组
  public TigGroup insertGroup(String groupId, String userId, String name, String avatar,
      String description)
      throws Exception;

  // 获取群中的用户
  public List<GroupAccount> selectGroupMembers(String groupId, String userId) throws Exception;

  // 获取我加入的群组
  public List<TigGroup> selectOwnGroup(String userId) throws Exception;

  // 添加用户入群
  public List<GroupAccount> insertMember(List<TigGroupMember> accounts) throws Exception;

  // 修改用户在群中的权限
  public List<GroupAccount> updateMember(List<TigGroupMember> tigGroupMembers) throws Exception;


}
