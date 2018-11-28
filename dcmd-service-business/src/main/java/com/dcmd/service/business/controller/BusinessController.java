package com.dcmd.service.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.dcmd.common.core.utils.AjaxResultUtil;
import com.dcmd.service.business.entity.Business;
import com.dcmd.service.business.entity.Dropdown;
import com.dcmd.service.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by 1 on 2018/7/3.
 */
@RestController
@RequestMapping("/businessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody JSONObject jsonObject) throws Exception {
        businessService.insert(jsonObject);
        return new AjaxResultUtil();
    }

    /**
     * 单条数据删除
     *
     * @param id
     */
    @PostMapping("/delete/{id}")
    public AjaxResultUtil delete(@PathVariable Long id) throws Exception {
        businessService.deleteByPrimaryKey(id);
        return new AjaxResultUtil();
    }

    /**
     * 多条数据删除
     *
     * @param ids
     */
    @PostMapping("/deletes")
    public AjaxResultUtil deletes(@RequestBody Long[] ids) throws Exception {
        return businessService.deletes(ids);
    }

    /**
     * 修改业务功能
     *
     * @param
     * @return
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody JSONObject jsonObject) throws Exception {
        businessService.updateByPrimaryKey(jsonObject);
        return new AjaxResultUtil();
    }


    /**
     * 查询单条信息
     *
     * @param id
     * @return
     */
    @GetMapping("/selectOne/{id}")
    public Business selectOne(@PathVariable Long id) throws Exception {
        return businessService.selectByPrimaryKey(id);
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    @GetMapping("/selectAll")
    public List<Business> selectAll() throws Exception {
        return businessService.selectAll();
    }

    /**
     * 获取所有数据
     *
     * @return
     */
    @GetMapping("/queryAllDatas")
    public List<Business> queryAllDatas() throws Exception {
        return businessService.queryAllDatas();
    }


    /**
     * 获取软件产品
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getProductName")
    public List<Map<String, String>> getProductName() throws Exception {
        return businessService.getProductName();
    }

    /**
     * 根据特定条件查询
     * <p>业务等级、功能、业务功能关联关系、系统</p>
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum")
    public List<Map<String, Object>> selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(@RequestBody JSONObject jsonObject) throws Exception {
        return businessService.selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(jsonObject);
    }

    /**
     * 拿到所有业务类型数据
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessLevelInfo")
    public List<LinkedHashMap<String, Object>> getBusinessLevelInfo() throws Exception {
        return businessService.getBusinessLevelInfo();
    }

    /**
     * 获取业务类型下拉框
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessLevelType")
    public List<Dropdown> getBusinessLevelType() throws Exception {
        return businessService.getBusinessLevelType();
    }

    /**
     * 获取逐级下拉框
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessLevelList")
    public List<Dropdown> getBusinessLevelList(String id) throws Exception {
        return businessService.getBusinessLevelList(id);
    }

    /**
     * 获取功能点与业务关联List
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getFeaturesBusinessList")
    public List<Dropdown> getFeaturesBusinessList() throws Exception {
        return businessService.getFeaturesBusinessList();
    }

    /**
     * 获取业务三四五级
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessTypeLevelFive")
    public Map getBusinessTypeLevelFive() throws Exception {
        return businessService.getBusinessTypeLevelFive();
    }

    /**
     * 获取业务类型及一二级
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessTypeLevelTwo")
    public Map getBusinessTypeLevelThreee() throws Exception {
        return businessService.getBusinessTypeLevelTwo();
    }

    /**
     * 获取业务类型及所有级别加功能点
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessTypeLevelAndAllData")
    public Map getBusinessTypeLevelAndSize() throws Exception {
        return businessService.getBusinessTypeLevelAndAllData();
    }

    /**
     * 所有的级别一到五级及业务类型
     * @return
     * @throws Exception
     */
    @GetMapping("/getBusinessTypeLevelAndAllLevel")
    public Map getBusinessTypeLevelAndAllLevel() throws Exception {
        return businessService.getBusinessTypeLevelAndAllLevel();
    }



//    static int id=0;
    public static int random=1;
    public static int getId(){
        //获取6位随机数
//        int random=(int) ((Math.random()+1)*1);
//        for(int i=0;i<1000;i++){
//            random+=1;
//        }
//        id= random;
//        return String.valueOf(random);
        return random+=1;
    }
    public static void main(String[] args) {
//        for(int i=1;i<=20;i++){
        int id = getId();
        System.out.println(id);
//        }
    }

}
