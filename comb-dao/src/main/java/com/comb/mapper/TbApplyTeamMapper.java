package com.comb.mapper;

import com.comb.pojo.TbApplyTeam;
import com.comb.pojo.TbApplyTeamExample;
import com.comb.pojo.TbApplyTeamWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApplyTeamMapper {
    int countByExample(TbApplyTeamExample example);

    int deleteByExample(TbApplyTeamExample example);

    int deleteByPrimaryKey(Long teamId);

    int insert(TbApplyTeam applyTeam);

    int insertSelective(TbApplyTeamWithBLOBs record);

    List<TbApplyTeamWithBLOBs> selectByExampleWithBLOBs(TbApplyTeamExample example);

    List<TbApplyTeam> selectByExample(TbApplyTeamExample example);

    TbApplyTeamWithBLOBs selectByPrimaryKey(Long teamId);

    int updateByExampleSelective(@Param("record") TbApplyTeamWithBLOBs record, @Param("example") TbApplyTeamExample example);

    int updateByExampleWithBLOBs(@Param("record") TbApplyTeamWithBLOBs record, @Param("example") TbApplyTeamExample example);

    int updateByExample(@Param("record") TbApplyTeam record, @Param("example") TbApplyTeamExample example);

    int updateByPrimaryKeySelective(TbApplyTeamWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbApplyTeamWithBLOBs record);

    int updateByPrimaryKey(TbApplyTeam record);
}