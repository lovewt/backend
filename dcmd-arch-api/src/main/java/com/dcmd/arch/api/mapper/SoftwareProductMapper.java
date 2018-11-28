package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.SoftwareProduct;
import com.dcmd.common.core.vo.SoftwareProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SoftwareProductMapper {
    int deleteByPrimaryKey(@Param("softwareNum") String id);

    /**
     * 批量删除
     *
     * @param
     */
    void deleteIds(String[] ids) throws Exception;

    /**
     * 获取所属部门
     *
     * @return
     */
    List<Map<String, String>> getDepartment();


    Boolean insert(SoftwareProduct record);

    SoftwareProduct selectByPrimaryKey(Integer softwareNum);

    List<SoftwareProduct> selectAll();

    int updateByPrimaryKey(SoftwareProduct record);

    List<SoftwareProduct> queryProductList();

    List<SoftwareProduct> check();

    int checkUpdate(String softwareNum);

    int pass(String[] ids);

    List<SoftwareProduct> getAllSoftProd();

    String[] getRole(Map<String, Object> datemap);

    List<SoftwareProduct> getSoftProd();

    List<SoftwareProduct> search(SoftwareProduct softwareProduct);

    /**
     * 查询产品是否重复
     *
     * @param softwareList
     * @return
     */
    List<String> selectUserFromUserList(List<SoftwareProduct> softwareList);

    /**
     * 获取software_name
     *
     * @return
     */
    List<Map<String, Object>> getSoftwareName();

    /**
     * 根据产品线类型获取产品
     *
     * @param productType 产品线类型
     * @return
     */
    List<Map<String, Object>> findProductByProductLineType(@Param("productType") String productType);

    /**
     * 获取所有产品
     *
     * @return
     */
    List<SoftwareProductVo> getProduct();

}