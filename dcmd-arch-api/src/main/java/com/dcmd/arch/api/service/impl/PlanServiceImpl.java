package com.dcmd.arch.api.service.impl;


import com.dcmd.arch.api.entity.Plan;
import com.dcmd.arch.api.mapper.PlanMapper;
import com.dcmd.arch.api.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Plan record) throws Exception {
        return planMapper.insert(record);
    }

    @Override
    public Plan selectByPrimaryKey(Integer id) throws Exception {
        return planMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Plan> selectAll() throws Exception {
        return planMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Plan record) throws Exception {
        return planMapper.updateByPrimaryKey(record);
    }
}
