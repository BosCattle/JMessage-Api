package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigGroupMessage;
import tech.jiangtao.backstage.model.TigGroupMessageExample;

public interface TigGroupMessageMapper {
    int countByExample(TigGroupMessageExample example);

    int deleteByExample(TigGroupMessageExample example);

    int deleteByPrimaryKey(Integer msgId);

    int insert(TigGroupMessage record);

    int insertSelective(TigGroupMessage record);

    List<TigGroupMessage> selectByExample(TigGroupMessageExample example);

    TigGroupMessage selectByPrimaryKey(Integer msgId);

    int updateByExampleSelective(@Param("record") TigGroupMessage record, @Param("example") TigGroupMessageExample example);

    int updateByExample(@Param("record") TigGroupMessage record, @Param("example") TigGroupMessageExample example);

    int updateByPrimaryKeySelective(TigGroupMessage record);

    int updateByPrimaryKey(TigGroupMessage record);
}