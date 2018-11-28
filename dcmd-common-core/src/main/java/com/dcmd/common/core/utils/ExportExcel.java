package com.dcmd.common.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 导出List<Object>数据到excel（最多可导出65535行）
 * 
 * @author feign
 */
public final class ExportExcel {
	
	private final static Logger logger = LoggerFactory.getLogger(ExportExcel.class);
	/***
	 * 构造方法
	 */
	private ExportExcel() {

	}

	/***
	 * 工作簿
	 */
	private static HSSFWorkbook workbook;

	/***
	 * sheet
	 */
	private static HSSFSheet sheet;
	/***
	 * 标题行开始位置
	 */
	private static final int TITLE_START_POSITION = 0;

	/***
	 * 时间行开始位置
	 */
	private static final int DATEHEAD_START_POSITION = 1;

	/***
	 * 表头行开始位置
	 */
	//private static final int HEAD_START_POSITION = 2;
	private static final int HEAD_START_POSITION = 0;

	/***
	 * 文本行开始位置
	 */
	//private static final int CONTENT_START_POSITION = 3;
	private static final int CONTENT_START_POSITION = 1;

	/**
	 * excel数据导出
	 * @param dataList		对象集合
	 * @param titleMap		表头信息（对象属性名称->要显示的标题值)[按顺序添加]
	 * @param sheetName		sheet名称和表头值
	 * @param exprotPath	导出文件存放地址
	 */
	public static String excelExport(List<?> dataList,Map<String, String> titleMap,String sheetName,String exprotPath) {
		String path = null;
		// 初始化workbook
		initHSSFWorkbook(sheetName);
		// 标题行
		//createTitleRow(titleMap, sheetName);
		// 时间行
		//createDateHeadRow(titleMap);
		// 表头行
		createHeadRow(titleMap);
		// 文本行
		createContentRow(dataList, titleMap);
		// 设置自动伸缩
		//autoSizeColumn(titleMap.size());
		// 写入处理结果
		try {
			
			File uploadDir = new File(exprotPath);
    		// 创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
    		if (!uploadDir.exists())
    			uploadDir.mkdirs();
			// 生成UUID文件名称
			//UUID filedName = UUID.randomUUID();
			String filedName = DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS");
			String filedisplay = filedName + ".xls";
			// 如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
			String filePath = exprotPath+File.separator+filedisplay;
			File file = new File(filePath);
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			path = filePath;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ExportExcel.excelExport-导出execl,抛出异常：【{}】",e.getMessage());
			return null;
		}
		return path;
	}

	/***
	 * 初始化workbook
	 * @param sheetName sheetName
	 */
	private static void initHSSFWorkbook(String sheetName) {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet(sheetName);
	}

	/**
	 * 生成标题（第零行创建）
	 * @param titleMap	对象属性名称->表头显示名称
	 * @param sheetName	sheet名称
	 *            
	 */
	private static void createTitleRow(Map<String, String> titleMap, String sheetName) {
		CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleMap.size() - 1);
		sheet.addMergedRegion(titleRange);
		HSSFRow titleRow = sheet.createRow(TITLE_START_POSITION);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(sheetName);
	}

	/**
	 * 创建时间行（第一行创建）
	 * @param titleMap	对象属性名称->表头显示名称
	 *            
	 */
	private static void createDateHeadRow(Map<String, String> titleMap) {
		CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleMap.size() - 1);
		sheet.addMergedRegion(dateRange);
		HSSFRow dateRow = sheet.createRow(DATEHEAD_START_POSITION);
		HSSFCell dateCell = dateRow.createCell(0);
		dateCell.setCellValue(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
	}

	/**
	 * 创建表头行（第二行创建）
	 * 
	 * @param titleMap	对象属性名称->表头显示名称
	 *            
	 */
	private static void createHeadRow(Map<String, String> titleMap) {
		HSSFRow headRow = sheet.createRow(HEAD_START_POSITION);
		int i = 0;
		for (String entry : titleMap.keySet()) {
			HSSFCell headCell = headRow.createCell(i);
			headCell.setCellValue(titleMap.get(entry));
			i++;
		}
	}

	/**
	 * 将数据写入对应excel
	 * @param dataList	对象数据集合
	 * @param titleMap	表头信息
	 *            
	 */
	private static boolean createContentRow(List<?> dataList, Map<String, String> titleMap) {
		boolean bool = false;
		try {
			int i = 0;
			for (Object obj : dataList) {
				HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
				int j = 0;
				for (String entry : titleMap.keySet()) {
					if (titleMap.containsKey(entry)) {
						//System.out.println(obj+" ========================== "+ entry);
						String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1);
						Method m = obj.getClass().getMethod(method, null);
						//String value = m.invoke(obj, null).toString();
						Object o = m.invoke(obj, null);
						String value = null==o?"":o.toString();
						HSSFCell textcell = textRow.createCell(j);
						textcell.setCellValue(value);
						j++;
					}
				}
				i++;
			}
			bool = true;
		} catch (Exception e) {
			logger.error("ExportExcel.createContentRow-写入execl,抛出异常：【{}】",e.getMessage());
			e.printStackTrace();
			return bool;
		}
		return bool;
	}

	/**
	 * 设置列宽度根据内容自适应
	 * @param size	列数
	 * 自动伸缩列（如非必要，请勿打开此方法，耗内存）         
	 */
	private static void autoSizeColumn(Integer size) {
		for (int j = 0; j < size; j++) {
			sheet.autoSizeColumn(j);
		}
	}
}