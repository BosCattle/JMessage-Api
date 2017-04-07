package tech.jiangtao.backstage.mapper;

import java.util.List;
import java.util.Map;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsersCustom;
import tech.jiangtao.backstage.model.TigUsersCustomVo;

/**
 * @class:  </br>
 * @description: 自定义查询 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 上午10:06</br>
 * @version: 0.0.1 </br>
 **/
public interface TigUsersCustomMapper {

  public List<TigUsersCustomVo> queryFriends(String uid) throws Exception;

  public List<TigUsersCustomVo> queryFriendsResult(List friends) throws Exception;

  public TigPairs allInvite(String userId) throws Exception;
}
