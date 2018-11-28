package com.dcmd.arch.api.mapper;


import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.common.core.vo.BasParameterVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BasParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasParameter record);

    BasParameter selectByPrimaryKey(Integer id);

    List<BasParameter> selectAll();

    int updateByPrimaryKey(BasParameter record);

    List<BasParameter> getSoftStatus();

    List<BasParameter> getProcMethod();

    List<BasParameter> getACLevel();

    List<BasParameter> getDevMethod();

    List<BasParameter> getSoftSys();

    /**
     * 软件标志
     * @return
     * @throws Exception
     */
    List<BasParameter> getSoftwareMark() throws Exception;

    List<BasParameter> getIEName();

    List<BasParameter> getUserType();


    /**
     * 批量删除
     * @param
     */
    void deleteIds(String[] ids);

    /**
     * 获取产品线
     * @return
     */
    List<Map<String,Object>> getProductInfo();

    /**
     * 获取所有的产品线
     * @return
     */
    List<BasParameterVo> getProductLine();

}