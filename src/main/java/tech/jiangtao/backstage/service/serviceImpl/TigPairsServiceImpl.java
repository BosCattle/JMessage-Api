package tech.jiangtao.backstage.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigPairsExample;
import tech.jiangtao.backstage.service.TigPairsService;

/**
 * @class: TigPairsServiceImpl </br>
 * @description: </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 12/04/2017 8:32 PM</br>
 * @version: 0.0.1 </br>
 **/

@Service("tigPairsService")
public class TigPairsServiceImpl implements TigPairsService {

  @Autowired
  private TigPairsMapper tigPairsMapper;

  @Override public TigPairs queryTigPairs(long uid, String pkey) throws Exception {
    TigPairsExample example = new TigPairsExample();
    example.createCriteria().andUidEqualTo(uid).andPkeyEqualTo(pkey);
    List<TigPairs> tigPairs = tigPairsMapper.selectByExample(example);
    if (tigPairs == null || tigPairs.size() == 0) {
      return null;
    }
    return tigPairs.get(0);
  }
}
