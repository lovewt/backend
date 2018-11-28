package com.dcmd.service.business.mapper;

import com.dcmd.service.business.entity.Business;
import com.dcmd.service.business.entity.BusinessLevel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BusinessMapper{
    int deleteByPrimaryKey(Long id);

    int insert(Map<String,String> map);

    Business selectByPrimaryKey(Long id);

    List<Business> selectAll();

    int updateByPrimaryKey(Map<String,String> map);

    /**
     * 多条数据删除
     * @param ids
     */
    void deletes(Long[] ids);

    /**
     * 根据特定条件查询
     * <p>业务等级、功能、业务功能关联关系、系统</p>
     * @param map
     * @return
     */
    List<Map<String,Object>> selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(Map<String, Object> map);

    /**
     * 获取软件产品
     * @return
     */
    List<Map<String,String>> getProductName();

    /**
     * 获取功能点
     * @return
     */
    List<Business> getFunctionPoint();

    /**
     * 获取业务类型、一级、二级、三级、四级、五级
     * @return
     */
    List<Business> getLevelInfo();

}