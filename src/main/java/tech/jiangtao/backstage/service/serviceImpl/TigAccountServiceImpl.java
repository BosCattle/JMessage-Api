package tech.jiangtao.backstage.service.serviceImpl;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.mapper.TigPairsCustomMapper;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.redis.TokenManager;
import tech.jiangtao.backstage.model.json.TokenModel;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.vCard;
import tech.jiangtao.backstage.service.TigAccountService;
import tech.jiangtao.backstage.utils.MD5Utils;

/**
 * @class: TigAccountServiceImpl </br>
 * @description: 账户相关服务 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 11/04/2017 1:07 PM</br>
 * @version: 0.0.1 </br>
 **/
@Service("tigAccountService")
public class TigAccountServiceImpl implements TigAccountService {

  @Autowired
  private TigUsersCustomMapper tigUsersCustomMapper;

  @Autowired
  private TigUsersMapper tigUsersMapper;

  @Autowired
  private TigPairsCustomMapper tigPairsCustomMapper;

  @Autowired
  private TigNodesMapper tigNodesMapper;

  @Autowired
  private TigPairsMapper tigPairsMapper;

  @Autowired
  private TokenManager tokenManager;

  /**
   * 先插node，再插pair
   *
   * @throws Exception
   */
  @Override public Account insertAccount(String userJid, String nickName, String avatar,
      boolean sex,
      String signature, String password) throws Exception {
    Account account = new Account();
    // 在user表中插入数据，并且在node表中插入了roster节点，即contact节点信息。
    HashMap<String, String> paramMap = new HashMap<>();
    // 对密码进行解密
    //String psd = MD5Utils.decrypt(password,MD5Utils.getDESKey(userJid.getBytes()),userJid);
    paramMap.put("uid", userJid);
    paramMap.put("password", password);
    tigUsersCustomMapper.insertUser(paramMap);
    TigUsersExample example = new TigUsersExample();
    example.createCriteria().andUserIdEqualTo(userJid);
    List<TigUsers> users = tigUsersMapper.selectByExample(example);
    long uid = users.get(0).getUid();
    //然后将nid返回，得到nid后，插入tig_nodes中
    //key: nid parent_nid  uid node
    //value: nid null uid vcard-temp
    long nid = tigUsersCustomMapper.selectMaxNid();
    nid += 1;
    TigNodes nodes = new TigNodes();
    nodes.setNid(nid);
    nodes.setParentNid(null);
    nodes.setUid(uid);
    nodes.setNode("vcard-temp");
    tigNodesMapper.insert(nodes);
    // 拿到uid，在tig_pair中插入
    //key:    nid             uid     pkey    pval
    //value:  获取到最大值+1    uid      vCard   xml字符串(<vCard xmlns="vcard-temp"><NICKNAME>vurtex</NICKNAME></vCard>)
    StringBuffer buffer = new StringBuffer();
    buffer.append("<vCard xmlns=\"vcard-temp\">");
    buffer.append("<NICKNAME>" + nickName + "</NICKNAME>");
    buffer.append("<AVATAR>" + avatar + "</AVATAR>");
    buffer.append("<SEX>" + (sex ? "女" : "男") + "</SEX>");
    buffer.append("<SIGNATURE>" + signature + "</SIGNATURE>");
    buffer.append("</vCard>");
    System.out.println(buffer.toString());
    TigPairs pair = new TigPairs();
    pair.setNid(nid);
    pair.setUid(uid);
    pair.setPkey("vCard");
    pair.setPval(buffer.toString());
    tigPairsMapper.insert(pair);
    account.setUid(uid);
    account.setNid(nid);
    account.setUserId(userJid);
    account.setAvatar(avatar);
    account.setNickName(nickName);
    account.setSex(sex);
    account.setSignature(signature);
    TokenModel model = tokenManager.createToken(new Long(account.getNid()).intValue());
    account.setToken(model.getToken());
    return account;
  }

  @Override
  public Account updateAccount(long uid, String userJid, String nickName, String avatar,
      boolean sex,
      String signature)
      throws Exception {
    TigPairs pairs = tigPairsCustomMapper.queryTigPairs(uid);
    String pval = pairs.getPval();
    System.out.println(pval);
    // <vCard xmlns="vcard-temp"><NICKNAME>巴巴</NICKNAME>
    // <AVATAR>http://blog.dhds.ds.png</AVATAR><SEX>男</SEX>
    // <SIGNATURE>低年级的那份激动地那你发</SIGNATURE></vCard>
    JSONObject object = XML.toJSONObject(pval);
    JSONObject vCardObject = object.getJSONObject("vCard");
    Gson gson = new Gson();
    vCard vCard = gson.fromJson(vCardObject.toString(), vCard.class);
    if (avatar != null) {
      vCard.setAVATAR(avatar);
    }
    if (nickName != null) {
      vCard.setNICKNAME(nickName);
    }
    if (sex) {
      vCard.setSEX(sex ? "女" : "男");
    }
    if (signature != null) {
      vCard.setSIGNATURE(signature);
    }
    StringBuffer buffer = new StringBuffer();
    buffer.append("<vCard xmlns=\"vcard-temp\">");
    buffer.append("<NICKNAME>" + vCard.getNICKNAME() + "</NICKNAME>");
    buffer.append("<AVATAR>" + vCard.getAVATAR() + "</AVATAR>");
    buffer.append("<SEX>" + vCard.getSEX() + "</SEX>");
    buffer.append("<SIGNATURE>" + vCard.getSIGNATURE() + "</SIGNATURE>");
    buffer.append("</vCard>");
    // 更新vCard;
    pairs.setPval(buffer.toString());
    tigPairsCustomMapper.updateTigPairs(pairs);
    Account account = new Account();
    account.setNid(pairs.getNid());
    account.setUid(uid);
    account.setNickName(vCard.getNICKNAME());
    account.setSignature(vCard.getSIGNATURE());
    account.setAvatar(vCard.AVATAR);
    if (vCard.getSEX() != null && !Objects.equals(vCard.getSEX(), "")) {
      account.setSex(!vCard.getSEX().equals("男"));
    } else {
      account.setSex(false);
    }
    account.setUserId(userJid);
    return account;
  }
}
