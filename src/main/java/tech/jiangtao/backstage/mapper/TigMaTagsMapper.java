package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigMaTags;
import tech.jiangtao.backstage.model.TigMaTagsExample;

public interface TigMaTagsMapper {
    int countByExample(TigMaTagsExample example);

    int deleteByExample(TigMaTagsExample example);

    int deleteByPrimaryKey(Long tagId);

    int insert(TigMaTags record);

    int insertSelective(TigMaTags record);

    List<TigMaTags> selectByExample(TigMaTagsExample example);

    TigMaTags selectByPrimaryKey(Long tagId);

    int updateByExampleSelective(@Param("record") TigMaTags record, @Param("example") TigMaTagsExample example);

    int updateByExample(@Param("record") TigMaTags record, @Param("example") TigMaTagsExample example);

    int updateByPrimaryKeySelective(TigMaTags record);

    int updateByPrimaryKey(TigMaTags record);
}