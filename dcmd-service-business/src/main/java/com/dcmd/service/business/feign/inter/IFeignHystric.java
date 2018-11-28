package com.dcmd.service.business.feign.inter;



import com.dcmd.service.business.entity.SoftwareProduct;
import com.dcmd.service.business.feign.impl.FeignHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "dcmd-arch-api",path = "/softwareProductController",fallback = FeignHystric.class)
public interface IFeignHystric {

    /**
     * 查询软件产品
     * @return
     */
	@GetMapping("/getAllSoftProd")
	List<SoftwareProduct> getAllSoftProd();


}
