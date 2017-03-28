package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.XmppStanza;
import tech.jiangtao.backstage.model.XmppStanzaExample;

public interface XmppStanzaMapper {
    int countByExample(XmppStanzaExample example);

    int deleteByExample(XmppStanzaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XmppStanza record);

    int insertSelective(XmppStanza record);

    List<XmppStanza> selectByExampleWithBLOBs(XmppStanzaExample example);

    List<XmppStanza> selectByExample(XmppStanzaExample example);

    XmppStanza selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XmppStanza record, @Param("example") XmppStanzaExample example);

    int updateByExampleWithBLOBs(@Param("record") XmppStanza record, @Param("example") XmppStanzaExample example);

    int updateByExample(@Param("record") XmppStanza record, @Param("example") XmppStanzaExample example);

    int updateByPrimaryKeySelective(XmppStanza record);

    int updateByPrimaryKeyWithBLOBs(XmppStanza record);
}