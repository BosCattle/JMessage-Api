package tech.jiangtao.backstage.redis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import tech.jiangtao.backstage.model.json.TokenModel;
import tech.jiangtao.backstage.utils.Authorization;

/**
 * @class: TokenManagerImpl </br>
 * @description: Token管理器实现 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/4/1 上午11:27</br>
 * @version: 0.0.1 </br>
 **/
@Component
public class TokenManagerImpl implements TokenManager {

  @Autowired
  private RedisTemplate<Integer, String> redisTemplate;

  @Override public TokenModel createToken(Integer userId) {
    String token = UUID.randomUUID().toString().replace("-","");
    TokenModel model = new TokenModel(userId,token);
    int id = userId;
    redisTemplate.boundValueOps(id).set(token, Authorization.TOKEN_EXPIRES_HOUR, TimeUnit.DAYS);
    return model;
  }

  @Override public boolean checkToken(TokenModel model) {
    if (model==null){
      return false;
    }
    String token = redisTemplate.boundValueOps(model.getUserId()).get();
    if (token==null||token.isEmpty()||!token.equals(model.getToken())){
      return false;
    }
    redisTemplate.boundValueOps(model.getUserId()).expire(Authorization.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
    return true;
  }

  @Override public TokenModel getToken(String authentication) {
    if (authentication == null || authentication.length() == 0) {
      return null;
    }
    String[] param = authentication.split("-");
    if (param.length != 2) {
      return null;
    }
    //使用userId和源token简单拼接成的token，可以增加加密措施
    Integer userId = Integer.parseInt(param[0]);
    String token = param[1];
    return new TokenModel(userId, token);
  }

  @Override public void deleteToken(Integer userId) {
    redisTemplate.delete(userId);
  }
}
