package com.dcmd.arch.api.mapper;


import com.dcmd.arch.api.entity.Standard;

import java.util.List;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    Standard selectByPrimaryKey(Integer id);

    List<Standard> selectAll();

    int updateByPrimaryKey(Standard record);
}