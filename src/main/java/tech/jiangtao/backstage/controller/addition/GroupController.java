package tech.jiangtao.backstage.controller.addition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Groups;
import tech.jiangtao.backstage.service.TigGroupService;

/**
 * @class: GroupController </br>
 * @description:  群组</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午8:45</br>
 * @version: 0.0.1 </br>
 **/
@RestController
@RequestMapping("/group")
public class GroupController {

  @Autowired
  private TigGroupService tigGroupService;
  /**
   * 根据用户id查询用户加入的群组
   * @param uid
   */
  @RequestMapping("/joined")
  public @ResponseBody List<Groups> joinedGroup(String uid){
    try {
      return tigGroupService.findOwnerGroups(uid);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据群名搜索群
   * @param rootName
   * @return
   */
  @RequestMapping("/search")
  public @ResponseBody List<Groups> searchRootName(String rootName){
    try {
      return tigGroupService.findSearchRootName(rootName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 更新群名
   * @param roomName
   * @return
   */
  @RequestMapping("/update/roomName")
  public @ResponseBody Groups updateRoomName(String roomName,String nid){
    return null;
  }

  /**
   *
   * @param name
   * @param uid
   * @return 返回群组信息，创建群
   */
  @RequestMapping("/create")
  public @ResponseBody Groups createRoom(String name,String uid){
    return null;
  }
}
