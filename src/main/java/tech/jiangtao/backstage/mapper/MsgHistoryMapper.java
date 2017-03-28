package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.MsgHistory;
import tech.jiangtao.backstage.model.MsgHistoryExample;

public interface MsgHistoryMapper {
    int countByExample(MsgHistoryExample example);

    int deleteByExample(MsgHistoryExample example);

    int insert(MsgHistory record);

    int insertSelective(MsgHistory record);

    List<MsgHistory> selectByExample(MsgHistoryExample example);

    int updateByExampleSelective(@Param("record") MsgHistory record, @Param("example") MsgHistoryExample example);

    int updateByExample(@Param("record") MsgHistory record, @Param("example") MsgHistoryExample example);
}