package com.comb.mapper;

import com.comb.pojo.TbTeamUser;
import com.comb.pojo.TbTeamUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTeamUserMapper {
    int countByExample(TbTeamUserExample example);

    int deleteByExample(TbTeamUserExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(TbTeamUser record);

    int insertSelective(TbTeamUser record);

    List<TbTeamUser> selectByExample(TbTeamUserExample example);

    TbTeamUser selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") TbTeamUser record, @Param("example") TbTeamUserExample example);

    int updateByExample(@Param("record") TbTeamUser record, @Param("example") TbTeamUserExample example);

    int updateByPrimaryKeySelective(TbTeamUser record);

    int updateByPrimaryKey(TbTeamUser record);
}