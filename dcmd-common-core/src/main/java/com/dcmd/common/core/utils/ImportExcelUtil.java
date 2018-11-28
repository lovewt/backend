package com.dcmd.common.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

/**
 * 导入报表帮助
 * @author yangyongdong
 *
 */
public class ImportExcelUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(ImportExcelUtil.class);
	
    private final static String excel2003L = ".xls"; // 2003- 版本的excel
    private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

    /**
     * 将流中的Excel数据
     * @param file		上传文件流
     * @param mapping	字段名称映射	key为导入表头属性，value为对应表的实体类属性，一一对应
     * @return {head=[{sysSeqNo=,errorCode=,errorMsg=,,respTime}],body=[{execOrgNo=100130}]}}
     * head为数据头，固定参数只有值会发生变化，body为实体属性及属性值对应关系
     */
    public static Map<String,List<Map<String, Object>>> parseExcel(MultipartFile file,Map<String, String> mapping) {
    	
    	//流水号
		String serialNum = SerialNumUtil.getSerialNum();
    	
    	Map<String,List<Map<String, Object>>> map = new HashMap<String,List<Map<String, Object>>>();
    	
    	// 返回数据导入数据和报文数据
    	List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
    	
    	// 返回数据导入数据和报文数据
    	List<Map<String, Object>> headList = new ArrayList<Map<String, Object>>();
    	
    	//获取文件名
        String fileName = file.getOriginalFilename();
        String[] fileNameArr = fileName.split("\\.");
        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        
        if(size > 10485760) {
        	if(CollectionUtils.isNotEmpty(headList)) {
        		headList.clear();
        	}
        	logger.error("ImportExcelUtil.parseExcel-导入文件过大，请分割后导入！流水号：",serialNum);
        	Map<String, Object> m = new HashMap<String, Object>();
        	m.put("sysSeqNo", serialNum);
        	m.put("errorCode", "0001");
        	m.put("errorMsg", "导入文件过大，请分割后导入");
        	m.put("respTime", DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
        	headList.add(m);
        	map.put("head", headList);
        	return map;
        }
        
        if(StringUtils.isEmpty(fileName) || size==0){
        	if(CollectionUtils.isNotEmpty(headList)) {
        		headList.clear();
        	}
        	logger.error("ImportExcelUtil.parseExcel-导入文件不能为空！流水号：",serialNum);
        	Map<String, Object> m = new HashMap<String, Object>();
        	m.put("sysSeqNo", serialNum);
        	m.put("errorCode", "0001");
        	m.put("errorMsg", "导入文件数据为空");
        	m.put("respTime", DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
        	headList.add(m);
        	map.put("head", headList);
        	return map;
        }
        InputStream in = null;
        Workbook work = null;
        // 新建一个文件
		File tempFile = null;
    	try {
    		//获取上传文件目录
    		String filePath = ConfigUtil.values("com.dcmd.file.path");
    		
    		File uploadDir = new File(filePath);
    		// 创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
    		if (!uploadDir.exists())
    			uploadDir.mkdirs();
    		tempFile = new File(filePath+File.separator+ new Date().getTime() + "." + fileNameArr[1]);
    		
    		try {
    			file.transferTo(tempFile);
    			
    		} catch (IllegalStateException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
			in = new FileInputStream(tempFile);
    		
    		// 根据文件名来创建Excel工作薄
    		work = getWorkbook(in, fileName);
    		if (null == work) {
    			logger.error("ImportExcelUtil.parseExcel-创建Excel工作薄为空，流水号：",serialNum);
    			if(CollectionUtils.isNotEmpty(headList)) {
    				headList.clear();
            	}
    			Map<String, Object> m = new HashMap<String, Object>();
            	m.put("sysSeqNo", serialNum);
            	m.put("errorCode", "0001");
            	m.put("errorMsg", "创建的Excel工作簿为空");
            	m.put("respTime", DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
            	headList.add(m);
            	map.put("head", headList);
            	return map;
    		}
    		
    		Sheet sheet = null;
    		Row row = null;
    		Cell cell = null;
    		
    		// 遍历Excel中所有的sheet
    		for (int i = 0; i < work.getNumberOfSheets(); i++) {
    			sheet = work.getSheetAt(i);
    			if (sheet == null)
    				continue;
    			
    			// 取第一行标题
    			row = sheet.getRow(0);
    			String title[] = null;
    			if (row != null) {
    				title = new String[row.getLastCellNum()];
    				
    				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
//    					System.out.println(y);
    					//TODO 注释部分可以通过第一行的表头匹配
//    					cell = row.getCell(y);
//    					title[y] = (String) getCellValue(cell);
    					title[y] = getExcelColumnLabel(y);
    				}
    				
    			} else
    				continue;
    			logger.error("ImportExcelUtil.parseExcel-导入模板表头数据：[{}]",JSON.toJSONString(title));
    			
    			// 遍历当前sheet中的所有行
    			for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
    				row = sheet.getRow(j);
    				Map<String, Object> m = new HashMap<String, Object>();
    				// 遍历所有的列
    				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
    					cell = row.getCell(y);
    					if(null == cell) {
    						continue;
    					}
    					String key = title[y].replaceAll(" ", "");
    					m.put(mapping.get(key), getCellValue(cell));
    				}
    				ls.add(m);
    			}
    			
    			if(CollectionUtils.isNotEmpty(headList)) {
    				headList.clear();
            	}
    			Map<String, Object> m = new HashMap<String, Object>();
            	m.put("sysSeqNo", serialNum);
            	m.put("errorCode", "0000");
            	m.put("errorMsg", "导入数据拼装成功");
            	m.put("respTime", DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
            	headList.add(m);
            	map.put("head", headList);
            	
    			map.put("body", ls);
    		}
		} catch (FileNotFoundException e) {
			logger.error("ImportExcelUtil.parseExcel-抛出异常：[{}]",e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				// 删除上传的临时文件
				if (tempFile.exists()) {
					tempFile.delete();
				}
				if(null!=work) {
					work.close();
				}
			} catch (IOException e) {
				logger.error("ImportExcelUtil.parseExcel-关闭work抛出异常：[{}]",e.getMessage());
				e.printStackTrace();
			}
		}
        return map;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param inStr		输入流
     * @param fileName	文件名
     * @return
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        try {
        	if (excel2003L.equals(fileType)) {
        		wb = new HSSFWorkbook(inStr);	// 2003-
        	} else if (excel2007U.equals(fileType)) {
        		wb = new XSSFWorkbook(inStr); // 2007+
        	} 
		} catch (IOException e) {
			logger.error("ImportExcelUtil.getWorkbook-抛出异常：[{}]",e.getMessage());
			e.printStackTrace();
		} 
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     * 
     * @param cell
     * @return
     */
    @SuppressWarnings("deprecation")
	public static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
        DecimalFormat df2 = new DecimalFormat("0"); // 格式化数字

        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            value = cell.getRichStringCellValue().getString();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                value = df.format(cell.getNumericCellValue());
            } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                value = sdf.format(cell.getDateCellValue());
            } else {
                value = df2.format(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            value = cell.getBooleanCellValue();
            break;
        case Cell.CELL_TYPE_BLANK:
            value = "";
            break;
        default:
            break;
        }
        return value;
    }
    
    private static String getExcelColumnLabel(int num) {
		String temp = "";
		double i = Math.floor(Math.log(25.0 * (num) / 26.0 + 1) / Math.log(26)) + 1;
		if (i > 1) {
			double sub = num - 26 * (Math.pow(26, i - 1) - 1) / 25;
			for (double j = i; j > 0; j--) {
				temp = temp + (char) (sub / Math.pow(26, j - 1) + 65);
				sub = sub % Math.pow(26, j - 1);
			}
		} else {
			temp = temp + (char) (num + 65);
		}
		return temp;
	}

}
