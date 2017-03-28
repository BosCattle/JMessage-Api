package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigNodes;
import tech.jiangtao.backstage.model.TigNodesExample;

public interface TigNodesMapper {
    int countByExample(TigNodesExample example);

    int deleteByExample(TigNodesExample example);

    int deleteByPrimaryKey(Long nid);

    int insert(TigNodes record);

    int insertSelective(TigNodes record);

    List<TigNodes> selectByExample(TigNodesExample example);

    TigNodes selectByPrimaryKey(Long nid);

    int updateByExampleSelective(@Param("record") TigNodes record, @Param("example") TigNodesExample example);

    int updateByExample(@Param("record") TigNodes record, @Param("example") TigNodesExample example);

    int updateByPrimaryKeySelective(TigNodes record);

    int updateByPrimaryKey(TigNodes record);
}