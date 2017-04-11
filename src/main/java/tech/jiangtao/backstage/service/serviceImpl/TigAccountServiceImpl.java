package tech.jiangtao.backstage.service.serviceImpl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.mapper.TigUsersCustomMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigPairs;
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
  private TigUsersCustomMapper  tigUsersCustomMapper;

  @Autowired
  private TigUsersMapper tigUsersMapper;

  @Autowired
  private TigNodesMapper tigNodesMapper;

  @Autowired
  private TigPairsMapper tigPairsMapper;

  @Override public Account createAccount(String userJid, String nickName, String avatar, String sex,
      String signature,String password) throws Exception {
    Account acount = new Account();
    // 在user表中插入数据，并且在node表中插入了roster节点，即contact节点信息。
    HashMap<String, String> paramMap = new HashMap<>();
    paramMap.put("uid",userJid);
    paramMap.put("password",password);
    int uid = tigUsersCustomMapper.addUser(paramMap);
    acount.setUserId(userJid);
    // 拿到uid，在tig_pair中插入
    //key:    nid             uid     pkey    pval
    //value:  获取到最大值+1    uid      vCard   xml字符串(<vCard xmlns="vcard-temp"><NICKNAME>vurtex</NICKNAME></vCard>)
    StringBuffer buffer = new StringBuffer();
    buffer.append("<vCard xmlns='vcard-temp'>");
    buffer.append("<NICKNAME>"+nickName+"</NICKNAME>");
    buffer.append("<AVATAR>"+avatar+"</AVATAR>");
    buffer.append("<SEX>"+sex+"</SEX>");
    buffer.append("<SIGNATURE>"+signature+"</SIGNATURE>");
    buffer.append("<SIGNATURE>"+signature+"</SIGNATURE>");
    buffer.append("</vCard>");
    int nid = tigUsersCustomMapper.selectMaxNid();
    TigPairs pair = new TigPairs();
    pair.setNid((long) nid);
    pair.setUid((long) uid);
    pair.setPkey("vCard");
    pair.setPval(buffer.toString());
    tigPairsMapper.insert(pair);
    //然后将nid返回，得到nid后，插入tig_nodes中
    //key: nid parent_nid  uid node
    //value: nid null uid vcard-temp
    TigNodes nodes = new TigNodes();
    nodes.setNid((long) nid);
    nodes.setParentNid(null);
    nodes.setUid((long) uid);
    nodes.setNode("vcard-temp");
    tigNodesMapper.insert(nodes);
    acount.setUid(uid);
    acount.setUserId(userJid);
    acount.setAvatar(avatar);
    acount.setNickName(nickName);
    acount.setSex(SexType.valueOf(sex));
    acount.setSignature(signature);
    return acount;
  }
}
