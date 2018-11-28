package com.dcmd.arch.api.controller.inter;

import com.dc.dcit.common.util.R;
import com.dc.dcit.common.util.ReadExcel;
import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.arch.api.entity.SoftwareProduct;
import com.dcmd.arch.api.entity.TInstitution;
import com.dcmd.arch.api.entity.TUsermaster;
import com.dcmd.arch.api.service.BasParameterService;
import com.dcmd.arch.api.service.SoftwareProductService;
import com.dcmd.arch.api.service.TInstitutionService;
import com.dcmd.common.core.utils.AjaxResultUtil;
import com.dcmd.common.core.vo.BasParameterVo;
import com.dcmd.common.core.vo.SoftwareProductVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

@RestController
@RequestMapping("softwareProductController")
public class SoftwareProductController {
    @Autowired
    private SoftwareProductService softwareProductService;

    @Autowired
    private TInstitutionService tInstitutionService;

    @Autowired
    private BasParameterService basParameterService;

    /**
     * 获取所有
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllData")
    public List<SoftwareProduct> selectAll() throws Exception {
        return softwareProductService.selectAll();
    }

    /**
     * 查询软件列表页面
     */
    @GetMapping("/softwareList")
    public List<SoftwareProduct> queryProductList() throws Exception {
        return softwareProductService.queryProductList();
    }

    /**
     * 查询复核软件列表页面
     */
    @GetMapping("/check")
    public List<SoftwareProduct> check() throws Exception {
        return softwareProductService.check();
    }

    /**
     * 新增软件产品
     */
    @PostMapping("/insert")
    public AjaxResultUtil insert(@RequestBody SoftwareProduct softwareProduct) throws Exception {
        softwareProductService.insert(softwareProduct);
        return new AjaxResultUtil();
    }

    /**
     * 软件数据修改保存
     */
    @PostMapping("/update")
    public AjaxResultUtil update(@RequestBody SoftwareProduct softwareProduct) throws Exception {
        softwareProductService.updateByPrimaryKey(softwareProduct);
        return new AjaxResultUtil();
    }

    /**
     * 复核软件数据修改保存
     */
    @PostMapping("/checkUpdate")
    public AjaxResultUtil checkUpdate(@RequestParam String softwareNum) throws Exception {
        softwareProductService.checkUpdate(softwareNum);
        return new AjaxResultUtil();
    }

    /**
     * 复核批量通过
     */
    @PostMapping("/pass")
    public AjaxResultUtil pass(@RequestBody String[] ids) throws Exception {
        softwareProductService.pass(ids);
        return new AjaxResultUtil();
    }

    /**
     * 删除数据
     */
    @PostMapping("/deleteOne")
    public AjaxResultUtil delete(@RequestParam("id") String id) throws Exception {
        softwareProductService.deleteByPrimaryKey(id);
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
        softwareProductService.deleteIds(ids);
        return new AjaxResultUtil();
    }


    /**
     * 获取机构
     */
    @GetMapping("/getInstOfIT")
    public List<TInstitution> getInstOfIT() throws Exception {
        return tInstitutionService.getInstOfIT();
    }

    /**
     * 获取机构
     */
    @GetMapping("/getInstOfBU")
    public List<TInstitution> getInstOfBU() throws Exception {
        return tInstitutionService.getInstOfBU();
    }


    /**
     * 获取软件产品相关员工信息
     */
    @GetMapping("/getEmpOfSoft")
    public List<TUsermaster> getEmpOfSoft() throws Exception {
        return softwareProductService.getEmpOfSoft();
    }

    /**
     * 获取软件状态
     */
    @GetMapping("/getSoftStatus")
    public List<BasParameter> getSoftStatus() throws Exception {
        return softwareProductService.getSoftStatus();
    }

    /**
     * 获取采购方式
     */
    @GetMapping("/getProcMethod")
    public List<BasParameter> getProcMethod() throws Exception {
        return softwareProductService.getProcMethod();
    }

    /**
     * 获取自主可控等级
     */
    @GetMapping("/getACLevel")
    public List<BasParameter> getACLevel() throws Exception {
        return softwareProductService.getACLevel();
    }

    /**
     * 获取实施方式
     */
    @GetMapping("/getDevMethod")
    public List<BasParameter> getDevMethod() throws Exception {
        return softwareProductService.getDevMethod();
    }

    /**
     * 获取软件系统
     */
    @GetMapping("/getSoftSys")
    public List<BasParameter> getSoftSys() throws Exception {
        return softwareProductService.getSoftSys();
    }

    /**
     * 获取软件标志
     */
    @GetMapping("/getSoftwareMark")
    public List<BasParameter> getSoftwareMark() throws Exception {
        return softwareProductService.getSoftwareMark();
    }

    /**
     * 获取全部软件产品
     */
    @GetMapping("/getAllSoftProd")
    public List<SoftwareProduct> getAllSoftProd() throws Exception {
        return softwareProductService.getAllSoftProd();
    }

