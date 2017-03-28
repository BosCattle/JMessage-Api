package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.UserJid;
import tech.jiangtao.backstage.model.UserJidExample;

public interface UserJidMapper {
    int countByExample(UserJidExample example);

    int deleteByExample(UserJidExample example);

    int deleteByPrimaryKey(Long jidId);

    int insert(UserJid record);

    int insertSelective(UserJid record);

    List<UserJid> selectByExample(UserJidExample example);

    UserJid selectByPrimaryKey(Long jidId);

    int updateByExampleSelective(@Param("record") UserJid record, @Param("example") UserJidExample example);

    int updateByExample(@Param("record") UserJid record, @Param("example") UserJidExample example);

    int updateByPrimaryKeySelective(UserJid record);

    int updateByPrimaryKey(UserJid record);
}