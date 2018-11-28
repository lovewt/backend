package com.dcmd.common.core.util;

import com.dc.dcit.common.util.BeanUtils;
import jxl.*;
import jxl.read.biff.BiffException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class ReadExcel<T> {
	private final static String excel2003L = "xls"; // 2003- 版本的excel
    private final static String excel2007U = "xlsx"; // 2007+ 版本的excel
	
	private T ty;//辅助创建t对象
	private int startRow;//读取的起始行
	private int startCol;//读取的起始列
	private String[] columns;//列字段
	
	public ReadExcel(T t){//实例化工具时必须传入T的实例化对象
		this.ty=t;
	}
 
    public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}

	private static final Log log = LogFactory.getLog(com.dc.dcit.common.util.ReadExcel.class);
 
     
    /**
     * 判断后缀分批入
     */
    public List<T> parseExcel2ObjList(MultipartFile uploadFile){
         
    	List<T> mdafeList = new ArrayList<T>();
    	String fileName = uploadFile.getOriginalFilename();
        String [] pfix= fileName.split("\\.");
        String suffix = pfix[pfix.length -1];
        InputStream ins = null;
		try {
			ins = uploadFile.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        if(suffix.equals(excel2003L)){
             
            log.info(excel2003L);
            // jxl方法可读取.xls格式
            mdafeList = jxlExcel(ins);
        }else if(suffix .equals(excel2007U)){
             
        	log.info(excel2007U);
            // poi方法可读取Excel2007即.xlsx格式
            mdafeList = poiExcel(ins);
        }
		return mdafeList;
    }
     
    /**
     * 读取 xls JXL
     * @param realPath
     * @param fileName
     */
    private List<T>  jxlExcel(InputStream str){
    		List<T> tList = new ArrayList<T>();
            try{
            // 构造Workbook（工作薄）对象
            Workbook rwb=Workbook.getWorkbook(str);
            Sheet[] rss = rwb.getSheets();
            Sheet rs=rwb.getSheet(0);//获取第一张工作表
            int rsRows=rs.getRows();//获取Sheet表中所包含的总行数
            int rsCols=rs.getColumns();//获取Sheet表中所包含的总列数
            log.info("========行========"+rsRows+"=====列========"+rsCols);
            for(int i=startRow;i<rsRows;i++){//读取行
            	T t = (T) BeanUtils.newInstance(ty.getClass());
                log.info("========执行第========"+i+"行");
                for(int j=startCol;j<rsCols;j++){
                    log.info("========执行第========"+j+"列");
                    Cell cell=rs.getCell(j, i);//单元格定位列，再定位行
                    if(rs.getCell(startCol, i).getType()==CellType.EMPTY
                    		||rs.getCell(startCol, i)==null){
                    	return tList;
                    }
                    String strc;
                    if (cell.getType() == CellType.DATE) {//手动填写模板文件时为 date 类型，其他情况有可能不是date类型
                        DateCell dc = (DateCell) cell;
                        Date date = dc.getDate();
                        TimeZone zone = TimeZone.getTimeZone("GMT");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                        sdf.setTimeZone(zone);
                        strc = sdf.format(date);
                    }
                    else {
                    	strc = cell.getContents().trim();
                    }
                    BeanUtils.setProperty(t, columns[j-startCol], strc);
                }
                tList.add(t);
            }
            rwb.close(); 
            }catch (FileNotFoundException e) {  
                 e.printStackTrace();  
            } catch (BiffException e) {  
             e.printStackTrace();  
            } catch (IOException e) {  
             e.printStackTrace();  
            }  
              return tList;   
            //==========读取excel文件内容=结束=====================
             
    }
     
    /**
     * POI读取   xlsx
     * @param realPath
     * @param fileName
     */
    private List<T> poiExcel(InputStream str){
    	List<T> tList = new ArrayList<T>();
        try{
            XSSFWorkbook xwb = new XSSFWorkbook(str);  //利用poi读取excel文件流
            XSSFSheet st = xwb.getSheetAt(0);  //读取sheet的第一个工作表
            int rows=st.getLastRowNum();//总行数
            int cols;//总列数
            log.info("========行========"+rows);
            for(int i=startRow;i<=rows;i++){
            	T t = BeanUtils.newInstance(ty.getClass());
                XSSFRow row=st.getRow(i);//读取某一行数据
                if(row.getCell(startCol)==null||row.getCell(startCol).getCellType()==XSSFCell.CELL_TYPE_BLANK){
                	return tList;
                }
                if(row!=null){
                    //获取行中所有列数据
                    cols=row.getLastCellNum();
                    log.info("========行========"+rows+"=====列========"+cols);
                for(int j=startCol;j<cols;j++){
                    XSSFCell cell=row.getCell(j);
                    Object objvalue = null;
                    DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 日期格式化
                    DecimalFormat df2 = new DecimalFormat("0"); // 格式化数字
                    if(cell==null){
                        System.out.print("   ");
                    }else{
                    //判断单元格的数据类型
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_NUMERIC: // 数字
                        	if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                        		objvalue = df.format(cell.getNumericCellValue());
                            } else if ("yyyy/mm/dd".equals(cell.getCellStyle().getDataFormatString())) {
                            	objvalue = sdf.format(cell.getDateCellValue());
                            } else {
                            	objvalue = df2.format(cell.getNumericCellValue());
                            }
                        	if(j==2||j==5) {
                        		objvalue = Integer.parseInt(objvalue.toString());
                        	}
                            break;
                        case XSSFCell.CELL_TYPE_STRING: // 字符串*/
                                objvalue = cell.getStringCellValue(); 
                           break;
                        case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        	objvalue = cell.getBooleanCellValue()+"";
                            break;
                        case XSSFCell.CELL_TYPE_FORMULA: // 公式
                        	objvalue = ((Integer)new Double(cell.getNumericCellValue()).intValue()).toString();
                            System.out.print(cell.getCellFormula() + "   ");
                            break;
                        case XSSFCell.CELL_TYPE_BLANK: // 空值
                        	objvalue = "";
                            break;
                        case XSSFCell.CELL_TYPE_ERROR: // 故障
                        	objvalue = "值类型异常";
                            break;
                        default:
                        	objvalue = "未知类型   ";
                            break;
                        }
                }
                    BeanUtils.setProperty(t, columns[j-startCol], objvalue);
                }
                }
                tList.add(t);
            }
        }catch(IOException e){
            e.printStackTrace();  
        }
         return tList;
    }
     
}
