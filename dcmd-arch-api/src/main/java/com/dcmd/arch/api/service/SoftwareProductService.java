package com.dcmd.arch.api.service;

import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.arch.api.entity.SoftwareProduct;
import com.dcmd.arch.api.entity.TUsermaster;
import com.dcmd.common.core.vo.SoftwareProductVo;

import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 2018/7/3.
 */
public interface SoftwareProductService {

    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 批量删除
     *
     * @param
     */
    void deleteIds(String[] ids) throws Exception;

    void insert(SoftwareProduct record) throws Exception;

    SoftwareProduct selectByPrimaryKey(Integer id) throws Exception;

    List<SoftwareProduct> selectAll() throws Exception;

    int updateByPrimaryKey(SoftwareProduct record) throws Exception;

    List<SoftwareProduct> queryProductList() throws Exception;

    List<SoftwareProduct> check() throws Exception;

    int checkUpdate(String softwareNum) throws Exception;

    int pass(String[] ids) throws Exception;

    List<TUsermaster> getEmpOfSoft() throws Exception;

    List<BasParameter> getSoftStatus() throws Exception;

    List<BasParameter> getProcMethod() throws Exception;

    List<BasParameter> getACLevel() throws Exception;

    List<BasParameter> getDevMethod() throws Exception;

    List<BasParameter> getSoftSys() throws Exception;

    /**
     * 软件标志
     *
     * @return
     * @throws Exception
     */
    List<BasParameter> getSoftwareMark() throws Exception;

    /**
     * 获取所属部门
     *
     * @return
     */
    List<Map<String, String>> getDepartment() throws Exception;

    List<SoftwareProduct> getAllSoftProd() throws Exception;

    String[] getRole(Map<String, Object> datemap) throws Exception;

    List<SoftwareProduct> getSoftProd();

    List<BasParameter> getIEName();

    List<BasParameter> getUserType();

    List<TUsermaster> getLeader();

    List<TUsermaster> getPmo();

    List<SoftwareProduct> search(SoftwareProduct softwareProduct);

    /**
     * c查询产品是否重复
     *
     * @param softwareList
     * @return
     * @throws Exception
     */
    List<String> selectUserFromUserList(List<SoftwareProduct> softwareList) throws Exception;

    /**
     * 導入插入数据
     *
     * @param softwareList
     * @return
     */
    boolean insertUserInfo(List<SoftwareProduct> softwareList) throws Exception;

    /**
     * 获取产品线及产品信息
     *
     * @return
     */

    List<Map<String, Object>> getProductInfo() throws Exception;

    /**
     * 获取所有产品
     * @return
     */
    List<SoftwareProductVo> getProduct();

}