    /**
     * 获取新增软件产品
     */
    @GetMapping("/getSoftProd")
    public List<SoftwareProduct> getSoftProd(HttpServletRequest request) throws Exception {
        Map<String, Object> datemap = new HashMap<>();
        String product_leader = request.getParameter("userName");
        String group = request.getParameter("group");
        List<String> namesList = new ArrayList<String>();
        String[] namesValue = group.split(",");
        for (String str : namesValue) {
            namesList.add(str);
        }
        datemap.put("product_leader", product_leader);
        datemap.put("namesList", namesList);
        String[] role = softwareProductService.getRole(datemap);
        if (role.length > 0) {
            if (role[0].equals("1")) {
                return softwareProductService.getAllSoftProd();
            } else {
                return softwareProductService.getSoftProd();
            }
        }
        if (role.length == 0) {
            return softwareProductService.getSoftProd();
        }
        return null;
    }

    /**
     * 获取全部软件产品
     */
    @GetMapping("/getIEName")
    public List<BasParameter> getIEName() throws Exception {
        return softwareProductService.getIEName();
    }

    /**
     * 获取浏览器用户类型
     */
    @GetMapping("/getUserType")
    public List<BasParameter> getUserType() throws Exception {
        return softwareProductService.getUserType();
    }

    /**
     * 查询所有负责人列表
     */
    @GetMapping("/getLeader")
    public List<TUsermaster> getLeader() throws Exception {
        return softwareProductService.getLeader();
    }

    /**
     * 查询所有pmo列表
     */
    @GetMapping("/getPmo")
    public List<TUsermaster> getPmo() throws Exception {
        return softwareProductService.getPmo();
    }

    /**
     * 查询技术接口数据
     */
    @GetMapping("/search")
    public List<SoftwareProduct> search(SoftwareProduct softwareProduct) throws Exception {
        return softwareProductService.search(softwareProduct);

    }

    /**
     * 查询技术接口数据
     */
    @GetMapping("/getDepartment")
    public List getDepartment() throws Exception {
        return softwareProductService.getDepartment();

    }

    /**
     * 查询产品名称是否重复
     *
     * @param softwareList
     * @return
     */
    @PostMapping("/searchUserFromUserList")
    public List<String> searchUserFromUserList(List<SoftwareProduct> softwareList) throws Exception {
        if (softwareList == null || softwareList.isEmpty()) {
            return null;
        }
        return softwareProductService.selectUserFromUserList(softwareList);
    }


    @PostMapping("/uploadUsers")
    public R uploadUsers(MultipartFile file) throws Exception {
        if (file == null) {
            return new R(new RuntimeException("文件为空或不存在"));
        }
        ReadExcel<SoftwareProduct> readExcel = new ReadExcel<>(new SoftwareProduct());
        readExcel.setStartCol(0);
        readExcel.setStartRow(1);
        String[] columns = {"softwareSysCode", "softwareName", "type", "coreSoftwareMarkName", "statusName", "launchDate", "offlineDate", "deptName",
                "businessOwnerName", "productLeaderName", "baPrimaryName", "baSecondaryName", "saPrimaryName", "saSecondaryName", "testLeaderName", "servicePrimaryName", "serviceSecondaryName", "projectLeader",
                "description", "customerSysName", "businessRep", "procureMethodName", "devMethodName", "cooperationPartner", "acLevel", "drLevel", "infraId", "state"};
        readExcel.setColumns(columns);
        Long start = (new Date()).getTime();
        List<SoftwareProduct> userDTOList = readExcel.parseExcel2ObjList(file);
        Long end = (new Date()).getTime();
        if (userDTOList.isEmpty()) {
            return new R(new RuntimeException("未读取到软件产品信息"));
        }
        List<String> usernameList = searchUserFromUserList(userDTOList);
        if (usernameList.size() > 0) {
            return new R(new RuntimeException("软件产品名称存在:" + usernameList + ",请更改后导入"));
        }
        boolean flg;
        try {
            flg = softwareProductService.insertUserInfo(userDTOList);
        } catch (Exception e) {
            String einfo = getStackTrace(e.fillInStackTrace());
            String e_info = einfo.substring(einfo.indexOf("###") + 3, einfo.lastIndexOf("###"));
            if (e_info.contains("Duplicate entry")) {
                String errorinfo = e_info.substring(e_info.indexOf("Duplicate entry"));
                int i = errorinfo.indexOf("\'");
                return new R(new RuntimeException("用户数据有重复："
                        + errorinfo.substring(i + 1, errorinfo.indexOf("\'", i + 1)) + ",请更改后导入"));
            } else {
                return new R(new RuntimeException("导入数据出错"));
            }
        }
        return new R(flg);
    }


    /**
     * 获取异常详细信息
     */
    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }

    /**
     * 获取产品产品线
     */
    @GetMapping("/getProductInfo")
    public List<Map<String, Object>> getProductInfo() throws Exception {
        return softwareProductService.getProductInfo();
    }

    /**
     * 获取所有产品线
     */
    @GetMapping("/getProductLine")
    List<BasParameterVo> getProductLine() throws Exception {
        return basParameterService.getProductLine();
    }

    /**
     * 获取所有产品
     */
    @GetMapping("/getProduct")
    List<SoftwareProductVo> getProduct() throws Exception {
        return softwareProductService.getProduct();
    }
}
