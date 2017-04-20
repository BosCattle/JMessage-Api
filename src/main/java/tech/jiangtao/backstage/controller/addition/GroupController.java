package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.TigGroup;
import tech.jiangtao.backstage.model.TigGroupMember;
import tech.jiangtao.backstage.model.json.Authority;
import tech.jiangtao.backstage.model.json.GroupAccount;
import tech.jiangtao.backstage.service.TigGroupService;

/**
 * @class: GroupController </br>
 * @description: 群组控制器 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 16/04/2017 3:04 AM</br>
 * @version: 0.0.1 </br>
 **/
@RestController
@Api(tags = "群组接口设计")
@RequestMapping("/group")
public class GroupController {

  @Autowired
  private TigGroupService tigGroupService;

  @RequestMapping("/create")
  @ApiOperation(value = "创建群组", httpMethod = "POST", response = TigGroup.class, notes = "创建群组")
  public @ResponseBody TigGroup createGroup(@RequestParam("groupId") String groupId,
      @RequestParam("userId") String userId, @RequestParam("name") String name, String avatar,
      String description) {
    try {
      return tigGroupService.insertGroup(groupId, userId, name, avatar, description);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/groupMember")
  @ApiOperation(value = "群成员列表", httpMethod = "POST", response = GroupAccount.class,
      responseContainer = "List", notes = "获取群成员列表")
  public List<GroupAccount> queryGroupAccount(@RequestParam("groupId") String groupId,
      @RequestParam("userId") String userId) {
    try {
      return tigGroupService.selectGroupMembers(groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/addMembers")
  @ApiOperation(value = "添加群用户", httpMethod = "POST", response = GroupAccount.class,
      responseContainer = "List")
  public @ResponseBody List<GroupAccount> addGroupAccount(
      @RequestParam("userInvitedId") List<String> tigGroupMembers,
      @RequestParam("userId") String userId, @RequestParam("groupId") String groupId) {
    try {
      return tigGroupService.insertMember(tigGroupMembers, groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/groups")
  @ApiOperation(value = "获取我加入的群", httpMethod = "POST")
  public @ResponseBody List<TigGroup> groups(@RequestParam String userId) {
    try {
      return tigGroupService.selectOwnGroup(userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/isReceived")
  @ApiOperation(value = "获取我在群中的权限，是否接收消息", httpMethod = "POST")
  public @ResponseBody Authority isReceived(@RequestParam("groupId") String groupId,
      @RequestParam("userId") String userId) {
    try {
      return tigGroupService.isReceived(groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/updateIsReceived")
  @ApiOperation(value = "修改我在群中的权限，是否接收消息", httpMethod = "POST")
  public @ResponseBody Authority updateIsReceived(@RequestParam("groupId") String groupId,
      @RequestParam("userId") String userId) {
    try {
      return tigGroupService.updateIsReceived(groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("/deleteMember")
  @ApiOperation(value = "删除群用户", httpMethod = "POST")
  public @ResponseBody List<GroupAccount> deleteMemberById(@RequestParam List<String> userIds,
      @RequestParam String groupId,
      @RequestParam String userId) {
    try {
      return tigGroupService.deleteGroupMember(userIds, groupId, userId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
