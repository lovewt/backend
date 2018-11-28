package com.dcmd.arch.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dc.dcit.common.util.ReadExcel;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.InterfaceIO;
import com.dcmd.arch.api.mapper.InterfaceIOMapper;
import com.dcmd.arch.api.service.InterfaceIOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InterfaceIOServiceImpl implements InterfaceIOService {
    private static Logger logger = LoggerFactory.getLogger(IntInvokeRelationServiceImpl.class);
    @Autowired
    private InterfaceIOMapper interfaceIOMapper;

    @Override
    public List<InterfaceIO> getAllDatas(String intServiceNum) throws Exception {
        return interfaceIOMapper.getAllDatas(intServiceNum);
    }

    @Override
    public Map<String, String> getTitleData(String intServiceNum) throws Exception {
        return interfaceIOMapper.getTitleData(intServiceNum);
    }

    @Override
    public List<InterfaceIO> getCheckDatas(String intServiceNum) throws Exception {
        return interfaceIOMapper.getCheckDatas(intServiceNum);
    }

    @Override
    public List<Map<String, String>> getSoftLines() throws Exception {
        return interfaceIOMapper.getSoftLines();
    }

    @Override
    public List<Dropdown> getSoftProduct(String softlineId) throws Exception {
        return interfaceIOMapper.getSoftProduct(softlineId);
    }

    @Override
    public List<Dropdown> getApiNameBySoftnum(String softwareId) throws Exception {
        return interfaceIOMapper.getApiNameBySoftnum(softwareId);
    }

    @Override
    public List<Dropdown> searchState() throws Exception {
        return interfaceIOMapper.searchState();
    }

    @Override
    public int insert(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return interfaceIOMapper.insert(map);
    }

    @Override
    public int update(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        map.put("updtDate", format.format(new Date()));
        return interfaceIOMapper.update(map);
    }

    @Override
    public int updateCheck(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return interfaceIOMapper.updateCheck(map);
    }

    @Override
    public int batchDelectCheckData(String[] ids) throws Exception {
        return interfaceIOMapper.deleteCheckByNum(ids);

    }

    @Override
    public int batchUpdateCheck(String[] ids) throws Exception {
        return interfaceIOMapper.batchUpdateCheck(ids);
    }

    @Override
    public int batchDelectData(String[] ids) throws Exception {
        return interfaceIOMapper.batchDelectData(ids);
    }

    @Override
    public int release(String[] ids) throws Exception {
        return interfaceIOMapper.release(ids);
    }

    @Override
    public int offLine(String[] ids) throws Exception {
        return interfaceIOMapper.offLine(ids);
    }

    @Override
    public List<Dropdown> getClasses() throws Exception {
        return interfaceIOMapper.getClasses();
    }

    @Override
    public int importData(MultipartFile file) throws Exception {
        logger.info("uploadFile:" + file);
        if (file == null) {
            throw new RuntimeException("文件为空或不存在");
        }
        ReadExcel<InterfaceIO> readExcel = new ReadExcel<InterfaceIO>(new InterfaceIO());
        readExcel.setStartCol(0);
        readExcel.setStartRow(1);
        String[] columns = {"softwareName", "greatClassName", "stateName", "intNameCn", "intNameEn", "description", "url", "reviewNumber", "downlineDate", "releaseDate", "serviceFit", "consumerFit", "interfaceVersion", "remark"};
        readExcel.setColumns(columns);
        Long start = (new Date()).getTime();
        logger.info("开始读取excel文档");
        List<InterfaceIO> interfaceList = readExcel.parseExcel2ObjList(file);
        Long end = (new Date()).getTime();
        logger.info("excel文档读取结束，用时：" + (end - start));
        logger.info("读取到信息个数:" + interfaceList.size());
        if (interfaceList.isEmpty()) {
            throw new RuntimeException("未读取到信息");
        }
        List<Dropdown> numAndNameList = interfaceIOMapper.queryNumAndName();
        List<Dropdown> statesList = interfaceIOMapper.queryState();
        List<Dropdown> classesList = interfaceIOMapper.getClasses();
//        interfaceList.stream().forEach(interfaces -> {
//            Integer rows = interfaceIOMapper.queryRows(interfaces.getIntNameEn(), interfaces.getInterfaceVersion());
//            if (rows != 0) {
//                throw new RuntimeException("数据已存在" + " " + interfaces.toString());
//            }
//            Integer counts = interfaceIOMapper.queryCount(interfaces.getSoftwareName());
//            if (counts == 0) {
//                throw new RuntimeException("软件产品不存在" + " " + interfaces.getSoftwareName());
//            }
//            numAndNameList.stream().forEach(numAndName -> {
//                if (StringUtils.isNotBlank(interfaces.getSoftwareName()) && interfaces.getSoftwareName().equals(numAndName.getLabel())) {
//                    interfaces.setSoftwareNum(numAndName.getValue());
//                }
//            });
//            statesList.stream().forEach(states -> {
//                if (StringUtils.isNotBlank(interfaces.getStateName()) && interfaces.getStateName().equals(states.getLabel())) {
//                    interfaces.setState(states.getValue());
//                }
//            });
//            classesList.stream().forEach(classes -> {
//                if (StringUtils.isNotBlank(interfaces.getGreatClassName()) && interfaces.getGreatClassName().equals(classes.getLabel())) {
//                    interfaces.setGreatClass(classes.getValue());
//                }
//            });
//            interfaceIOMapper.insertExcelData(interfaces);
//        });

        return 0;
    }

    @Override
    public List<Dropdown> getPropertyTypes() throws Exception {
        return interfaceIOMapper.getPropertyTypes();
    }
}

