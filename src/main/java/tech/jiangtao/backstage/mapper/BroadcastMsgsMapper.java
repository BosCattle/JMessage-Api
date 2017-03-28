package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.BroadcastMsgs;
import tech.jiangtao.backstage.model.BroadcastMsgsExample;

public interface BroadcastMsgsMapper {
    int countByExample(BroadcastMsgsExample example);

    int deleteByExample(BroadcastMsgsExample example);

    int deleteByPrimaryKey(String id);

    int insert(BroadcastMsgs record);

    int insertSelective(BroadcastMsgs record);

    List<BroadcastMsgs> selectByExample(BroadcastMsgsExample example);

    BroadcastMsgs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BroadcastMsgs record, @Param("example") BroadcastMsgsExample example);

    int updateByExample(@Param("record") BroadcastMsgs record, @Param("example") BroadcastMsgsExample example);

    int updateByPrimaryKeySelective(BroadcastMsgs record);

    int updateByPrimaryKey(BroadcastMsgs record);
}