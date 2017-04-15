package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigGroup;
import tech.jiangtao.backstage.model.TigGroupExample;

public interface TigGroupMapper {
    int countByExample(TigGroupExample example);

    int deleteByExample(TigGroupExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(TigGroup record);

    int insertSelective(TigGroup record);

    List<TigGroup> selectByExample(TigGroupExample example);

    TigGroup selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") TigGroup record, @Param("example") TigGroupExample example);

    int updateByExample(@Param("record") TigGroup record, @Param("example") TigGroupExample example);

    int updateByPrimaryKeySelective(TigGroup record);

    int updateByPrimaryKey(TigGroup record);
}