package com.dcmd.arch.api.mapper;


import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.IntInvokeRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IntInvokeRelationMapper {
    List<IntInvokeRelation> getAllDatas();

    List<IntInvokeRelation> getCheckDatas();

    List<Map<String, String>> getSoftLines();


    List<Dropdown> getSoftProduct(@Param("softlineId") String softlineId);

    List<Dropdown> getApiNameBySoftnum(@Param("softwareId") String softwareId);

    List<Dropdown> searchState();

    int insert(Map<String, String> map);

    int update(Map<String, String> map);

    int updateCheck(Map<String, String> map);

    int deleteCheckByNum(Map<String, String> map);

    int delectData(Map<String, String> map);

    List<Dropdown> queryNumAndName();

    Integer queryRows(IntInvokeRelation intInvokeRelations);

    Integer queryCount(IntInvokeRelation intInvokeRelations);

    int insertExcelData(IntInvokeRelation intInvokeRelations);

    String queryNumByName(String nameEn);

    List<Dropdown> queryState();

    List<IntInvokeRelation> advancedSearch(Map<String, String> map);

}
