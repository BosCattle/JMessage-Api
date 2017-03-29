package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.XML;
import org.leibnizcenter.xml.TerseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersCustomVo;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.model.json.Friends;
import tech.jiangtao.backstage.service.TigUsersService;

/**
 * @class: TigUsersServiceImpl </br>
 * @description: 对用户的操作</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/28 下午4:24</br>
 * @version: 0.0.1 </br>
 **/

@Service("tigUsersService")
public class TigUsersServiceImpl implements TigUsersService {

  private static final TerseJson.WhitespaceBehaviour COMPACT_WHITE_SPACE =
      TerseJson.WhitespaceBehaviour.Compact;

  @Autowired
  private TigUsersMapper tigUsersMapper;

  @Autowired
  private TigUsersCustomMapper tigUsersCustomMapper;

  /**
   * 根据用户id搜索用户
   *
   * @throws Exception
   */
  @Override public List<TigUsers> queryUserList(String userId) throws Exception {
    TigUsersExample userCustom = new TigUsersExample();
    userCustom.createCriteria().andUserIdLike("%" + userId + "%");
    return tigUsersMapper.selectByExample(userCustom);
  }

  /**
   * 获取用户自己的信息
   *
   * @throws Exception
   */
  @Override public TigUsers queryUser(String userId) throws Exception {
    TigUsersExample example = new TigUsersExample();
    TigUsersExample.Criteria criteriaexample = example.createCriteria().andUserIdEqualTo(userId);
    List<TigUsers> tigUserses = tigUsersMapper.selectByExample(example);
    return tigUserses.get(0);
  }

  @Override public List<Friends> queryUserFriends(String userId) throws Exception {
    TigUsers tigUsers = queryUser(userId);
    List<TigUsersCustomVo> usersCustomVos = null;
    // 保存的jid和key
    ArrayList friends = new ArrayList();
    if (tigUsers != null && tigUsers.getUid() != null) {
      usersCustomVos = tigUsersCustomMapper.queryFriends(tigUsers.getUid().toString());
      for (TigUsersCustomVo vo : usersCustomVos) {
        JSONObject json = XML.toJSONObject(vo.getTigUsersCustom().getPval(), true);
        vo.getTigUsersCustom().setPval(json.toString());
        JSONObject object = json.getJSONObject("contact");
        friends.add(vo.getTigUsersCustom().getUid());
        System.out.println(vo.getTigUsersCustom().getUid());
      }
      //根据jid查询vcard
      if (friends.isEmpty()) {
        return null;
      }
      usersCustomVos = tigUsersCustomMapper.queryFriendsResult(friends);
      List<Friends> list = new ArrayList<>();
      for (TigUsersCustomVo user : usersCustomVos) {
        JSONObject json = XML.toJSONObject(user.getTigUsersCustom().getPval(), true);
        user.getTigUsersCustom().setPval(json.toString());
        JSONObject object = json.getJSONObject("vCard");
        Friends friend = new Friends();
        friend.setNickName(object.getString("NICKNAME"));
        friend.setOnlineStatus(user.getTigUsers().getOnlineStatus());
        friend.setUserId(user.getTigUsers().getUserId());
        list.add(friend);
      }
      return list;
    }
    return null;
  }
}
