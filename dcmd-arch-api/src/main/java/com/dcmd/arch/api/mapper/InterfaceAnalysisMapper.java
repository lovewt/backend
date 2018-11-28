package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.InterfaceAnalysis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InterfaceAnalysisMapper {
    List<InterfaceAnalysis> getAllDatas();

    List<InterfaceAnalysis> getCheckDatas();

    List<Map<String, String>> getSoftLines();

    int batchDelectData(String[] ids);

    int batchUpdateCheck(String[] ids);

    List<Dropdown> getSoftProduct(@Param("softlineId") String softlineId);

    List<Dropdown> getApiNameBySoftnum(@Param("softwareId") String softwareId);

    List<Dropdown> searchState();

    int insert(Map<String, String> map);

    int update(Map<String, String> map);

    int updateCheck(Map<String, String> map);

    int deleteCheckByNum(String[] ids);

    int release(String[] ids);

    int offLine(String[] ids);

    int delectData(Map<String, String> map);

    List<Dropdown> queryNumAndName();

    Integer queryRows(@Param("intNameEn") String intNameEn, @Param("interfaceVersion") String interfaceVersion);

    Integer queryCount(String softwareName);

    int insertExcelData(InterfaceAnalysis interfaceAnalysis);

    String queryNumByName(String nameEn);

    List<Dropdown> queryState();

    List<Dropdown> getClasses();

    List<InterfaceAnalysis> advancedSearch(Map<String, String> map);
}
