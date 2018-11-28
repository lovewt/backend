package com.dcmd.service.business.service;
import com.alibaba.fastjson.JSONObject;
import com.dcmd.common.core.utils.AjaxResultUtil;
import com.dcmd.service.business.entity.Business;
import com.dcmd.service.business.entity.Dropdown;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 2018/7/3.
 */
public interface BusinessService {
    int deleteByPrimaryKey(Long id) throws Exception;

    int insert(JSONObject jsonObject) throws Exception;

    Business selectByPrimaryKey(Long id) throws Exception;

    List<Business> selectAll() throws Exception;

    int updateByPrimaryKey(JSONObject jsonObject) throws Exception;

    /**
     * 多条数据删除
     * @param ids
     */
    AjaxResultUtil deletes(Long[] ids) throws Exception;

    /**
     * 拿到所有的软件名称 ID
     * @return
     */
    List<Business> findAllProduct() throws Exception;


    /**
     * 获取软件产品
     * @return
     */
    List<Map<String,String>> getProductName()throws Exception;

    /**
     * 根据特定条件查询
     * <p>业务等级、功能、业务功能关联关系、系统</p>
     * @param jsonObject
     * @return
     */
    List<Map<String,Object>> selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(JSONObject jsonObject) throws Exception;

    /**
     * 拿到所有业务类型数据
     * @return
     * @throws Exception
     */
    List<LinkedHashMap<String,Object>> getBusinessLevelInfo() throws Exception;
    /**
     * 获取列表业务类型数据
     * @return
     * @throws Exception
     */
    List<Business> queryAllDatas() throws Exception;

    /**
     * 获取业务类型下拉框
     * @return
     * @throws Exception
     */
    List<Dropdown> getBusinessLevelType() throws Exception;

    /**
     * 获取逐级下拉框
     * @return
     * @throws Exception
     */
    List<Dropdown> getBusinessLevelList(String id) throws Exception;

    /**
     * 获取功能相关点
     * @return
     * @throws Exception
     */
    List<Dropdown> getFeaturesBusinessList() throws Exception;


    /**
     * 获取业务类型及一二级
     * @return
     * @throws Exception
     */
    Map getBusinessTypeLevelTwo() throws Exception;

    /**
     * 获取业务的三四五级
     * @return
     * @throws Exception
     */
    Map getBusinessTypeLevelFive() throws Exception;


    /**
     * 查询所有业务类型及所有数据
     * @return
     * @throws Exception
     */
    Map getBusinessTypeLevelAndAllData() throws Exception;

    /**
     * 业务类型及一到五级级别
     * @return
     * @throws Exception
     */
    Map getBusinessTypeLevelAndAllLevel() throws Exception;
}
