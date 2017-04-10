package tech.jiangtao.backstage.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersCustomVo;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Friends;
import tech.jiangtao.backstage.service.TigUsersService;
import tech.jiangtao.backstage.utils.InviteType;

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
    if (tigUserses!=null&&tigUserses.size()>0){
      return tigUserses.get(0);
    }
    return null;
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

  @Override public List<Account> allInvite(String userId) throws Exception {
    TigPairs tigPairs = tigUsersCustomMapper.allInvite(userId);
    List<Account> accounts = new ArrayList<>();
    JSONObject json = XML.toJSONObject(tigPairs.getPval(), true);
    JSONArray array = json.getJSONArray("contact");
    for (int i=0;i<array.length();i++){
      JSONObject object = (JSONObject) array.get(i);
      Account account = new Account();
      account.setNickName(object.getString("name"));
      account.setUserId(object.getString("jid"));
      account.setRelative(false);
      account.setAvatar(null);
      account.setInviteType(InviteType.FRIEND);
      accounts.add(account);
    }
    return accounts;
  }

  @Override public List<Account> queryAccount(String nickname) throws Exception {
    List<Account> accounts = new ArrayList<>();
    TigUsersExample example = new TigUsersExample();
    TigUsersExample.Criteria criteriaexample = example.createCriteria().andUserIdLike("%"+nickname+"%");
    List<TigUsers> tigUserses = tigUsersMapper.selectByExample(example);
    if (tigUserses!=null&&tigUserses.size()>0){
     for (TigUsers users:tigUserses){
       Account account = new Account();
       account.setAvatar(null);
       account.setNickName(users.getUserId().substring(0,users.getUserId().indexOf("@")));
       account.setUserId(users.getUserId());
       account.setRelative(false);
       accounts.add(account);
     }
    }
    return accounts;
  }
}
