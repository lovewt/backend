package com.dcmd.arch.api.service;

import com.dcmd.arch.api.entity.TInstitution;

import java.util.List;

public interface TInstitutionService {
    void deleteByPrimaryKey(String instno) throws Exception;

    void insert(TInstitution record) throws Exception;

    TInstitution selectByPrimaryKey(String instno) throws Exception;

    List<TInstitution> selectAll() throws Exception;

    int updateByPrimaryKey(TInstitution record) throws Exception;

    List<TInstitution> getInstOfIT() throws Exception;

    List<TInstitution> getInstOfBU() throws Exception;
}
