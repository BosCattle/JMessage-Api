package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.BroadcastMsgsRecipientsExample;
import tech.jiangtao.backstage.model.BroadcastMsgsRecipientsKey;

public interface BroadcastMsgsRecipientsMapper {
    int countByExample(BroadcastMsgsRecipientsExample example);

    int deleteByExample(BroadcastMsgsRecipientsExample example);

    int deleteByPrimaryKey(BroadcastMsgsRecipientsKey key);

    int insert(BroadcastMsgsRecipientsKey record);

    int insertSelective(BroadcastMsgsRecipientsKey record);

    List<BroadcastMsgsRecipientsKey> selectByExample(BroadcastMsgsRecipientsExample example);

    int updateByExampleSelective(@Param("record") BroadcastMsgsRecipientsKey record, @Param("example") BroadcastMsgsRecipientsExample example);

    int updateByExample(@Param("record") BroadcastMsgsRecipientsKey record, @Param("example") BroadcastMsgsRecipientsExample example);
}