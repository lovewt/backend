package com.dcmd.arch.api.service.impl;

import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.arch.api.mapper.BasParameterMapper;
import com.dcmd.arch.api.service.BasParameterService;
import com.dcmd.common.core.vo.BasParameterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasParameterServiceImpl implements BasParameterService {
    @Autowired
    private BasParameterMapper basParameterMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return basParameterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BasParameter record) {
        return basParameterMapper.insert(record);
    }

    @Override
    public BasParameter selectByPrimaryKey(Integer id) {
        return basParameterMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BasParameter> selectAll() {
        return basParameterMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(BasParameter record) {
        return basParameterMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BasParameter> getSoftStatus() {
        return basParameterMapper.getSoftStatus();
    }

    @Override
    public List<BasParameter> getProcMethod() {
        return basParameterMapper.getProcMethod();
    }

    @Override
    public List<BasParameter> getACLevel() {
        return basParameterMapper.getACLevel();
    }

    @Override
    public List<BasParameter> getDevMethod() {
        return basParameterMapper.getDevMethod();
    }

    @Override
    public List<BasParameter> getSoftSys() {
        return basParameterMapper.getSoftSys();
    }

    @Override
    public List<BasParameter> getSoftwareMark() throws Exception {
        return basParameterMapper.getSoftwareMark();
    }

    @Override
    public List<BasParameter> getIEName() {
        return basParameterMapper.getIEName();
    }

    @Override
    public List<BasParameter> getUserType() {
        return basParameterMapper.getUserType();
    }

    @Override
    public void deleteIds(String[] ids) throws Exception {
        basParameterMapper.deleteIds(ids);
    }

    @Override
    public List<BasParameterVo> getProductLine() {
        return basParameterMapper.getProductLine();
    }
}
