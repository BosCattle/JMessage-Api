package tech.jiangtao.backstage.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersExample;
import tech.jiangtao.backstage.service.TigUsersService;

/**
 * @class: TigUsersServiceImpl </br>
 * @description: 对用户的操作</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/28 下午4:24</br>
 * @version: 0.0.1 </br>
 **/

@Service("tigUsersServiceImpl")
public class TigUsersServiceImpl implements TigUsersService {

  @Autowired
  private TigUsersMapper tigUsersMapper;

  /**
   * 根据用户id搜索用户
   * @param userId
   * @return
   * @throws Exception
   */
  @Override public List<TigUsers> queryUserList(String userId) throws Exception {
    TigUsersExample userCustom = new TigUsersExample();
    userCustom.createCriteria().andUserIdLike("%" + userId + "%");
    return tigUsersMapper.selectByExample(userCustom);
  }
}
