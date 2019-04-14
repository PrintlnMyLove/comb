package com.comb.mapper;

import com.comb.pojo.TbSpecificationOption;
import com.comb.pojo.TbSpecificationOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpecificationOptionMapper {
    int countByExample(TbSpecificationOptionExample example);

    int deleteByExample(TbSpecificationOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpecificationOption record);

    int insertSelective(TbSpecificationOption record);

    List<TbSpecificationOption> selectByExample(TbSpecificationOptionExample example);

    TbSpecificationOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    int updateByExample(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    int updateByPrimaryKeySelective(TbSpecificationOption record);

    int updateByPrimaryKey(TbSpecificationOption record);
}