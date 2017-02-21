package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import tech.jiangtao.backstage.model.User;

/**
 * Class: UserMapper </br>
 * Description: dao层的映射 </br>
 * Creator: jiang </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:22 </br>
 * Update: 2017/2/21 11:22 </br>
 **/
@Repository(value = "userMapper")
public interface UserMapper {

  void save(User user);

  boolean update(User user);

  boolean delete(int id);

  User findById(int id);

  List<User> findAll();
}
