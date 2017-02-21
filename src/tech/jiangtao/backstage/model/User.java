package tech.jiangtao.backstage.model;

/**
 * Class: User </br>
 * Description: 用户  </br>
 * Creator: Kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 10:09 </br>
 * Update: 2017/2/21 10:09 </br>
 **/
public class User {
  public int id;
  public String nickname;
  public String email;
  public String password;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
