package tech.jiangtao.backstage.utils;

/**
 * @class: Authorization </br>
 * @description:  认证过程的一些常量值</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/4/1 上午11:20</br>
 * @version: 0.0.1 </br>
 **/
public class Authorization {

  /**
   * token有效期（小时）
   */
  public static final int TOKEN_EXPIRES_HOUR = 72;

  /**
   * 存放Authorization的header字段
   */
  public static final String AUTHORIZATION = "Authorization";

  /**
   * 存储当前登录用户id的字段名
   */
  public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
}
