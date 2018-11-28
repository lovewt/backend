package com.dcmd.arch.api.service;

import com.alibaba.fastjson.JSONObject;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.InterfaceIO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface InterfaceIOService {
    List<InterfaceIO> getAllDatas(String intServiceNum) throws Exception;

    Map<String,String> getTitleData(String intServiceNum) throws Exception;

    List<InterfaceIO> getCheckDatas(String intServiceNum) throws Exception;

    List<Map<String, String>> getSoftLines() throws Exception;

    List<Dropdown> getSoftProduct(String softlineId) throws Exception;

    List<Dropdown> getApiNameBySoftnum(String softwareId) throws Exception;

    List<Dropdown> searchState() throws Exception;

    int insert(JSONObject jsonObject) throws Exception;

    int update(JSONObject jsonObject) throws Exception;

    int updateCheck(JSONObject jsonObject) throws Exception;

    int batchDelectCheckData(String[] ids) throws Exception;

    int batchUpdateCheck(String[] ids) throws Exception;

    int batchDelectData(String[] ids) throws Exception;

    int release(String[] ids) throws Exception;

    int offLine(String[] ids) throws Exception;

    List<Dropdown> getClasses() throws Exception;

    /**
     * 读取excel中的数据,生成list
     */
    int importData(MultipartFile file) throws Exception;

    List<Dropdown> getPropertyTypes() throws Exception;
}

