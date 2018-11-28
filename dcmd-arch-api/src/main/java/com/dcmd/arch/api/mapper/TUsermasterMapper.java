package com.dcmd.arch.api.mapper;


import com.dcmd.arch.api.entity.TUsermaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUsermasterMapper {
    int deleteByPrimaryKey(String employeeid);

    int insert(TUsermaster record);

    TUsermaster selectByPrimaryKey(String employeeid);

    List<TUsermaster> selectAll();

    int updateByPrimaryKey(TUsermaster record);

    List<TUsermaster> getEmpOfSoft();

    List<TUsermaster> getLeader();

    List<TUsermaster> getPmo();
}