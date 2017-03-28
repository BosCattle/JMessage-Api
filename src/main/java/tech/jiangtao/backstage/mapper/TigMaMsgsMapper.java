package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigMaMsgs;
import tech.jiangtao.backstage.model.TigMaMsgsExample;
import tech.jiangtao.backstage.model.TigMaMsgsWithBLOBs;

public interface TigMaMsgsMapper {
    int countByExample(TigMaMsgsExample example);

    int deleteByExample(TigMaMsgsExample example);

    int deleteByPrimaryKey(Long msgId);

    int insert(TigMaMsgsWithBLOBs record);

    int insertSelective(TigMaMsgsWithBLOBs record);

    List<TigMaMsgsWithBLOBs> selectByExampleWithBLOBs(TigMaMsgsExample example);

    List<TigMaMsgs> selectByExample(TigMaMsgsExample example);

    TigMaMsgsWithBLOBs selectByPrimaryKey(Long msgId);

    int updateByExampleSelective(@Param("record") TigMaMsgsWithBLOBs record, @Param("example") TigMaMsgsExample example);

    int updateByExampleWithBLOBs(@Param("record") TigMaMsgsWithBLOBs record, @Param("example") TigMaMsgsExample example);

    int updateByExample(@Param("record") TigMaMsgs record, @Param("example") TigMaMsgsExample example);

    int updateByPrimaryKeySelective(TigMaMsgsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TigMaMsgsWithBLOBs record);

    int updateByPrimaryKey(TigMaMsgs record);
}