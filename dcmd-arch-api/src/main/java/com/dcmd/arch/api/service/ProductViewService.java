package com.dcmd.arch.api.service;


import com.dcmd.arch.api.entity.ProductView;

import java.util.List;
import java.util.Map;

public interface ProductViewService {
    int insert(ProductView record);

    List<ProductView> selectAll();

    /**
     * 获取software_name
     * @return
     */
    List<Map<String,Object>> getSoftwareName()throws Exception;
    /**
     * 获取sourceNum
     * @return
     */
    List<Map<String,Object>>getSourceNum()throws Exception;


    /**
     * 统计数
     * @return
     * @throws Exception
     */
    int getCountNum(String department, String type, String time)throws Exception;


    List get()throws Exception;
}