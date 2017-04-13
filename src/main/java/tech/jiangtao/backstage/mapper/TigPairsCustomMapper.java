package tech.jiangtao.backstage.mapper;

import java.util.List;
import java.util.Map;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigUsersCustomVo;

/**
 * @class: </br>
 * @description: 自定义查询 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/29 上午10:06</br>
 * @version: 0.0.1 </br>
 **/
public interface TigPairsCustomMapper {

  public long insertPairsReturnKeys(TigPairs pairs) throws Exception;

  public TigPairs queryTigPairs(long uid) throws Exception;

  public void updateTigPairs(TigPairs pairs) throws Exception;

  public TigPairs queryTigPairsFromObject(TigPairs pairs) throws Exception;

  public List<TigPairs> queryTigPairsListByUidAndRoster(List<Long> uids) throws Exception;
}
