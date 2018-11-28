package com.dcmd.service.demand.error.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dcmd.common.core.entity.ErrorInfo;
import com.dcmd.service.demand.error.inter.IExceptionService;

@Component
public class ExceptionServiceImpl implements IExceptionService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public int recordEcxeption(ErrorInfo errorInfo) {
		
		logger.info("ExceptionServiceImpl.recordEcxeption-熔断...");
		return 0;
	}

}
