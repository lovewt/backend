package com.dcmd.arch.api.service;

import com.alibaba.fastjson.JSONObject;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.IntInvokeRelation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IntInvokeRelationService {

    List<IntInvokeRelation> getAllDatas() throws Exception;

    List<IntInvokeRelation> getCheckDatas() throws Exception;

    List<Map<String, String>> getSoftLines() throws Exception;

    List<Dropdown> getSoftProduct(String softlineId) throws Exception;

    List<Dropdown> getApiNameBySoftnum(String softwareId) throws Exception;

    List<Dropdown> searchState() throws Exception;

    int insert(JSONObject jsonObject) throws Exception;

    int update(JSONObject jsonObject) throws Exception;

    int updateCheck(JSONObject jsonObject) throws Exception;

    int batchDelectCheckData(List<IntInvokeRelation> intInvokeRelations) throws Exception;

    int batchUpdateCheck(List<IntInvokeRelation> intInvokeRelations) throws Exception;


    int batchDelectData(List<IntInvokeRelation> intInvokeRelations) throws Exception;

    /**
     * 读取excel中的数据,生成list
     */
    int importData(MultipartFile file) throws Exception;

    List<IntInvokeRelation> advancedSearch(JSONObject jsonObject) throws Exception;

}
