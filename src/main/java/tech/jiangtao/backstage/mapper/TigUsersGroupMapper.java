package tech.jiangtao.backstage.mapper;

import java.util.List;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsersCustomVo;

/**
 * @class:  </br>
 * @description: 自定义查询 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 上午10:06</br>
 * @version: 0.0.1 </br>
 **/
public interface TigUsersGroupMapper {

  public List<TigPairs> queryMyGroups(String uid) throws Exception;
}
