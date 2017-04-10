package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.json.Groups;
import tech.jiangtao.backstage.service.TigGroupService;

/**
 * @class: GroupController </br>
 * @description: 群组</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午8:45</br>
 * @version: 0.0.1 </br>
 **/
@Api(value = "群组")
@RestController
@RequestMapping("/group")
public class GroupController {

  @Autowired
  private TigGroupService tigGroupService;

  /**
   * 根据用户id查询用户加入的群组
   */
  @RequestMapping(value = "/joined", method = RequestMethod.GET)
  @ApiOperation(value = "根据用户uid查询用户加入的群组", httpMethod = "GET", response = Groups.class,
      responseContainer = "List", notes = "根据用户id查询用户加入的群组")
  public @ResponseBody List<Groups> joinedGroup(
      @ApiParam(required = true, name = "uid", value = "用户唯一标识userId") @RequestParam("uid")
          String uid) {
    try {
      return tigGroupService.findOwnerGroups(uid);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据群名搜索群
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  @ApiOperation(value = "根据群名搜索群", httpMethod = "GET", response = Groups.class,
      responseContainer = "List", notes = "根据群名搜索群")
  public @ResponseBody List<Groups> searchRootName(
      @ApiParam(required = true, name = "roomName", value = "群名") @RequestParam("roomName")
          String roomName) {
    try {
      return tigGroupService.findSearchRootName(roomName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 更新群名
   */
  @RequestMapping(value = "/update/roomName", method = RequestMethod.POST)
  @ApiOperation(value = "更新群名", httpMethod = "POST", response = Groups.class,
      notes = "更新群名")
  public @ResponseBody Groups updateRoomName(
      @ApiParam(required = true, name = "roomName", value = "新群名") @RequestParam("roomName")
          String roomName,
      @ApiParam(required = true, name = "nid", value = "群id") @RequestParam("nid") String nid,
      @ApiParam(required = true, name = "userId", value = "用户id") @RequestParam("userId")
          String userId) {
    return null;
  }

  /**
   * 创建群
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "创建群", httpMethod = "POST", response = Groups.class,
      notes = "用户创建新的群聊")
  public @ResponseBody Groups createRoom(
      @ApiParam(required = true, name = "roomName", value = "群名") @RequestParam("roomName")
          String roomName,
      @ApiParam(required = true, name = "uid", value = "群uid") @RequestParam("uid") String uid,
      @ApiParam(required = true, name = "userId", value = "群拥有者userId") @RequestParam("userId")
          String userId,
      @ApiParam(required = true, name = "groupMember", value = "群成员userId")
      @RequestParam("groupMember")
          List<String> groupMember) {
    return null;
  }

  @RequestMapping(value = "/history", method = RequestMethod.POST)
  @ApiOperation(value = "获取群聊的聊天历史记录", httpMethod = "POST", response = MucHistory.class,
      responseContainer = "List", notes = "获取群聊天记录")
  public @ResponseBody List<MucHistory> findMucHistory(@ApiParam(required = true, name = "uid",
      value = "群的唯一标识") @RequestParam("uid") String uid,
      @ApiParam(name = "page", value = "第几页") @RequestParam("page") int page) throws Exception {
    if (uid==null){
      return null;
    }
    return tigGroupService.findMucHistory(uid,page);
  }
}
