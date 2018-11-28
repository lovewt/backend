package com.dcmd.service.business.mapper;

import com.dcmd.service.business.entity.Business;
import com.dcmd.service.business.entity.BusinessLevel;
import com.dcmd.service.business.entity.Dropdown;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName BusinessLevelMapper
 * @Author lenovo
 * @Date 2018/10/24 15:51
 * @Version 1.0.0
 */
@Repository
public interface BusinessLevelMapper {

    /**
     * 根据产品的id获取业务类型等级
     * @return
     * @throws Exception
     */
    List<BusinessLevel> getBusinessLevelInfo() throws Exception;

    List<BusinessLevel> getBusinessLevelFeatures() throws Exception;


    List<Dropdown> getBusinessLevelType() throws Exception;

    List<Dropdown> getBusinessLevelList(String id) throws Exception;

    List<Dropdown> getFeaturesBusinessList() throws Exception;
}
