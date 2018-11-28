package com.dcmd.service.business.feign.impl;


import com.dcmd.service.business.entity.SoftwareProduct;
import com.dcmd.service.business.feign.inter.IFeignHystric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignHystric implements IFeignHystric {

    private final static Logger logger = LoggerFactory.getLogger(FeignHystric.class);

    @Override
    public List<SoftwareProduct> getAllSoftProd() {
        logger.error("IFeignHystric.getAllSoftProd获取软件产品接口失败，进入熔断，返回null");
        return null;
    }
}
