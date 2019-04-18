package com.comb.mapper;

import com.comb.pojo.TbTeamCheck;
import com.comb.pojo.TbTeamCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTeamCheckMapper {
    int countByExample(TbTeamCheckExample example);

    int deleteByExample(TbTeamCheckExample example);

    int deleteByPrimaryKey(String teamId);

    int insert(TbTeamCheck record);

    int insertSelective(TbTeamCheck record);

    List<TbTeamCheck> selectByExample(TbTeamCheckExample example);

    TbTeamCheck selectByPrimaryKey(String teamId);

    int updateByExampleSelective(@Param("record") TbTeamCheck record, @Param("example") TbTeamCheckExample example);

    int updateByExample(@Param("record") TbTeamCheck record, @Param("example") TbTeamCheckExample example);

    int updateByPrimaryKeySelective(TbTeamCheck record);

    int updateByPrimaryKey(TbTeamCheck record);
}