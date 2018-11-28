package com.dcmd.service.demand.error.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dcmd.common.core.entity.ErrorInfo;
import com.dcmd.service.demand.error.impl.ExceptionServiceImpl;

@FeignClient(value = "dcmd-service-server-exception",fallback = ExceptionServiceImpl.class)
public interface IExceptionService {

	/**
	 * 录入异常信息异常管理
	 * @param
	 * @return
	 */
	@PostMapping(value = "errorInfoController/recordEcxeption")
	int recordEcxeption(@RequestBody ErrorInfo errorInfo);
	
}
