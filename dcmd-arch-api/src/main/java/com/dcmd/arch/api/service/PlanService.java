package com.dcmd.arch.api.service;

import com.dcmd.arch.api.entity.Plan;

import java.util.List;

public interface PlanService {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Plan record) throws Exception;

    Plan selectByPrimaryKey(Integer id) throws Exception;

    List<Plan> selectAll() throws Exception;

    int updateByPrimaryKey(Plan record) throws Exception;
}
