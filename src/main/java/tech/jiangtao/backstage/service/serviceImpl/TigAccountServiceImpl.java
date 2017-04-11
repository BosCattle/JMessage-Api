package tech.jiangtao.backstage.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigPairsCustomMapper;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.service.TigAccountService;
import tech.jiangtao.backstage.utils.SexType;

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

  /**
   * 先插node，再插pair
   *
   * @throws Exception
   */
  @Override public Account insertAccount(String userJid, String nickName, String avatar, String sex,
      String signature, String password) throws Exception {
    Account acount = new Account();
    // 在user表中插入数据，并且在node表中插入了roster节点，即contact节点信息。
    HashMap<String, String> paramMap = new HashMap<>();
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
    buffer.append("<SEX>" + sex + "</SEX>");
    buffer.append("<SIGNATURE>" + signature + "</SIGNATURE>");
    buffer.append("<SIGNATURE>" + signature + "</SIGNATURE>");
    buffer.append("</vCard>");
    System.out.println(buffer.toString());
    TigPairs pair = new TigPairs();
    pair.setNid(nid);
    pair.setUid(uid);
    pair.setPkey("vCard");
    pair.setPval(buffer.toString());
    tigPairsMapper.insert(pair);
    acount.setUid(uid);
    acount.setNid(nid);
    acount.setUserId(userJid);
    acount.setAvatar(avatar);
    acount.setNickName(nickName);
    acount.setSex(!sex.equals("男"));
    acount.setSignature(signature);
    return acount;
  }
}
