package com.dcmd.arch.api.service.impl;

import com.dcmd.arch.api.entity.ProductView;
import com.dcmd.arch.api.mapper.ProductViewMapper;
import com.dcmd.arch.api.mapper.SoftwareProductMapper;
import com.dcmd.arch.api.service.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductViewServiceImpl implements ProductViewService {

    @Autowired
    private ProductViewMapper productViewMapper;

    @Autowired
    private SoftwareProductMapper softwareProductMapper;

    @Override
    public int insert(ProductView record) {
        return productViewMapper.insert(record);
    }

    @Override
    public List<ProductView> selectAll() {
        return productViewMapper.selectAll();
    }

    @Override
    public List<Map<String, Object>> getSoftwareName() throws Exception {
        return softwareProductMapper.getSoftwareName();
    }

    @Override
    public List<Map<String, Object>> getSourceNum() throws Exception {
        return productViewMapper.getSourceNum();
    }

    @Override
    public int getCountNum(String department, String type, String time) throws Exception {
        return productViewMapper.getCountNum(department, type, time);
    }

    @Override
    public List get() throws Exception {
        return productViewMapper.get();
    }
}
