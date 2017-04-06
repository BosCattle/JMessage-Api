package tech.jiangtao.backstage.model.json;

import java.sql.Timestamp;
import java.util.List;

/**
 * @class: Groups </br>
 * @description: 群组 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午9:27</br>
 * @version: 0.0.1 </br>
 **/
public class Groups {

  public String creator;
  private Timestamp createDate;
  private Timestamp lastAccessDate;
  private String roomName;
  private String groupUid;
  private String owner;
  private List<User> members;
  private String node;

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  public String getGroupUid() {
    return groupUid;
  }

  public void setGroupUid(String groupUid) {
    this.groupUid = groupUid;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getLastAccessDate() {
    return lastAccessDate;
  }

  public void setLastAccessDate(Timestamp lastAccessDate) {
    this.lastAccessDate = lastAccessDate;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public List<User> getMembers() {
    return members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }
}
