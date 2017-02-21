package tech.jiangtao.backstage.service;

import java.util.List;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.model.User;

/**
 * Class: UserService </br>
 * Description:  UserService</br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 10:19 </br>
 * Update: 2017/2/21 10:19 </br>
 **/
public interface UserService {

  void save(String nickname,String password,String email);

  boolean update(String nickname,String password,String email);

  boolean delete(int id);

  User findById(int id);

  List<User> findAll();
}
