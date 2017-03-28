package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.TigUsersExample;

public interface TigUsersMapper {
    int countByExample(TigUsersExample example);

    int deleteByExample(TigUsersExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(TigUsers record);

    int insertSelective(TigUsers record);

    List<TigUsers> selectByExample(TigUsersExample example);

    TigUsers selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") TigUsers record, @Param("example") TigUsersExample example);

    int updateByExample(@Param("record") TigUsers record, @Param("example") TigUsersExample example);

    int updateByPrimaryKeySelective(TigUsers record);

    int updateByPrimaryKey(TigUsers record);
}