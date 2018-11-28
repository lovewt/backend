package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.ProductView;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductViewMapper {
    int insert(ProductView record);

    List<ProductView> selectAll();

    /**
     * 获取sourceNum
     * @return
     */
    List<Map<String,Object>>getSourceNum();
    /**
     * 统计数
     * @return
     * @throws Exception
     */
    int getCountNum(String department, String type, String time);

    List get();
}