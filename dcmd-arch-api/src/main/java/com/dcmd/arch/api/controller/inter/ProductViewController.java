package com.dcmd.arch.api.controller.inter;

import com.dcmd.arch.api.service.ProductViewService;
import com.dcmd.arch.api.service.TInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("productViewController")
public class ProductViewController {
    @Autowired
    private ProductViewService productViewService;

    @Autowired
    private TInstitutionService tInstitutionService;

    /**
     * 获取SoftwareName名称
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSoftwareName")
    public List<Map<String, Object>> getSoftwareName() throws Exception {
        return productViewService.getSoftwareName();
    }


    /**
     * 获取sourceNum
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSourceNum")
    public List<Map<String, Object>> getSourceNum() throws Exception {
        return productViewService.getSourceNum();
    }


    /**
     * 获取统计数
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/getCountNum")
    public List getCountNum(@RequestBody String tyep, String time) throws Exception {
        ArrayList arrayList = new ArrayList();
        List list = productViewService.get();
        for (Object str : list) {
            int countNum = productViewService.getCountNum(str.toString(), tyep, time);
            arrayList.add(countNum);
            return arrayList;
        }
        return null;
    }

}
