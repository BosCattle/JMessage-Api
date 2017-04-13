package tech.jiangtao.backstage.service.serviceImpl;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigPairsCustomMapper;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersCustomVo;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Contact;
import tech.jiangtao.backstage.model.json.Friends;
import tech.jiangtao.backstage.model.json.Groups;
import tech.jiangtao.backstage.model.json.Invited;
import tech.jiangtao.backstage.model.json.Result;
import tech.jiangtao.backstage.model.json.vCard;
import tech.jiangtao.backstage.service.TigPairsService;
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

  @Autowired
  private TigPairsMapper tigPairsMapper;

  @Autowired
  private TigPairsCustomMapper tigPairsCustomMapper;

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
  @Override public Account queryUser(String userId) throws Exception {
    TigUsers users = queryUsers(userId);
    Account account = new Account();
    if (users == null) {
      return null;
    }
    TigPairs tigPairs = tigPairsCustomMapper.queryTigPairs(users.getUid());
    if (tigPairs == null) {
      return null;
    }
    JSONObject object = XML.toJSONObject(tigPairs.getPval());
    JSONObject vCardObject = object.getJSONObject("vCard");
    Gson gson = new Gson();
    vCard vCard = gson.fromJson(vCardObject.toString(), vCard.class);
    account.setUserId(userId);
    account.setUid(users.getUid());
    account.setNid(tigPairs.getNid());
    if (vCard.getSEX() != null && !Objects.equals(vCard.getSEX(), "")) {
      if (vCard.getSEX().equals("男")) {
        account.setSex(false);
      } else {
        account.setSex(true);
      }
    }
    account.setAvatar(vCard.getAVATAR());
    account.setNickName(vCard.getNICKNAME());
    account.setSignature(vCard.getSIGNATURE());
    return account;
  }

  /**
   * 根据用户userId,得到{@link TigUsers}
   */
  public TigUsers queryUsers(String userId) {
    TigUsersExample example = new TigUsersExample();
    TigUsersExample.Criteria criteriaexample = example.createCriteria().andUserIdEqualTo(userId);
    List<TigUsers> tigUsers = tigUsersMapper.selectByExample(example);
    if (tigUsers != null && tigUsers.size() > 0) {
      return tigUsers.get(0);
    }
    return null;
  }

  @Override public List<Friends> queryUserFriends(String userId) throws Exception {
    TigUsers tigUsers = queryUsers(userId);
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
        friend.setNickName(object.optString("NICKNAME"));
        friend.setSignature(object.optString("SIGNATURE"));
        friend.setAvatar(object.optString("AVATAR"));
        friend.setSex(object.optString("SEX").equals("女"));
        friend.setOnlineStatus(user.getTigUsers().getOnlineStatus());
        friend.setUserId(user.getTigUsers().getUserId());
        friend.setUid(user.getTigUsers().getUid());
        friend.setNid(user.getTigUsersCustom().getNid());
        list.add(friend);
      }
      return list;
    }
    return null;
  }

  @Override public List<Invited> allInvite(String userId) throws Exception {
    TigPairs tigPairs = tigUsersCustomMapper.allInvite(userId);
    List<Invited> accounts = new ArrayList<>();
    JSONObject json = XML.toJSONObject(tigPairs.getPval(), true);
    Object objects = new JSONTokener(json.optString("contact")).nextValue();
    if (objects instanceof JSONObject) {
      JSONObject object = json.getJSONObject("contact");
      Account account = new Account();
      Invited invited = new Invited();
      account.setNickName(object.getString("name"));
      account.setUserId(object.getString("jid"));
      account.setRelative(false);
      account.setAvatar(null);
      account.setInviteType(InviteType.FRIEND);
      invited.setAccount(account);
      Groups groups = new Groups();
      invited.setGroup(groups);
      accounts.add(invited);
    } else if (objects instanceof JSONArray) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        JSONObject object = (JSONObject) array.get(i);
        Account account = new Account();
        Invited invited = new Invited();
        account.setNickName(object.getString("name"));
        account.setUserId(object.getString("jid"));
        account.setRelative(false);
        account.setAvatar(null);
        account.setInviteType(InviteType.FRIEND);
        invited.setAccount(account);
        Groups groups = new Groups();
        invited.setGroup(groups);
        accounts.add(invited);
      }
    }

    return accounts;
  }

  @Override public List<Account> queryAccount(String nickname) throws Exception {
    List<Account> accounts = new ArrayList<>();
    TigUsersExample example = new TigUsersExample();
    example.createCriteria().andUserIdLike("%" + nickname + "%");
    List<TigUsers> tigUserses = tigUsersMapper.selectByExample(example);
    List<Long> ids = new ArrayList<>();
    for (TigUsers pairs : tigUserses) {
      ids.add(pairs.getUid());
    }
    List<TigPairs> uids = tigPairsCustomMapper.queryTigPairsListByUidAndRoster(ids);
    for (TigPairs pairs : uids) {
      String pval = pairs.getPval();
      JSONObject object = XML.toJSONObject(pval);
      JSONObject vCardObject = object.getJSONObject("vCard");
      Gson gson = new Gson();
      vCard vCard = gson.fromJson(vCardObject.toString(), vCard.class);
      Account account = new Account();
      for (TigUsers user : tigUserses) {
        if (Objects.equals(pairs.getUid(), user.getUid())) {
          account.setUserId(user.getUserId());
        }
      }
      account.setSex(vCard.getSEX() != null && vCard.getSEX().equals("女"));
      account.setNid(pairs.getNid());
      account.setUid(pairs.getUid());
      account.setSignature(vCard.getSIGNATURE());
      account.setNickName(vCard.getNICKNAME());
      account.setAvatar(vCard.getAVATAR());
      account.setRelative(false);
      accounts.add(account);
    }
    return accounts;
  }

  @Override public Result deleteFriend(long uid, String userId) throws Exception {
    TigPairs tigPairs = new TigPairs();
    tigPairs.setUid(uid);
    tigPairs.setPkey("roster");
    TigPairs queryTigPairs = tigPairsCustomMapper.queryTigPairsFromObject(tigPairs);
    // 转化roster->删除掉userJid的contact->保存到数据库中
    // 1. 转换roster
    JSONObject roster = XML.toJSONObject(queryTigPairs.getPval());
    JSONArray array = roster.getJSONArray("contact");
    for (int size = 0; size < array.length(); size++) {
      JSONObject object = new JSONObject(array.getJSONObject(size));
      if (object.getString("jid").equals(userId)) {

      }
    }
    // 2. 删除掉

    // 3. 保存到数据库

    return new Result(true, "执行成功");
  }
}
