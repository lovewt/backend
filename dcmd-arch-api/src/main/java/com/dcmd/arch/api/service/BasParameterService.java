package com.dcmd.arch.api.service;

import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.common.core.vo.BasParameterVo;

import java.util.List;

public interface BasParameterService {
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
     *
     * @return
     * @throws Exception
     */
    List<BasParameter> getSoftwareMark() throws Exception;

    List<BasParameter> getIEName();

    List<BasParameter> getUserType();


    /**
     * 批量删除
     *
     * @param
     */
    void deleteIds(String[] ids) throws Exception;

    /**
     * 获取所有产品线
     *
     * @return
     */
    List<BasParameterVo> getProductLine();

}
