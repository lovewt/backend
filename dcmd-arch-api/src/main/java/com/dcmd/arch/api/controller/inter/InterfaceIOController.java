package com.dcmd.arch.api.controller.inter;


import com.alibaba.fastjson.JSONObject;
import com.dcmd.arch.api.entity.Dropdown;
import com.dcmd.arch.api.entity.InterfaceIO;
import com.dcmd.arch.api.service.InterfaceIOService;
import com.dcmd.common.core.utils.AjaxResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("interfaceIO")
public class InterfaceIOController {
    @Autowired
    private InterfaceIOService interfaceIOService;

    /**
     * 获取所有数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllDatas/{intServiceNum}")
    public List<InterfaceIO> getAllDatas(@PathVariable("intServiceNum") String intServiceNum) throws Exception {
        return interfaceIOService.getAllDatas(intServiceNum);
    }
    /**
     * 获取接口中英文名称
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getTitleData/{intServiceNum}")
    public Map<String,String> getTitleData(@PathVariable("intServiceNum") String intServiceNum) throws Exception {
        return interfaceIOService.getTitleData(intServiceNum);

    }

    /**
     * 获取所有复核数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getCheckDatas/{intServiceNum}")
    public List<InterfaceIO> getCheckDatas(@PathVariable("intServiceNum") String intServiceNum) throws Exception {
        return interfaceIOService.getCheckDatas(intServiceNum);
    }



    /**
     * 新增
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceIOService.insert(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 修改
     *
     * @return
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceIOService.update(jsonObject);
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
        interfaceIOService.batchDelectData(ids);
        return new AjaxResultUtil();
    }

    /**
     * 复核
     *
     * @return
     */
    @PostMapping("/updateCheck")
    public AjaxResultUtil updateCheck(@RequestBody JSONObject jsonObject) throws Exception {
        interfaceIOService.updateCheck(jsonObject);
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
        interfaceIOService.batchDelectCheckData(ids);
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
        interfaceIOService.batchUpdateCheck(ids);
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
        return interfaceIOService.getClasses();
    }

    /**
     * 导入excel
     *
     * @param
     * @return
     */
    @PostMapping(value = "/import")
    public AjaxResultUtil importExcel(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        interfaceIOService.importData(file);
        return new AjaxResultUtil();
    }

    /**
     * 查询属性类型
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getPropertyTypes")
    public List<Dropdown> getPropertyTypes() throws Exception {
        return interfaceIOService.getPropertyTypes();
    }

}
