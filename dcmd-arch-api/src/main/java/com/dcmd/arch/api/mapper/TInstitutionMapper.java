package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.TInstitution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TInstitutionMapper {
    int deleteByPrimaryKey(String instno);

    int insert(TInstitution record);

    TInstitution selectByPrimaryKey(String instno);

    List<TInstitution> selectAll();

    int updateByPrimaryKey(TInstitution record);

    List<TInstitution> getInstOfIT();

    List<TInstitution> getInstOfBU();
}