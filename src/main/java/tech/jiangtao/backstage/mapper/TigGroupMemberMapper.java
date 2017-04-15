package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigGroupMember;
import tech.jiangtao.backstage.model.TigGroupMemberExample;

public interface TigGroupMemberMapper {
    int countByExample(TigGroupMemberExample example);

    int deleteByExample(TigGroupMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TigGroupMember record);

    int insertSelective(TigGroupMember record);

    List<TigGroupMember> selectByExample(TigGroupMemberExample example);

    TigGroupMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TigGroupMember record, @Param("example") TigGroupMemberExample example);

    int updateByExample(@Param("record") TigGroupMember record, @Param("example") TigGroupMemberExample example);

    int updateByPrimaryKeySelective(TigGroupMember record);

    int updateByPrimaryKey(TigGroupMember record);
}