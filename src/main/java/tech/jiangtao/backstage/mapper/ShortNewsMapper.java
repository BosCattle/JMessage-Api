package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.ShortNews;
import tech.jiangtao.backstage.model.ShortNewsExample;

public interface ShortNewsMapper {
    int countByExample(ShortNewsExample example);

    int deleteByExample(ShortNewsExample example);

    int deleteByPrimaryKey(Long snid);

    int insert(ShortNews record);

    int insertSelective(ShortNews record);

    List<ShortNews> selectByExample(ShortNewsExample example);

    ShortNews selectByPrimaryKey(Long snid);

    int updateByExampleSelective(@Param("record") ShortNews record, @Param("example") ShortNewsExample example);

    int updateByExample(@Param("record") ShortNews record, @Param("example") ShortNewsExample example);

    int updateByPrimaryKeySelective(ShortNews record);

    int updateByPrimaryKey(ShortNews record);
}