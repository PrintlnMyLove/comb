package com.comb.mapper;

import com.comb.pojo.TbSuUser;
import com.comb.pojo.TbSuUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSuUserMapper {
    int countByExample(TbSuUserExample example);

    int deleteByExample(TbSuUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSuUser record);

    int insertSelective(TbSuUser record);

    List<TbSuUser> selectByExample(TbSuUserExample example);

    TbSuUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSuUser record, @Param("example") TbSuUserExample example);

    int updateByExample(@Param("record") TbSuUser record, @Param("example") TbSuUserExample example);

    int updateByPrimaryKeySelective(TbSuUser record);

    int updateByPrimaryKey(TbSuUser record);
}