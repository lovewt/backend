package com.dcmd.common.core.utils;

/**
 * 常量定义接口
 * @author yangyongdong
 *
 */
public interface ConstantsUtil {
	
	/**
	 * 运营指令执行状态
	 * 0-未开始
	 */
	String EXEC_STATUS_0 = "0";
	
	/**
	 * 运营指令执行状态
	 * 1-待执行
	 */
	String EXEC_STATUS_1 = "1";
	
	/**
	 * 运营指令执行状态
	 * 2-执行中
	 */
	String EXEC_STATUS_2 = "2";
	
	/**
	 * 运营指令执行状态
	 * 3-完成
	 */
	String EXEC_STATUS_3 = "3";

	/**
	 * 运营指令执行状态
	 * 5-异常
	 */
	String EXEC_STATUS_5 = "5";
	
	/**
	 * 案例状态
	 * 0-未下发
	 */
	String CASE_STATUS_0 = "0";
	
	/**
	 * 案例状态
	 * 1-待执行
	 */
	String CASE_STATUS_1 = "1";
	
	/**
	 * 案例状态
	 * 2-执行中
	 */
	String CASE_STATUS_2 = "2";
	
	/**
	 * 案例状态
	 * 3-完成
	 */
	String CASE_STATUS_3 = "3";
	
	/**
	 * 案例状态
	 * 9-异常
	 */
	String CASE_STATUS_9 = "9";
	
	/**
	 * 报表状态
	 * 0-未下发
	 */
	String REPORT_STATUS_0 = "0";
	
	/**
	 * 报表状态
	 * 1-签收进行中
	 */
	String REPORT_STATUS_1 = "1";
	
	/**
	 * 报表状态
	 * 2-签收超时
	 */
	String REPORT_STATUS_2 = "2";
	
	/**
	 * 报表状态
	 * 3-核对进行中
	 */
	String REPORT_STATUS_3 = "3";
	
	/**
	 * 报表状态
	 * 4-核对完成
	 */
	String REPORT_STATUS_4 = "4";
	
	/**
	 * 报表状态
	 * 9-核对异常
	 */
	String REPORT_STATUS_9 = "9";
	
	/**
	 * 超时类型
	 * 1	接收超时
	 */
	String TIME_OUT_TYPE_1 = "1";
	
	/**
	 * 超时类型
	 * 2	核对超时
	 */
	String TIME_OUT_TYPE_2 = "2";

	/**
	 * 节点标识	
	 * 0	不存在子节点	
	 */
	String NODE_FLAG_0 = "0";
	
	/**
	 * 节点标识	
	 * 1	存在子节点
	 */
	String NODE_FLAG_1 = "1";

	
	/**
	 * 有效标识
	 * 0-无效
	 */
	String VALID_FLAG_0 = "0";
	
	/**
	 * 有效标识
	 * 1-有效
	 */
	String VALID_FLAG_1 = "1";
	
	/**
	 * 任务状态
	 * 0-未开始
	 */
	String TASK_STATUS_0 = "0";
	
	/**
	 * 任务状态
	 * 1-待接收
	 */
	String TASK_STATUS_1 = "1";
	
	/**
	 * 任务状态
	 * 2-待执行
	 */
	String TASK_STATUS_2 = "2";
	
	/**
	 * 任务状态
	 * 3-执行中
	 */
	String TASK_STATUS_3 = "3";
	
	/**
	 * 任务状态
	 * 4-完成
	 */
	String TASK_STATUS_4 = "4";
	
	/**
	 * 任务状态
	 * 5-异常
	 */
	String TASK_STATUS_5 = "5";
	
	/**
	 * 任务状态
	 * 9-异常
	 */
	String TASK_STATUS_9 = "9";
	
	/**
	 * 录入标识
	 * 1	手工
	 */
	String RECORD_FLAG_1 = "1";

	/**
	 * 录入标识
	 * 2	批量导入
	 */
	String RECORD_FLAG_2 = "2";
	
	/**
	 * 错误编码
	 */
	String CODE_FAILURE = "0001";
	
	/**
	 * 成功编码
	 */
	String CODE_SUCCESS = "0000";
	
	/**
	 * 签收超时状态
	 */
	String SIGN_OUT_TIME_STATUS_6 = "6";
	
	/**
	 * 执行超时状态
	 */
	String EXEC_OUT_TIME_STATUS_7 = "7";

}
