package tech.jiangtao.backstage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tech.jiangtao.backstage.model.json.TokenModel;
import tech.jiangtao.backstage.redis.TokenManager;
import tech.jiangtao.backstage.utils.Authorization;

/**
 * @class: AuthorizationInterceptor </br>
 * @description: 自定义author拦截器</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/4/1 上午11:18</br>
 * @version: 0.0.1 </br>
 **/
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

  private static final String REGISTER = "/create";

  @Autowired
  private TokenManager tokenManager;

  private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (true) {
      return true;
    }
    logger.debug("enter the interceptor");
    if (!(handler instanceof HandlerMethod)
        || request.getRequestURI().contains(REGISTER)) {
      logger.debug("enter the interceptor1");
      return true;
    }
    String authorization = request.getHeader(Authorization.AUTHORIZATION);
    // 根据authorization获取到tokenmodel对象
    TokenModel model = tokenManager.getToken(authorization);
    // 检查两个token
    if (tokenManager.checkToken(model)) {
      //如果token验证成功，将token对应的用户id存在request中，便于之后注入
      logger.debug("enter the interceptor2");
      request.setAttribute(Authorization.CURRENT_USER_ID, model.getUserId());
      return true;
    } else {
      logger.debug("enter the interceptor3");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }

  @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    // 异常处理器
  }
}
