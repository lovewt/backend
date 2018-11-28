package com.dcmd.arch.api.service.impl;

import com.dcmd.arch.api.entity.TInstitution;
import com.dcmd.arch.api.mapper.TInstitutionMapper;
import com.dcmd.arch.api.service.TInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TInstitutionServiceImpl implements TInstitutionService {

    @Autowired
    private TInstitutionMapper tInstitutionMapper;

    @Transactional
    @Override
    public void deleteByPrimaryKey(String instno) throws Exception {
        tInstitutionMapper.deleteByPrimaryKey(instno);
    }

    @Transactional
    @Override
    public void insert(TInstitution record) {
        tInstitutionMapper.insert(record);
    }

    @Override
    public TInstitution selectByPrimaryKey(String instno) {
        return tInstitutionMapper.selectByPrimaryKey(instno);
    }

    @Override
    public List<TInstitution> selectAll() {
        return tInstitutionMapper.selectAll();
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(TInstitution record) {
        return tInstitutionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TInstitution> getInstOfIT() throws Exception {
        return tInstitutionMapper.getInstOfIT();
    }

    @Override
    public List<TInstitution> getInstOfBU() throws Exception {
        return tInstitutionMapper.getInstOfBU();
    }

}
