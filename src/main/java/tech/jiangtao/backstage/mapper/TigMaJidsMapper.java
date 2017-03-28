package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigMaJids;
import tech.jiangtao.backstage.model.TigMaJidsExample;

public interface TigMaJidsMapper {
    int countByExample(TigMaJidsExample example);

    int deleteByExample(TigMaJidsExample example);

    int deleteByPrimaryKey(Long jidId);

    int insert(TigMaJids record);

    int insertSelective(TigMaJids record);

    List<TigMaJids> selectByExample(TigMaJidsExample example);

    TigMaJids selectByPrimaryKey(Long jidId);

    int updateByExampleSelective(@Param("record") TigMaJids record, @Param("example") TigMaJidsExample example);

    int updateByExample(@Param("record") TigMaJids record, @Param("example") TigMaJidsExample example);

    int updateByPrimaryKeySelective(TigMaJids record);

    int updateByPrimaryKey(TigMaJids record);
}