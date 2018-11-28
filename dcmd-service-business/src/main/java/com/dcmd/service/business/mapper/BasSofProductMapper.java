package com.dcmd.service.business.mapper;

import com.dcmd.service.business.entity.BasSofProduct;
import com.dcmd.service.business.entity.Business;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BasSofProductMapper {
    int deleteByPrimaryKey(Integer softwareNum);

    int insert(BasSofProduct record);

    BasSofProduct selectByPrimaryKey(Integer softwareNum);

    List<BasSofProduct> selectAll();

    int updateByPrimaryKey(BasSofProduct record);

    /**
     * 拿到所有软件名称 ID
     * @return
     */
    List<Business> findAllProduct();
}