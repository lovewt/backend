package com.dcmd.arch.api.service.impl;

import com.dcmd.arch.api.entity.BasParameter;
import com.dcmd.arch.api.entity.SoftwareProduct;
import com.dcmd.arch.api.entity.TInstitution;
import com.dcmd.arch.api.entity.TUsermaster;
import com.dcmd.arch.api.mapper.BasParameterMapper;
import com.dcmd.arch.api.mapper.SoftwareProductMapper;
import com.dcmd.arch.api.mapper.TInstitutionMapper;
import com.dcmd.arch.api.mapper.TUsermasterMapper;
import com.dcmd.arch.api.service.SoftwareProductService;
import com.dcmd.common.core.utils.FixedExecutors;
import com.dcmd.common.core.vo.SoftwareProductVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by 1 on 2018/7/3.
 */
@Service
public class SoftwareProductImpl implements SoftwareProductService {
    @Autowired
    private SoftwareProductMapper softwareProductMapper;
    @Autowired
    private TUsermasterMapper tUsermasterMapper;
    @Autowired
    private TInstitutionMapper institutionMapper;
    @Autowired
    private BasParameterMapper basParameterMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        return softwareProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * D多条删除
     *
     * @param ids
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteIds(String[] ids) throws Exception {
        softwareProductMapper.deleteIds(ids);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(SoftwareProduct record) throws Exception {
        softwareProductMapper.insert(record);
    }

    @Override
    public SoftwareProduct selectByPrimaryKey(Integer id) throws Exception {
        return softwareProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SoftwareProduct> selectAll() throws Exception {
        return softwareProductMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(SoftwareProduct record) throws Exception {
        return softwareProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SoftwareProduct> queryProductList() throws Exception {
        return softwareProductMapper.queryProductList();
    }

    @Override
    public List<SoftwareProduct> check() throws Exception {
        return softwareProductMapper.check();
    }

    @Override
    public int checkUpdate(String softwareNum) throws Exception {
        return softwareProductMapper.checkUpdate(softwareNum);
    }

    @Override
    public int pass(String[] ids) throws Exception {
        return softwareProductMapper.pass(ids);
    }

    @Override
    public List<TUsermaster> getEmpOfSoft() throws Exception {
        return tUsermasterMapper.getEmpOfSoft();
    }

    @Override
    public List<BasParameter> getSoftStatus() throws Exception {
        return basParameterMapper.getSoftStatus();
    }

    @Override
    public List<BasParameter> getProcMethod() throws Exception {
        return basParameterMapper.getProcMethod();
    }

    @Override
    public List<BasParameter> getACLevel() throws Exception {
        return basParameterMapper.getACLevel();
    }

    @Override
    public List<BasParameter> getDevMethod() throws Exception {
        return basParameterMapper.getDevMethod();
    }

    @Override
    public List<BasParameter> getSoftSys() throws Exception {
        return basParameterMapper.getSoftSys();
    }

    /**
     * 软件标志
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<BasParameter> getSoftwareMark() throws Exception {
        return basParameterMapper.getSoftwareMark();
    }

    @Override
    public List<Map<String, String>> getDepartment() throws Exception {
        return softwareProductMapper.getDepartment();
    }

    @Override
    public List<SoftwareProduct> getAllSoftProd() throws Exception {
        return softwareProductMapper.getAllSoftProd();
    }

    @Override
    public String[] getRole(Map<String, Object> datemap) throws Exception {
        return softwareProductMapper.getRole(datemap);
    }

    @Override
    public List<SoftwareProduct> getSoftProd() {
        return softwareProductMapper.getSoftProd();
    }

    @Override
    public List<BasParameter> getIEName() {
        return basParameterMapper.getIEName();
    }

    @Override
    public List<BasParameter> getUserType() {
        return basParameterMapper.getUserType();
    }

    @Override
    public List<TUsermaster> getLeader() {
        return tUsermasterMapper.getLeader();
    }

    @Override
    public List<TUsermaster> getPmo() {
        return tUsermasterMapper.getPmo();
    }

    @Override
    public List<SoftwareProduct> search(SoftwareProduct softwareProduct) {
        return softwareProductMapper.search(softwareProduct);
    }

    @Override
    public List<String> selectUserFromUserList(List<SoftwareProduct> softwareList) throws Exception {
        return softwareProductMapper.selectUserFromUserList(softwareList);
    }

    @Override
    public boolean insertUserInfo(List<SoftwareProduct> softwareList) throws Exception {
        //获取软件系统
        List<BasParameter> softSys = basParameterMapper.getSoftSys();
        //获取标志
        List<BasParameter> softwareMark = basParameterMapper.getSoftwareMark();
        //获取状态
        List<BasParameter> softStatus = basParameterMapper.getSoftStatus();
        //获取部门
        List<TInstitution> instOfIT = institutionMapper.getInstOfIT();
        //业务属主
        List<TInstitution> instOfBU = institutionMapper.getInstOfBU();
        //获取name
        List<TUsermaster> empOfSoft = tUsermasterMapper.getEmpOfSoft();
        //获取采购方式
        List<BasParameter> procMethod = basParameterMapper.getProcMethod();
        //获取实施方式
        List<BasParameter> devMethod = basParameterMapper.getDevMethod();
        //获取自控等级
        List<BasParameter> acLevel = basParameterMapper.getACLevel();
        for (SoftwareProduct software : softwareList) {
            for (BasParameter basParameter1 : softSys) {
                if ((software.getSoftwareSysCode()).equals(basParameter1.getValue())) {
                    software.setSoftwareSysCode(basParameter1.getKey());
                }
            }
            for (BasParameter basParameter2 : softwareMark) {
                if ((software.getCoreSoftwareMarkName()).equals(basParameter2.getValue())) {
                    software.setCoreSoftwareMark(basParameter2.getKey());
                }
            }
            for (BasParameter basParameter3 : softStatus) {
                if ((software.getStatusName()).equals(basParameter3.getValue())) {
                    software.setStatus(basParameter3.getKey());
                }
            }
            for (TInstitution tInstitution : instOfIT) {
                if ((software.getDeptName()).equals(tInstitution.getInstname())) {
                    software.setDept(tInstitution.getInstno());
                }
            }
            for (TInstitution tInstitution1 : instOfBU) {
                if ((software.getBusinessOwnerName()).equals(tInstitution1.getInstname())) {
                    software.setBusinessOwner(tInstitution1.getInstno());
                }
            }
            for (TUsermaster tUsermaster : empOfSoft) {
                if ((software.getProductLeaderName()).equals(tUsermaster.getName())) {
                    software.setProductLeader(tUsermaster.getEmployeeid());
                }
                if ((software.getBaPrimaryName()).equals(tUsermaster.getName())) {
                    software.setBaPrimary(tUsermaster.getEmployeeid());
                }
                if ((software.getBaSecondaryName()).equals(tUsermaster.getName())) {
                    software.setBaSecondary(tUsermaster.getEmployeeid());
                }
                if ((software.getSaPrimaryName()).equals(tUsermaster.getName())) {
                    software.setSaPrimary(tUsermaster.getEmployeeid());
                }
                if ((software.getSaSecondaryName()).equals(tUsermaster.getName())) {
                    software.setSaSecondary(tUsermaster.getEmployeeid());
                }
                if ((software.getTestLeaderName()).equals(tUsermaster.getName())) {
                    software.setTestLeader(tUsermaster.getEmployeeid());
                }
                if (StringUtils.isNotBlank(software.getServicePrimaryName()) && software.getServicePrimaryName().equals(tUsermaster.getName())) {
                    software.setServicePrimary(tUsermaster.getEmployeeid());
                }
                if (StringUtils.isNotBlank(software.getServiceSecondaryName()) && software.getServiceSecondaryName().equals(tUsermaster.getName())) {
                    software.setServiceSecondary(tUsermaster.getEmployeeid());
                }
            }
            for (BasParameter basParameter4 : procMethod) {
                if (StringUtils.isNotBlank(software.getProcureMethodName()) && software.getProcureMethodName().equals(basParameter4.getValue())) {
                    software.setProcureMethod(basParameter4.getKey());
                }
            }
            for (BasParameter basParameter5 : devMethod) {
                if (StringUtils.isNotBlank(software.getDevMethodName()) && software.getDevMethodName().equals(basParameter5.getValue())) {
                    software.setDevMethod(basParameter5.getKey());
                }
            }
            for (BasParameter basParameter6 : acLevel) {
                if (StringUtils.isNotBlank(software.getAcLevel()) && software.getAcLevel().equals(basParameter6.getValue())) {
                    software.setAcLevel(basParameter6.getKey());
                }
            }
            Boolean flg = softwareProductMapper.insert(software);
            return flg;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> getProductInfo() throws Exception {
        // 拿到产品线
        List<Map<String, Object>> productLineList = basParameterMapper.getProductInfo();
        // 遍历产品线获取其下的产品
        if (!CollectionUtils.isEmpty(productLineList)) {
            // 创建线程池
            FixedExecutors executors = FixedExecutors.getDefaultFixedExecutors();
            productLineList.forEach(a -> {
                String productType = a.get("productType").toString();
                Future<List<Map<String, Object>>> productFuture = executors.submit(() -> softwareProductMapper.findProductByProductLineType(productType));
                try {
                    List<Map<String, Object>> productList = productFuture.get();
                    a.put("children", productList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        return productLineList;
    }

    @Override
    public List<SoftwareProductVo> getProduct() {
        return softwareProductMapper.getProduct();
    }
}
