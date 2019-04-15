package com.fc.mapper;

import com.fc.pojo.Labels;
import com.fc.pojo.LabelsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelsMapper {
    int countByExample(LabelsExample example);

    int deleteByExample(LabelsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Labels record);

    int insertSelective(Labels record);

    List<Labels> selectByExample(LabelsExample example);

    Labels selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Labels record, @Param("example") LabelsExample example);

    int updateByExample(@Param("record") Labels record, @Param("example") LabelsExample example);

    int updateByPrimaryKeySelective(Labels record);

    int updateByPrimaryKey(Labels record);
}