package com.dcmd.arch.api.controller.inter;

import com.alibaba.fastjson.JSONObject;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.IntInvokeRelation;
import com.dcmd.arch.api.service.IntInvokeRelationService;
import com.dcmd.common.core.utils.AjaxResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("invokeRelation")
public class IntInvokeRelationController {
    @Autowired
    private IntInvokeRelationService intInvokeRelationService;

    /**
     * 获取所有数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllDatas")
    public List<IntInvokeRelation> getAllDatas() throws Exception {
        return intInvokeRelationService.getAllDatas();
    }

    /**
     * 获取所有数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getCheckDatas")
    public List<IntInvokeRelation> getCheckDatas() throws Exception {
        return intInvokeRelationService.getCheckDatas();
    }

    /**
     * 获取所有的产品线
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSoftLines")
    public List<Map<String, String>> getSoftLines() throws Exception {
        return intInvokeRelationService.getSoftLines();
    }

    /**
     * 根据产品线获取产品
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSoftProduct/{softlineId}")
    public List<Dropdown> getSoftProduct(@PathVariable String softlineId) throws Exception {
        return intInvokeRelationService.getSoftProduct(softlineId);
    }

    /**
     * 查询状态
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/searchState")
    public List<Dropdown> searchState() throws Exception {
        return intInvokeRelationService.searchState();
    }

    /**
     * 新增
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody JSONObject jsonObject) throws Exception {
        intInvokeRelationService.insert(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 修改
     *
     * @return
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody JSONObject jsonObject) throws Exception {
        intInvokeRelationService.update(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 多条删除
     *
     * @param
     * @return
     */
    @PostMapping("/batchDelectData")
    public AjaxResultUtil batchDelectData(@RequestBody List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelationService.batchDelectData(intInvokeRelations);
        return new AjaxResultUtil();
    }

    /**
     * 复核
     *
     * @return
     */
    @PostMapping("/updateCheck")
    public AjaxResultUtil updateCheck(@RequestBody JSONObject jsonObject) throws Exception {
        intInvokeRelationService.updateCheck(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 复核多条删除
     *
     * @param
     * @return
     */
    @PostMapping("/batchDelectCheckData")
    public AjaxResultUtil batchDelectCheckData(@RequestBody List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelationService.batchDelectCheckData(intInvokeRelations);
        return new AjaxResultUtil();
    }

    /**
     * 复核批量通过
     *
     * @param
     * @return
     */
    @PostMapping("/batchUpdateCheck")
    public AjaxResultUtil batchUpdateCheck(@RequestBody List<IntInvokeRelation> intInvokeRelations) throws Exception {
        intInvokeRelationService.batchUpdateCheck(intInvokeRelations);
        return new AjaxResultUtil();
    }

    /**
     * 导入excel
     *
     * @param
     * @return
     */
    @PostMapping(value = "/import")
    public AjaxResultUtil importExcel(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        intInvokeRelationService.importData(file);
        return new AjaxResultUtil();
    }

    /**
     * 高级搜索
     *
     * @param
     * @return
     */
    @PostMapping(value = "/advancedSearch")
    public List<IntInvokeRelation> advancedSearch(@RequestBody JSONObject jsonObject) throws Exception {
        return intInvokeRelationService.advancedSearch(jsonObject);
    }
}
