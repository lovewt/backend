package com.dcmd.arch.api.controller.inter;

import com.alibaba.fastjson.JSONObject;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.InterfaceAnalysis;
import com.dcmd.arch.api.service.InterfaceAnalysisService;
import com.dcmd.common.core.utils.AjaxResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("interfaceAnalysis")
public class InterfaceAnalysisController {
    @Autowired
    private InterfaceAnalysisService interfaceAnalysisService;

    /**
     * 获取所有数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllDatas")
    public List<InterfaceAnalysis> getAllDatas() throws Exception {
        return interfaceAnalysisService.getAllDatas();
    }

    /**
     * 获取所有数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getCheckDatas")
    public List<InterfaceAnalysis> getCheckDatas() throws Exception {
        return interfaceAnalysisService.getCheckDatas();
    }

    /**
     * 获取所有的产品线
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSoftLines")
    public List<Map<String, String>> getSoftLines() throws Exception {
        return interfaceAnalysisService.getSoftLines();
    }

    /**
     * 根据产品线获取产品
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getSoftProduct/{softlineId}")
    public List<Dropdown> getSoftProduct(@PathVariable String softlineId) throws Exception {
        return interfaceAnalysisService.getSoftProduct(softlineId);
    }

    /**
     * 根据产品获取接口
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getApiNameBySoftnum/{softwareId}")
    public List<Dropdown> getApiNameBySoftnum(@PathVariable String softwareId) throws Exception {
        return interfaceAnalysisService.getApiNameBySoftnum(softwareId);
    }

    /**
     * 查询状态
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/searchState")
    public List<Dropdown> searchState() throws Exception {
        return interfaceAnalysisService.searchState();
    }

    /**
     * 新增
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceAnalysisService.insert(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 修改
     *
     * @return
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceAnalysisService.update(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 多条删除
     *
     * @param
     * @return
     */
    @PostMapping("/batchDelectData")
    public AjaxResultUtil batchDelectData(@RequestBody String[] ids) throws Exception {
        interfaceAnalysisService.batchDelectData(ids);
        return new AjaxResultUtil();
    }

    /**
     * 复核
     *
     * @return
     */
    @PostMapping("/updateCheck")
    public AjaxResultUtil updateCheck(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceAnalysisService.updateCheck(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 复核多条删除
     *
     * @param
     * @return
     */
    @PostMapping("/batchDelectCheckData")
    public AjaxResultUtil batchDelectCheckData(@RequestBody String[] ids) throws Exception {
        interfaceAnalysisService.batchDelectCheckData(ids);
        return new AjaxResultUtil();
    }

    /**
     * 复核批量通过
     *
     * @param
     * @return
     */
    @PostMapping("/batchUpdateCheck")
    public AjaxResultUtil batchUpdateCheck(@RequestBody String[] ids) throws Exception {
        interfaceAnalysisService.batchUpdateCheck(ids);
        return new AjaxResultUtil();
    }

    /**
     * 查询状态
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getClasses")
    public List<Dropdown> getClasses() throws Exception {
        return interfaceAnalysisService.getClasses();
    }

    /**
     * 导入excel
     *
     * @param
     * @return
     */
    @PostMapping(value = "/import")
    public AjaxResultUtil importExcel(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        interfaceAnalysisService.importData(file);
        return new AjaxResultUtil();
    }

    /**
     * 批量发布
     *
     * @param
     * @return
     */
    @PostMapping("/release")
    public AjaxResultUtil release(@RequestBody String[] ids) throws Exception {
        interfaceAnalysisService.release(ids);
        return new AjaxResultUtil();
    }

    /**
     * 批量离线
     *
     * @param
     * @return
     */
    @PostMapping("/offLine")
    public AjaxResultUtil offLine(@RequestBody String[] ids) throws Exception {
        interfaceAnalysisService.offLine(ids);
        return new AjaxResultUtil();
    }

}
