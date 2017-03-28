package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigMaMsgsTags;
import tech.jiangtao.backstage.model.TigMaMsgsTagsExample;

public interface TigMaMsgsTagsMapper {
    int countByExample(TigMaMsgsTagsExample example);

    int deleteByExample(TigMaMsgsTagsExample example);

    int insert(TigMaMsgsTags record);

    int insertSelective(TigMaMsgsTags record);

    List<TigMaMsgsTags> selectByExample(TigMaMsgsTagsExample example);

    int updateByExampleSelective(@Param("record") TigMaMsgsTags record, @Param("example") TigMaMsgsTagsExample example);

    int updateByExample(@Param("record") TigMaMsgsTags record, @Param("example") TigMaMsgsTagsExample example);
}