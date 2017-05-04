package tech.jiangtao.backstage.mapper;

import java.util.List;
import java.util.Map;
import tech.jiangtao.backstage.model.TigGroupMessage;
import tech.jiangtao.backstage.model.TigMaMsgs;
import tech.jiangtao.backstage.model.TigMaMsgsWithBLOBs;

/**
 * @class: TigMaMsgsCustomMapper </br>
 * @description: 查询单聊聊天历史</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 10:23</br>
 * @version: 0.0.1 </br>
 **/
public interface TigMaMsgsCustomMapper {

  public List<TigMaMsgsWithBLOBs> queryChatHistory(Map map);

  public List<TigMaMsgsWithBLOBs> queryChatHistoryByDate(Map map);

  public List<TigGroupMessage> queryGroupChatHistory(Map map);

  public List<TigGroupMessage> queryGroupChatHistoryByDate(Map map);
}
