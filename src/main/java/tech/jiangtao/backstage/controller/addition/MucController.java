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
import springfox.documentation.annotations.ApiIgnore;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.json.ChatRoom;
import tech.jiangtao.backstage.service.TigMucService;

/**
 * @class: GroupController </br>
 * @description: 聊天室</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午8:45</br>
 * @version: 0.0.1 </br>
 **/
@Api(value = "聊天室",description = "聊天室相关的接口",tags = "聊天室")
@ApiIgnore
@RestController
@RequestMapping("/muc")
public class MucController {

  @Autowired
  private TigMucService tigMucService;

  /**
   * 根据用户id查询用户加入的聊天室
   */
  @RequestMapping(value = "/joined", method = RequestMethod.GET)
  @ApiOperation(value = "根据用户uid查询用户加入的聊天室", httpMethod = "GET", response = ChatRoom.class,
      responseContainer = "List", notes = "根据用户id查询用户加入的聊天室")
  public @ResponseBody List<ChatRoom> joinedGroup(
      @ApiParam(required = true, name = "uid", value = "用户唯一标识userId") @RequestParam("uid")
          String uid) {
    try {
      return tigMucService.findOwnerGroups(uid);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据群名搜索群
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  @ApiOperation(value = "根据聊天室名搜索聊天室", httpMethod = "GET", response = ChatRoom.class,
      responseContainer = "List", notes = "根据聊天室名搜索聊天室")
  public @ResponseBody List<ChatRoom> searchRootName(
      @ApiParam(required = true, name = "roomName", value = "聊天室名") @RequestParam("roomName")
          String roomName) {
    try {
      return tigMucService.findSearchRootName(roomName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 更新群名
   */
  @RequestMapping(value = "/update/roomName", method = RequestMethod.POST)
  @ApiOperation(value = "更新聊天室名", httpMethod = "POST", response = ChatRoom.class,
      notes = "更新聊天室名")
  public @ResponseBody ChatRoom updateRoomName(
      @ApiParam(required = true, name = "roomName", value = "新聊天室名") @RequestParam("roomName")
          String roomName,
      @ApiParam(required = true, name = "nid", value = "聊天室id") @RequestParam("nid") String nid,
      @ApiParam(required = true, name = "userId", value = "用户id") @RequestParam("userId")
          String userId) {
    return null;
  }

  /**
   * 创建群
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "创建聊天室", httpMethod = "POST", response = ChatRoom.class,
      notes = "用户创建新的聊天室")
  public @ResponseBody ChatRoom createRoom(
      @ApiParam(required = true, name = "roomName", value = "聊天室名") @RequestParam("roomName")
          String roomName,
      @ApiParam(required = true, name = "uid", value = "聊天室uid") @RequestParam("uid") String uid,
      @ApiParam(required = true, name = "userId", value = "聊天室拥有者userId") @RequestParam("userId")
          String userId,
      @ApiParam(required = true, name = "groupMember", value = "聊天室成员userId")
      @RequestParam("groupMember")
          List<String> groupMember) {
    return null;
  }

  @RequestMapping(value = "/history", method = RequestMethod.POST)
  @ApiOperation(value = "获取聊天室的聊天历史记录", httpMethod = "POST", response = MucHistory.class,
      responseContainer = "List", notes = "获取聊天室聊天记录")
  public @ResponseBody List<MucHistory> findMucHistory(@ApiParam(required = true, name = "uid",
      value = "聊天室的唯一标识") @RequestParam("uid") String uid,
      @ApiParam(name = "page", value = "第几页") @RequestParam("page") int page) throws Exception {
    if (uid==null){
      return null;
    }
    return tigMucService.findMucHistory(uid,page);
  }
}
