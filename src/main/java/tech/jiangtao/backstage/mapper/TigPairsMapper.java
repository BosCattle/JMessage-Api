package tech.jiangtao.backstage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.backstage.model.TigPairs;
import tech.jiangtao.backstage.model.TigPairsExample;

public interface TigPairsMapper {
    int countByExample(TigPairsExample example);

    int deleteByExample(TigPairsExample example);

    int insert(TigPairs record);

    int insertSelective(TigPairs record);

    List<TigPairs> selectByExampleWithBLOBs(TigPairsExample example);

    List<TigPairs> selectByExample(TigPairsExample example);

    int updateByExampleSelective(@Param("record") TigPairs record, @Param("example") TigPairsExample example);

    int updateByExampleWithBLOBs(@Param("record") TigPairs record, @Param("example") TigPairsExample example);

    int updateByExample(@Param("record") TigPairs record, @Param("example") TigPairsExample example);
}