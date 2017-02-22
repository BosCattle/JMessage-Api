package tech.jiangtao.backstage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.mapper.UserMapper;
import tech.jiangtao.backstage.model.User;

/**
 * Class: UserServiceImpl </br>
 * Description: 用户服务 </br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:07 </br>
 * Update: 2017/2/21 11:07 </br>
 **/

@Service(value = "userService")
public class UserServiceImpl implements UserService{


  private UserMapper userMapper;

  @Autowired
  public void setUserMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public UserMapper getUserMapper() {
    return userMapper;
  }

  @Override public void save(String nickname, String password, String email) {
    User user = new User();
    user.setEmail(email);
    user.setNickname(nickname);
    user.setPassword(password);
    userMapper.save(user);
  }

  @Override public boolean update(String nickname, String password, String email) {
    User user = new User();
    user.setEmail(email);
    user.setNickname(nickname);
    user.setPassword(password);
    return userMapper.update(user);
  }

  @Override public boolean delete(int id) {
    return userMapper.delete(id);
  }

  @Override public User findById(int id) {
    return userMapper.findById(id);
  }

  @Override public List<User> findAll() {
    return userMapper.findAll();
  }
}
