package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.MucHistory;
import tech.jiangtao.backstage.model.MucHistoryExample;
import tech.jiangtao.backstage.model.MucHistoryWithBLOBs;

public interface MucHistoryMapper {
    int countByExample(MucHistoryExample example);

    int deleteByExample(MucHistoryExample example);

    int insert(MucHistoryWithBLOBs record);

    int insertSelective(MucHistoryWithBLOBs record);

    List<MucHistoryWithBLOBs> selectByExampleWithBLOBs(MucHistoryExample example);

    List<MucHistory> selectByExample(MucHistoryExample example);

    int updateByExampleSelective(@Param("record") MucHistoryWithBLOBs record, @Param("example") MucHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") MucHistoryWithBLOBs record, @Param("example") MucHistoryExample example);

    int updateByExample(@Param("record") MucHistory record, @Param("example") MucHistoryExample example);
}