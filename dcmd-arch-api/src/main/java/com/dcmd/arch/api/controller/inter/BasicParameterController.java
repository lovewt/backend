package com.dcmd.arch.api.controller.inter;

import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.arch.api.service.BasParameterService;
import com.dcmd.common.core.utils.AjaxResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basicParameterController")
public class BasicParameterController {
    @Autowired
    private BasParameterService basParameterService;

    /**
     * 获取所有
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllData")
    public List<BasParameter> selectAll() throws Exception {
        return basParameterService.selectAll();
    }


    /**
     * c查询单条
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/queryOne")
    public BasParameter queryById(Integer id) throws Exception {
        return basParameterService.selectByPrimaryKey(id);
    }


    /**
     * 新增软件产品
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody BasParameter basParameter) throws Exception {
        basParameterService.insert(basParameter);
        return new AjaxResultUtil();
    }

    /**
     * 软件数据修改保存
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody BasParameter basParameter) throws Exception {
        basParameterService.updateByPrimaryKey(basParameter);
        return new AjaxResultUtil();
    }

    /**
     * 删除数据
     */
    @PostMapping("/deleteOne")
    public AjaxResultUtil delete(@RequestParam("id") Integer id) throws Exception {
        basParameterService.deleteByPrimaryKey(id);
        return new AjaxResultUtil();
    }

    /**
     * 多条删除
     *
     * @param
     * @return
     */
    @ApiOperation(value = "删除需求", notes = "多条删除")
    @PostMapping("/deleteMore")
    public AjaxResultUtil deletes(@RequestBody String[] ids) throws Exception {
        basParameterService.deleteIds(ids);
        return new AjaxResultUtil();
    }

}
