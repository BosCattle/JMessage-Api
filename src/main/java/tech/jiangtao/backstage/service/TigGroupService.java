package tech.jiangtao.backstage.service;

import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.json.Groups;

/**
 * @class: TigGroupService </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/31 下午8:50</br>
 * @version: 0.0.1 </br>
 **/
public interface TigGroupService {

  /**
   * 得到自己的群组
   * @param uid
   * @return
   * @throws Exception
   */
  public List<Groups> findOwnerGroups(String uid) throws Exception;

  /**
   * 根据群名搜索
   * @param rootName
   * @return
   * @throws Exception
   */
  public List<Groups> findSearchRootName(String rootName) throws Exception;

  /**
   * 根据群uid获取历史消息
   * @param uid
   * @return
   * @throws Exception
   */
  public List<MucHistory> findMucHistory(String uid,int page) throws Exception;
}
