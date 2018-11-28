package com.dcmd.arch.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dc.dcit.common.util.ReadExcel;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.IntInvokeRelation;
import com.dcmd.arch.api.mapper.IntInvokeRelationMapper;
import com.dcmd.arch.api.service.IntInvokeRelationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntInvokeRelationServiceImpl implements IntInvokeRelationService {
    private static Logger logger = LoggerFactory.getLogger(IntInvokeRelationServiceImpl.class);
    @Autowired
    IntInvokeRelationMapper intInvokeRelationMapper;

    @Override
    public List<IntInvokeRelation> getAllDatas() throws Exception {
        return intInvokeRelationMapper.getAllDatas();
    }

    @Override
    public List<IntInvokeRelation> getCheckDatas() throws Exception {
        return intInvokeRelationMapper.getCheckDatas();
    }

    @Override
    public List<Map<String, String>> getSoftLines() throws Exception {
        return intInvokeRelationMapper.getSoftLines();
    }

    @Override
    public List<Dropdown> getSoftProduct(String softlineId) throws Exception {
        return intInvokeRelationMapper.getSoftProduct(softlineId);
    }

    @Override
    public List<Dropdown> getApiNameBySoftnum(String softwareId) throws Exception {
        return intInvokeRelationMapper.getApiNameBySoftnum(softwareId);
    }

    @Override
    public List<Dropdown> searchState() throws Exception {
        return intInvokeRelationMapper.searchState();
    }

    @Override
    public int insert(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return intInvokeRelationMapper.insert(map);
    }

    @Override
    public int update(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return intInvokeRelationMapper.update(map);
    }

    @Override
    public int updateCheck(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return intInvokeRelationMapper.updateCheck(map);
    }

    @Override
    public int batchDelectCheckData(List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelations.stream().forEach(intInvokeRelation -> {
            Map<String, String> map = new HashMap<>();
            map.put("intServiceNum", intInvokeRelation.getIntServiceNum());
            map.put("invokeIntServiceNum", intInvokeRelation.getInvokeIntServiceNum());
            intInvokeRelationMapper.deleteCheckByNum(map);
        });
        return 0;
    }

    @Override
    public int batchUpdateCheck(List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelations.stream().forEach(intInvokeRelation -> {
            Map<String, String> map = new HashMap<>();
            map.put("intServiceNum", intInvokeRelation.getIntServiceNum());
            map.put("invokeIntServiceNum", intInvokeRelation.getInvokeIntServiceNum());
            intInvokeRelationMapper.updateCheck(map);
        });
        return 0;
    }

    @Override
    public int batchDelectData(List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelations.stream().forEach(intInvokeRelation -> {
            Map<String, String> map = new HashMap<>();
            map.put("intServiceNum", intInvokeRelation.getIntServiceNum());
            map.put("invokeIntServiceNum", intInvokeRelation.getInvokeIntServiceNum());
            intInvokeRelationMapper.delectData(map);
        });
        return 0;
    }

    @Override
    public int importData(MultipartFile file) throws Exception {
        logger.info("uploadFile:" + file);
        if (file == null) {
            throw new RuntimeException("文件为空或不存在");
        }
        ReadExcel<IntInvokeRelation> readExcel = new ReadExcel<IntInvokeRelation>(new IntInvokeRelation());
        readExcel.setStartCol(0);
        readExcel.setStartRow(1);
        String[] columns = {"intNameEn", "bIntNameEn", "stateName", "validDate", "originType"};
        readExcel.setColumns(columns);
        Long start = (new Date()).getTime();
        logger.info("开始读取excel文档");
        List<IntInvokeRelation> relationList = readExcel.parseExcel2ObjList(file);
        Long end = (new Date()).getTime();
        logger.info("excel文档读取结束，用时：" + (end - start));
        logger.info("读取到信息个数:" + relationList.size());
        if (relationList.isEmpty()) {
            throw new RuntimeException("未读取到信息");
        }
        List<Dropdown> numAndNameList = intInvokeRelationMapper.queryNumAndName();
        List<Dropdown> statesList = intInvokeRelationMapper.queryState();
        relationList.stream().forEach(intInvokeRelation -> {
            Integer rows = intInvokeRelationMapper.queryRows(intInvokeRelation);
            if (rows != 2) {
                throw new RuntimeException("接口编号不存在" + " " + intInvokeRelation.getIntServiceNum() + " " + intInvokeRelation.getInvokeIntServiceNum());
            }
            Integer counts = intInvokeRelationMapper.queryCount(intInvokeRelation);
            if (counts != 0) {
                throw new RuntimeException("数据已经存在" + " " + intInvokeRelation.getIntServiceNum() + " " + intInvokeRelation.getInvokeIntServiceNum());
            }
            String IntServiceNum = intInvokeRelationMapper.queryNumByName(intInvokeRelation.getIntNameEn());
            String invokeIntServiceNum = intInvokeRelationMapper.queryNumByName(intInvokeRelation.getbIntNameEn());
            // 替换英文名
            intInvokeRelation.setIntServiceNum(IntServiceNum);
            intInvokeRelation.setInvokeIntServiceNum(invokeIntServiceNum);


            statesList.stream().forEach(states -> {
                if (StringUtils.isNotBlank(intInvokeRelation.getStateName()) && intInvokeRelation.getStateName().equals(states.getLabel())) {
                    intInvokeRelation.setState(states.getValue());
                }
            });
            intInvokeRelationMapper.insertExcelData(intInvokeRelation);
        });
        return 0;
    }

    @Override
    public List<IntInvokeRelation> advancedSearch(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return intInvokeRelationMapper.advancedSearch(map);
    }


}
