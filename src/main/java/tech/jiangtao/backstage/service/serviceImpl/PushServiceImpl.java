package tech.jiangtao.backstage.service.serviceImpl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tech.jiangtao.backstage.model.json.Result;
import tech.jiangtao.backstage.model.json.TigPubsub;
import tech.jiangtao.backstage.service.PushService;

/**
 * @class: PushServiceImpl </br>
 * @description: 推送实现 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 08/05/2017 15:48</br>
 * @version: 0.0.1 </br>
 **/
@Service("pushService")
public class PushServiceImpl implements PushService {

  private static final String channel = "channel";

  @Autowired
  private RedisTemplate<Integer, String> redisTemplate;

  @Override public Result push(String type, String message, String[] userIds) throws Exception {
    TigPubsub pubsub = new TigPubsub();
    pubsub.setDate(System.currentTimeMillis());
    pubsub.setMessage(message);
    pubsub.setChannelName(channel);
    if (type.equals("all")) {
      pubsub.setPushType("all");
    } else if (type.equals("list")){
      pubsub.setPushType("list");
      pubsub.setBareJids(userIds);
    }
    Gson gson = new Gson();
    System.out.println(gson.toJson(pubsub));
    redisTemplate.convertAndSend(channel, gson.toJson(pubsub));
    return new Result(true,"SUCCESS");
  }
}
