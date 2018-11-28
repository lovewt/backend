package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    Plan selectByPrimaryKey(Integer id);

    List<Plan> selectAll();

    int updateByPrimaryKey(Plan record);
}