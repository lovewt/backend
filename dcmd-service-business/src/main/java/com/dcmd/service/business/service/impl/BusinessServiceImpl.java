package com.dcmd.service.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dcmd.common.core.utils.AjaxResultUtil;
import com.dcmd.common.core.utils.ErrorInfo;
import com.dcmd.service.business.entity.Business;
import com.dcmd.service.business.entity.BusinessLevel;
import com.dcmd.service.business.entity.Dropdown;
import com.dcmd.service.business.entity.SoftwareProduct;
import com.dcmd.service.business.feign.inter.IFeignHystric;
import com.dcmd.service.business.mapper.BasSofProductMapper;
import com.dcmd.service.business.mapper.BusinessLevelMapper;
import com.dcmd.service.business.mapper.BusinessMapper;
import com.dcmd.service.business.service.BusinessService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 1 on 2018/7/3.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private BasSofProductMapper basSofProductMapper;

    @Autowired
    private BusinessLevelMapper levelMapper;

    @Autowired
    private IFeignHystric iFeignHystric;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        return businessMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return businessMapper.insert(map);
    }

    @Override
    public Business selectByPrimaryKey(Long id) throws Exception {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Business> selectAll() throws Exception {
        List<Business> list = businessMapper.selectAll();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new RuntimeException("解析异常");
        }
        Map<String, String> map = JSON.toJavaObject(jsonObject, Map.class);
        return businessMapper.updateByPrimaryKey(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResultUtil deletes(Long[] ids) throws Exception {
        businessMapper.deletes(ids);
        return new AjaxResultUtil();
    }

    @Override
    public List<Business> findAllProduct() throws Exception {
        List<Business> allProduct = basSofProductMapper.findAllProduct();
        return allProduct;
    }

    @Override
    public List<Map<String, String>> getProductName() throws Exception {
        return businessMapper.getProductName();
    }


    @Override
    public List<Map<String, Object>> selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(JSONObject jsonObject) throws Exception {
        Map<String, Object> map = JSONObject.toJavaObject(jsonObject, Map.class);
        List<Map<String, Object>> maps = businessMapper.selectAllByGradeOrFeaturesOrBusinessOrSoftwareNum(map);
        if (maps != null && maps.size() > 0 && !maps.isEmpty()) {
            return maps;
        }
        return null;
    }

    @Override
    public List<LinkedHashMap<String, Object>> getBusinessLevelInfo() throws Exception {
        List<BusinessLevel> allList = levelMapper.getBusinessLevelInfo();
        if (CollectionUtils.isEmpty(allList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        List<BusinessLevel> onelist = allList.parallelStream().filter(one -> one.getPid().equals("0")).collect(Collectors.toList());
        List<BusinessLevel> twoList = allList.parallelStream().filter(one -> !one.getPid().equals("0")).collect(Collectors.toList());
        List<LinkedHashMap<String, Object>> oneLists = new ArrayList<>();
        onelist.forEach(a -> {
            LinkedHashMap<String, Object> map = new LinkedHashMap() {{
                put("value", a.getId());
                put("label", a.getName());

            }};
            List<BusinessLevel> threeList = twoList.parallelStream().filter(b -> b.getPid().equals(a.getId())).collect(Collectors.toList());
            List<BusinessLevel> threeList1 = twoList.parallelStream().filter(b -> !(b.getPid().equals(a.getId()))).collect(Collectors.toList());
            ArrayList<LinkedHashMap<String, Object>> twoLists = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(threeList)) {
                threeList.forEach(c -> {
                    LinkedHashMap<String, Object> cmap = new LinkedHashMap() {{
                        put("value", c.getId());
                        put("label", c.getName());
                    }};
                    List<BusinessLevel> fourList = threeList1.parallelStream().filter(d -> d.getPid().equals(c.getId())).collect(Collectors.toList());
                    List<BusinessLevel> fourList1 = threeList1.parallelStream().filter(d -> !(d.getPid().equals(c.getId()))).collect(Collectors.toList());
                    ArrayList<LinkedHashMap<String, Object>> threeLists = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(fourList)) {
                        fourList.forEach(d -> {
                            LinkedHashMap<String, Object> dmap = new LinkedHashMap() {{
                                put("value", d.getId());
                                put("label", d.getName());
                            }};
                            List<BusinessLevel> fiveList = fourList1.parallelStream().filter(e -> e.getPid().equals(d.getId())).collect(Collectors.toList());
                            List<BusinessLevel> fiveList1 = fourList1.parallelStream().filter(e -> !(e.getPid().equals(d.getId()))).collect(Collectors.toList());
                            ArrayList<LinkedHashMap<String, Object>> fourLists = new ArrayList<>();
                            if (CollectionUtils.isNotEmpty(fiveList)) {
                                fiveList.forEach(e -> {
                                    LinkedHashMap<String, Object> emap = new LinkedHashMap() {{
                                        put("value", e.getId());
                                        put("label", e.getName());
                                    }};
                                    List<BusinessLevel> sixList = fiveList1.parallelStream().filter(f -> f.getPid().equals(e.getId())).collect(Collectors.toList());
                                    List<BusinessLevel> sixList1 = fiveList1.parallelStream().filter(f -> !(f.getPid().equals(e.getId()))).collect(Collectors.toList());
                                    ArrayList<LinkedHashMap<String, Object>> fiveLists = new ArrayList<>();
                                    if (CollectionUtils.isNotEmpty(sixList)) {
                                        sixList.forEach(f -> {
                                            LinkedHashMap<String, Object> fmap = new LinkedHashMap() {{
                                                put("value", f.getId());
                                                put("label", f.getName());
                                            }};
                                            List<BusinessLevel> sevenList = sixList1.parallelStream().filter(g -> g.getPid().equals(f.getId())).collect(Collectors.toList());
                                            ArrayList<LinkedHashMap<String, Object>> sixLists = new ArrayList<>();
                                            if (CollectionUtils.isNotEmpty(sevenList)) {
                                                sevenList.forEach(g -> {
                                                    LinkedHashMap<String, Object> gmap = new LinkedHashMap() {{
                                                        put("value", g.getId());
                                                        put("label", g.getName());
                                                    }};
                                                    sixLists.add(gmap);
                                                });
                                            }
//                                            List<BusinessLevel> sevenList1 = sixList1.parallelStream().filter(g -> !g.getPid().equals(f.getId())).collect(Collectors.toList());
//                                            if (CollectionUtils.isNotEmpty(sevenList)) {
//                                                sevenList.forEach(g -> {
//                                                    LinkedHashMap<String, Object> gmap = new LinkedHashMap() {{
//                                                        put("value", g.getId());
//                                                        put("label", g.getName());
//                                                    }};
//                                                    List<BusinessLevel> eightList = sevenList1.parallelStream().filter(h -> h.getPid().equals(g.getId())).collect(Collectors.toList());
//                                                    ArrayList<LinkedHashMap<String, Object>> sevenlists = new ArrayList<>();
//                                                    if (CollectionUtils.isNotEmpty(eightList)) {
//                                                        eightList.forEach(h -> {
//                                                            LinkedHashMap<String, Object> hmap = new LinkedHashMap() {{
//                                                                put("value", h.getId());
//                                                                put("label", h.getName());
//                                                            }};
//                                                            sevenlists.add(hmap);
//                                                        });
//                                                    }
//                                                    gmap.put("children", sevenlists);
//                                                    sixLists.add(gmap);
//                                                });
//                                            }
                                            fmap.put("children", sixLists);
                                            fiveLists.add(fmap);
                                        });
                                    }
                                    emap.put("children", fiveLists);
                                    fourLists.add(emap);
                                });
                            }
                            dmap.put("children", fourLists);
                            threeLists.add(dmap);
                        });
                    }
                    cmap.put("children", threeLists);
                    twoLists.add(cmap);
                });
            }
            map.put("children", twoLists);
            oneLists.add(map);
        });
        return oneLists;
    }

    @Override
    public List<Business> queryAllDatas() throws Exception {
        List<Business> levelList = businessMapper.getLevelInfo();
        List<Business> functionPointList = businessMapper.getFunctionPoint();
        List<SoftwareProduct> softwareProductList = iFeignHystric.getAllSoftProd();
        List<Business> allDatas = new ArrayList<Business>();
        // 创建一个空的数组链表对象list，list用来存放业务类型、一级、二级、三级、四级、五级
        ArrayList<LinkedHashMap<String, String>> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(levelList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        functionPointList.forEach(functionPoint -> {
            List<Business> oneLevelData = levelList.parallelStream().filter(level -> level.getId().equals(functionPoint.getBusinessId())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(oneLevelData)) {
                String onePid = oneLevelData.get(0).getPid();
                list.add(getMap(oneLevelData));
                if (StringUtils.isNotBlank(onePid)) {
                    List<Business> twoLevelData = levelList.parallelStream().filter(level -> level.getId().equals(onePid)).collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(twoLevelData)) {
                        list.add(getMap(twoLevelData));
                        String twoPid = twoLevelData.get(0).getPid();
                        if (StringUtils.isNotBlank(twoPid)) {
                            List<Business> threeLevelData = levelList.parallelStream().filter(level -> level.getId().equals(twoPid)).collect(Collectors.toList());
                            if (CollectionUtils.isNotEmpty(threeLevelData)) {
                                list.add(getMap(threeLevelData));
                                String threePid = threeLevelData.get(0).getPid();
                                if (StringUtils.isNotBlank(threePid)) {
                                    List<Business> fourLevelData = levelList.parallelStream().filter(level -> level.getId().equals(threePid)).collect(Collectors.toList());
                                    if (CollectionUtils.isNotEmpty(fourLevelData)) {
                                        list.add(getMap(fourLevelData));
                                        String fourPid = fourLevelData.get(0).getPid();
                                        if (StringUtils.isNotBlank(fourPid)) {
                                            List<Business> fiveLevelData = levelList.parallelStream().filter(level -> level.getId().equals(fourPid)).collect(Collectors.toList());
                                            if (CollectionUtils.isNotEmpty(fiveLevelData)) {
                                                list.add(getMap(fiveLevelData));
                                                String fivePid = fiveLevelData.get(0).getPid();
                                                if (StringUtils.isNotBlank(fivePid)) {
                                                    List<Business> sixLevelData = levelList.parallelStream().filter(level -> level.getId().equals(fivePid)).collect(Collectors.toList());
                                                    if (CollectionUtils.isNotEmpty(sixLevelData)) {
                                                        list.add(getMap(sixLevelData));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(softwareProductList)) {
                List<SoftwareProduct> softwareProductData = softwareProductList.parallelStream().filter(soft -> StringUtils.isNotBlank(functionPoint.getSoftwareNum()) && soft.getSoftwareNum().equals(functionPoint.getSoftwareNum())).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(softwareProductData)) {
                    functionPoint.setSoftwareName(softwareProductData.get(0).getSoftwareName());
                }
            }

            switch (list.size()) {
                case (1):
                    functionPoint.setBusinessClassId(list.get(0).get("id"));
                    functionPoint.setBusinessClass(list.get(0).get("name"));
                    break;
                case (2):
                    functionPoint.setBusinessClassId(list.get(1).get("id"));
                    functionPoint.setBusinessClass(list.get(1).get("name"));
                    functionPoint.setOneLevelId(list.get(0).get("id"));
                    functionPoint.setOneLevel(list.get(0).get("name"));
                    break;
                case (3):
                    functionPoint.setBusinessClassId(list.get(2).get("id"));
                    functionPoint.setBusinessClass(list.get(2).get("name"));
                    functionPoint.setOneLevelId(list.get(1).get("id"));
                    functionPoint.setOneLevel(list.get(1).get("name"));
                    functionPoint.setTwoLevelId(list.get(0).get("id"));
                    functionPoint.setTwoLevel(list.get(0).get("name"));
                    break;
                case (4):
                    functionPoint.setBusinessClassId(list.get(3).get("id"));
                    functionPoint.setBusinessClass(list.get(3).get("name"));
                    functionPoint.setOneLevelId(list.get(2).get("id"));
                    functionPoint.setOneLevel(list.get(2).get("name"));
                    functionPoint.setTwoLevelId(list.get(1).get("id"));
                    functionPoint.setTwoLevel(list.get(1).get("name"));
                    functionPoint.setThreeLevelId(list.get(0).get("id"));
                    functionPoint.setThreeLevel(list.get(0).get("name"));
                    break;
                case (5):
                    functionPoint.setBusinessClassId(list.get(4).get("id"));
                    functionPoint.setBusinessClass(list.get(4).get("name"));
                    functionPoint.setOneLevelId(list.get(3).get("id"));
                    functionPoint.setOneLevel(list.get(3).get("name"));
                    functionPoint.setTwoLevelId(list.get(2).get("id"));
                    functionPoint.setTwoLevel(list.get(2).get("name"));
                    functionPoint.setThreeLevelId(list.get(1).get("id"));
                    functionPoint.setThreeLevel(list.get(1).get("name"));
                    functionPoint.setFourLevelId(list.get(0).get("id"));
                    functionPoint.setFourLevel(list.get(0).get("name"));
                    break;
                case (6):
                    functionPoint.setBusinessClassId(list.get(5).get("id"));
                    functionPoint.setBusinessClass(list.get(5).get("name"));
                    functionPoint.setOneLevelId(list.get(4).get("id"));
                    functionPoint.setOneLevel(list.get(4).get("name"));
                    functionPoint.setTwoLevelId(list.get(3).get("id"));
                    functionPoint.setTwoLevel(list.get(3).get("name"));
                    functionPoint.setThreeLevelId(list.get(2).get("id"));
                    functionPoint.setThreeLevel(list.get(2).get("name"));
                    functionPoint.setFourLevelId(list.get(1).get("id"));
                    functionPoint.setFourLevel(list.get(1).get("name"));
                    functionPoint.setFiveLevelId(list.get(0).get("id"));
                    functionPoint.setFiveLevel(list.get(0).get("name"));
                    break;
                default:
                    break;
            }
            allDatas.add(functionPoint);
            list.clear();
        });
        return allDatas;
    }


    private LinkedHashMap<String, String> getMap(List<Business> list) {
        LinkedHashMap<String, String> map = new LinkedHashMap() {{
            put("id", list.get(0).getId());
            put("name", list.get(0).getName());
        }};
        return map;
    }

    @Override
    public List<Dropdown> getBusinessLevelType() throws Exception {
        return levelMapper.getBusinessLevelType();
    }

    @Override
    public List<Dropdown> getBusinessLevelList(String id) throws Exception {
        return levelMapper.getBusinessLevelList(id);
    }

    @Override
    public List<Dropdown> getFeaturesBusinessList() throws Exception {
        return levelMapper.getFeaturesBusinessList();
    }


    @Override
    public Map getBusinessTypeLevelTwo() throws Exception {
        HashMap map1 = new HashMap();
        List<BusinessLevel> allList = levelMapper.getBusinessLevelInfo();
        if (CollectionUtils.isEmpty(allList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        List<BusinessLevel> onelist = allList.parallelStream().filter(one -> one.getPid().equals("0")).collect(Collectors.toList());
        List<BusinessLevel> twoList = allList.parallelStream().filter(one -> !one.getPid().equals("0")).collect(Collectors.toList());
        List<LinkedHashMap<String, Object>> oneLists = new ArrayList<>();
        onelist.forEach(a -> {
            LinkedHashMap<String, Object> map = new LinkedHashMap() {{
                put("id", getId());
                put("name", a.getName());
                put("type", "0");
            }};
            List<BusinessLevel> threeList = twoList.parallelStream().filter(b -> b.getPid().equals(a.getId())).collect(Collectors.toList());
            List<BusinessLevel> threeList1 = twoList.parallelStream().filter(b -> !(b.getPid().equals(a.getId()))).collect(Collectors.toList());
            ArrayList<LinkedHashMap<String, Object>> twoLists = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(threeList)) {
                threeList.forEach(c -> {
                    LinkedHashMap<String, Object> cmap = new LinkedHashMap() {{
                        put("value", (int) ((Math.random() * 9 + 2) * 10000));
                        put("id", getId());
                        put("name", c.getName());
                        put("type", "1");
                    }};
                    List<BusinessLevel> fourList = threeList1.parallelStream().filter(d -> d.getPid().equals(c.getId())).collect(Collectors.toList());
                    ArrayList<LinkedHashMap<String, Object>> threeLists = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(fourList)) {
                        fourList.forEach(d -> {
                            LinkedHashMap<String, Object> dmap = new LinkedHashMap() {{
                                put("value", (int) ((Math.random() * 9 + 3) * 100000));
                                put("id", getId());
                                put("name", d.getName());
                                put("size", 200);
                                put("type", "2");
                            }};
                            threeLists.add(dmap);
                        });
                    }
                    if (threeLists.isEmpty()){
                        cmap.put("value", (int) ((Math.random() * 9 + 4) * 1000000));
                        cmap.put("size", (int) ((Math.random() * 3+ 2) * 100));
                        cmap.put("type", "2");
                        twoLists.add(cmap);
                    }else {
                        cmap.put("children", threeLists);
                        twoLists.add(cmap);
                    }
                });
            }
            map.put("children", twoLists);
            oneLists.add(map);
        });
        map1.put("name", "层级");
        map1.put("children", oneLists);
        return map1;
    }

    @Override
    public Map getBusinessTypeLevelFive() throws Exception {
        HashMap map1 = new HashMap();
        List<BusinessLevel> allList = levelMapper.getBusinessLevelInfo();
        if (CollectionUtils.isEmpty(allList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        List<BusinessLevel> onelist = allList.parallelStream().filter(one -> one.getPid().equals("0")).collect(Collectors.toList());
        List<BusinessLevel> twoList = allList.parallelStream().filter(one -> !one.getPid().equals("0")).collect(Collectors.toList());
        List<LinkedHashMap<String, Object>> fourLists = new ArrayList<>();
        onelist.forEach(a -> {
            List<BusinessLevel> threeList = twoList.parallelStream().filter(b -> b.getPid().equals(a.getId())).collect(Collectors.toList());
            List<BusinessLevel> threeList1 = twoList.parallelStream().filter(b -> !(b.getPid().equals(a.getId()))).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(threeList)) {
                threeList.forEach(c -> {
                    List<BusinessLevel> fourList = threeList1.parallelStream().filter(d -> d.getPid().equals(c.getId())).collect(Collectors.toList());
                    List<BusinessLevel> fourList1 = threeList1.parallelStream().filter(d -> !(d.getPid().equals(c.getId()))).collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(fourList)) {
                        fourList.forEach(d -> {
                            List<BusinessLevel> fiveList = fourList1.parallelStream().filter(e -> e.getPid().equals(d.getId())).collect(Collectors.toList());
                            List<BusinessLevel> fiveList1 = fourList1.parallelStream().filter(e -> !(e.getPid().equals(d.getId()))).collect(Collectors.toList());
                            if (CollectionUtils.isNotEmpty(fiveList)) {
                                fiveList.forEach(e -> {
                                    LinkedHashMap<String, Object> emap = new LinkedHashMap() {{
                                        put("value", (int) ((Math.random() * 9 + 1) * 1000));
                                        put("id", getId());
                                        put("name", e.getName());
                                        put("type", "3");
                                    }};
                                    List<BusinessLevel> sixList = fiveList1.parallelStream().filter(f -> f.getPid().equals(e.getId())).collect(Collectors.toList());
                                    List<BusinessLevel> sixList1 = fiveList1.parallelStream().filter(f -> !(f.getPid().equals(e.getId()))).collect(Collectors.toList());
                                    ArrayList<LinkedHashMap<String, Object>> fiveLists = new ArrayList<>();
                                    if (CollectionUtils.isNotEmpty(sixList)) {
                                        sixList.forEach(f -> {
                                            LinkedHashMap<String, Object> fmap = new LinkedHashMap() {{
                                                put("value", (int) ((Math.random() * 9 + 2) * 10000));
                                                put("id", getId());
                                                put("name", f.getName());
                                                put("type", "4");
                                            }};
                                            List<BusinessLevel> sevenList = sixList1.parallelStream().filter(g -> g.getPid().equals(f.getId())).collect(Collectors.toList());
                                            ArrayList<LinkedHashMap<String, Object>> sixLists = new ArrayList<>();
                                            if (CollectionUtils.isNotEmpty(sevenList)) {
                                                sevenList.forEach(g -> {
                                                    LinkedHashMap<String, Object> gmap = new LinkedHashMap() {{
                                                        put("value", (int) ((Math.random() * 9 + 3) * 100000));
                                                        put("id", getId());
                                                        put("name", g.getName());
                                                        put("size", (int) ((Math.random() * 3 + 2) * 100));
                                                        put("type", "5");
                                                    }};
                                                    sixLists.add(gmap);
                                                });
                                            }
                                            if (sixLists.isEmpty()) {
                                                fmap.put("value", (int) ((Math.random() * 9 + 4) * 1000000));
                                                fmap.put("size", (int) ((Math.random() * 3 + 2) * 100));
                                                fmap.put("type", "4");
                                                fiveLists.add(fmap);
                                            } else {
                                                fmap.put("children", sixLists);
                                                fiveLists.add(fmap);
                                            }
                                        });
                                    }
                                    if (fiveLists.isEmpty()) {
                                        emap.put("value", (int) ((Math.random() * 9 + 5) * 10000000));
                                        emap.put("size", (int) ((Math.random() * 3 + 2) * 100));
                                        emap.put("type", "3");
                                        fourLists.add(emap);
                                    } else {
                                        emap.put("children", fiveLists);
                                        fourLists.add(emap);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        map1.put("name", "层级");
        map1.put("children", fourLists);
        return map1;
    }

    @Override
    public Map getBusinessTypeLevelAndAllData() throws Exception {
        HashMap map1 = new HashMap();
        List<Business> functionPoint = businessMapper.getFunctionPoint();
        List<BusinessLevel> allList = levelMapper.getBusinessLevelInfo();
        if (CollectionUtils.isEmpty(allList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        List<BusinessLevel> onelist = allList.parallelStream().filter(one -> one.getPid().equals("0")).collect(Collectors.toList());
        List<BusinessLevel> twoList = allList.parallelStream().filter(one -> !one.getPid().equals("0")).collect(Collectors.toList());
        List<LinkedHashMap<String, Object>> oneLists = new ArrayList<>();
        onelist.forEach(a -> {
            LinkedHashMap<String, Object> map = new LinkedHashMap() {{
                put("id", getId());
                put("name", a.getName());
                put("type","0");
            }};
            List<BusinessLevel> threeList = twoList.parallelStream().filter(b -> b.getPid().equals(a.getId())).collect(Collectors.toList());
            List<BusinessLevel> threeList1 = twoList.parallelStream().filter(b -> !(b.getPid().equals(a.getId()))).collect(Collectors.toList());
            ArrayList<LinkedHashMap<String, Object>> twoLists = new ArrayList<>();
            //yi級
            if (CollectionUtils.isNotEmpty(threeList)) {
                threeList.forEach(c -> {
                    LinkedHashMap<String, Object> cmap = new LinkedHashMap() {{
                        put("value", (int) ((Math.random() * 9 + 1) * 1000));
                        put("id", getId());
                        put("name", c.getName());
                        put("type","1");
                    }};
                    List<BusinessLevel> fourList = threeList1.parallelStream().filter(d -> d.getPid().equals(c.getId())).collect(Collectors.toList());
                    List<BusinessLevel> fourList1 = threeList1.parallelStream().filter(d -> !(d.getPid().equals(c.getId()))).collect(Collectors.toList());
                    ArrayList<LinkedHashMap<String, Object>> threeLists = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(fourList)) {
                        fourList.forEach(d -> {
                            LinkedHashMap<String, Object> dmap = new LinkedHashMap() {{
                                put("value", (int) ((Math.random() * 9 + 2) * 10000));
                                put("id", getId());
                                put("name", d.getName());
                                put("type","2");
                            }};
                            List<BusinessLevel> fiveList = fourList1.parallelStream().filter(e -> e.getPid().equals(d.getId())).collect(Collectors.toList());
                            List<BusinessLevel> fiveList1 = fourList1.parallelStream().filter(e -> !(e.getPid().equals(d.getId()))).collect(Collectors.toList());
                            ArrayList<LinkedHashMap<String, Object>> fourLists = new ArrayList<>();
                            if (CollectionUtils.isNotEmpty(fiveList)) {
                                fiveList.forEach(e -> {
                                    LinkedHashMap<String, Object> emap = new LinkedHashMap() {{
                                        put("value", (int) ((Math.random() * 9 + 3) * 100000));
                                        put("id", getId());
                                        put("name", e.getName());
                                        put("type","3");
                                    }};
                                    List<BusinessLevel> sixList = fiveList1.parallelStream().filter(f -> f.getPid().equals(e.getId())).collect(Collectors.toList());
                                    List<BusinessLevel> sixList1 = fiveList1.parallelStream().filter(f -> !(f.getPid().equals(e.getId()))).collect(Collectors.toList());
                                    ArrayList<LinkedHashMap<String, Object>> fiveLists = new ArrayList<>();
                                    if (CollectionUtils.isNotEmpty(sixList)) {
                                        sixList.forEach(f -> {
                                            LinkedHashMap<String, Object> fmap = new LinkedHashMap() {{
                                                put("value", (int) ((Math.random() * 9 + 4) * 1000000));
                                                put("id", getId());
                                                put("name", f.getName());
                                                put("type","4");
                                            }};
                                            List<BusinessLevel> sevenList = sixList1.parallelStream().filter(g -> g.getPid().equals(f.getId())).collect(Collectors.toList());
                                            ArrayList<LinkedHashMap<String, Object>> sixLists = new ArrayList<>();
                                            if (CollectionUtils.isNotEmpty(sevenList)) {
                                                sevenList.forEach(g -> {
                                                    LinkedHashMap<String, Object> gmap = new LinkedHashMap() {{
                                                        put("value", (int) ((Math.random() * 9 + 5) * 10000000));
                                                        put("id", getId());
                                                        put("name", g.getName());
                                                        put("type","5");
                                                    }};
                                                    List<Business> collect = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(g.getId())).collect(Collectors.toList());
                                                    ArrayList<LinkedHashMap<String, Object>> sevenLists = new ArrayList<>();
                                                    if (CollectionUtils.isNotEmpty(collect)) {
                                                        collect.forEach(o -> {
                                                            LinkedHashMap<String, Object> omap = new LinkedHashMap() {{
                                                                put("value", (int) ((Math.random() * 9 + 6) * 1000000000));
                                                                put("type","feature");
                                                                put("id", getId());
                                                                put("name", o.getFeatures());
                                                                put("size", (int) ((Math.random() * 3 + 2) * 100));
                                                            }};
                                                            sevenLists.add(omap);
                                                        });
                                                    }
                                                    gmap.put("children", sevenLists);
                                                    sixLists.add(gmap);
                                                });
                                            }
                                            if (sixLists.isEmpty()) {
                                                List<Business> collect2 = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(f.getId())).collect(Collectors.toList());
                                                ArrayList<LinkedHashMap<String, Object>> mLists = new ArrayList<>();
                                                if (CollectionUtils.isNotEmpty(collect2)) {
                                                    collect2.forEach(m -> {
                                                        LinkedHashMap<String, Object> mmap = new LinkedHashMap() {{
                                                            put("value", (int) ((Math.random() * 9 + 7) * 1000000000)+UUID.randomUUID().toString());
                                                            put("type","feature");
                                                            put("id", getId());
                                                            put("name", m.getFeatures());
                                                            put("size", (int) ((Math.random() * 3 + 2) * 100));
                                                        }};
                                                        mLists.add(mmap);
                                                    });
                                                }
                                                fmap.put("children", mLists);
                                                fiveLists.add(fmap);
                                            } else {
                                                fmap.put("children", sixLists);
                                                fiveLists.add(fmap);
                                            }
                                        });
                                    }
                                    //三级
                                    if (fiveLists.isEmpty()) {
                                        List<Business> collect1 = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(e.getId())).collect(Collectors.toList());
                                        ArrayList<LinkedHashMap<String, Object>> nLists = new ArrayList<>();
                                        if (CollectionUtils.isNotEmpty(collect1)) {
                                            collect1.forEach(n -> {
                                                LinkedHashMap<String, Object> nmap = new LinkedHashMap() {{
                                                    put("value", (int) ((Math.random() * 9 + 8) * 100000000)+UUID.randomUUID().toString());
                                                    put("type","feature");
                                                    put("id", getId());
                                                    put("name", n.getFeatures());
                                                    put("size", (int) ((Math.random() * 3 + 2) * 100));
                                                }};
                                                nLists.add(nmap);
                                            });
                                        }
                                        emap.put("children", nLists);
                                        fourLists.add(emap);
                                    } else {
                                        emap.put("children", fiveLists);
                                        fourLists.add(emap);
                                    }
                                });
                            }
                            if (fourLists.isEmpty()) {
                                List<Business> collect3 = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(d.getId())).collect(Collectors.toList());
                                ArrayList<LinkedHashMap<String, Object>> mLists3 = new ArrayList<>();
                                if (CollectionUtils.isNotEmpty(collect3)) {
                                    collect3.forEach(m3 -> {
                                        LinkedHashMap<String, Object> mmap = new LinkedHashMap() {{
                                            put("value", (int) ((Math.random() * 9 + 9) * 10000000)+UUID.randomUUID().toString());
                                            put("type","feature");
                                            put("id", getId());
                                            put("name", m3.getFeatures());
                                            put("size", (int) ((Math.random() * 3 + 2) * 100));
                                        }};

                                        mLists3.add(mmap);
                                    });
                                }
                                dmap.put("children", mLists3);
                                threeLists.add(dmap);
                            } else {
                                dmap.put("children", fourLists);
                                threeLists.add(dmap);
                            }
                        });
                    }
                    if (threeLists.isEmpty()) {
                        List<Business> collect4 = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(c.getId())).collect(Collectors.toList());
                        ArrayList<LinkedHashMap<String, Object>> mLists4 = new ArrayList<>();
                        if (CollectionUtils.isNotEmpty(collect4)) {
                            collect4.forEach(m4 -> {
                                LinkedHashMap<String, Object> mmap = new LinkedHashMap() {{
                                    put("value", (int) ((Math.random() * 9 + 1) * 10000000)+UUID.randomUUID().toString());
                                    put("type","feature");
                                    put("id", getId());
                                    put("name", m4.getFeatures());
                                    put("size", (int) ((Math.random() * 3 + 2) * 100));
                                }};
                                mLists4.add(mmap);
                            });
                        }
                        cmap.put("children", mLists4);
                        twoLists.add(cmap);
                    } else {
                        cmap.put("children", threeLists);
                        twoLists.add(cmap);
                    }
                });
            }
            map.put("children", twoLists);
            oneLists.add(map);
        });
        map1.put("name", "层级");
        map1.put("children", oneLists);
        return map1;
    }

    @Override
    public Map getBusinessTypeLevelAndAllLevel() throws Exception {
        HashMap map1 = new HashMap();
        List<Business> functionPoint = businessMapper.getFunctionPoint();
        List<BusinessLevel> allList = levelMapper.getBusinessLevelInfo();
        if (CollectionUtils.isEmpty(allList)) {
            throw new ErrorInfo("the data is null", 500);
        }
        List<BusinessLevel> onelist = allList.parallelStream().filter(one -> one.getPid().equals("0")).collect(Collectors.toList());
        List<BusinessLevel> twoList = allList.parallelStream().filter(one -> !one.getPid().equals("0")).collect(Collectors.toList());
        List<LinkedHashMap<String, Object>> oneLists = new ArrayList<>();
        onelist.forEach(a -> {
            LinkedHashMap<String, Object> map = new LinkedHashMap() {{
                put("id", getId());
                put("name", a.getName());
                put("type","0");
            }};
            List<BusinessLevel> threeList = twoList.parallelStream().filter(b -> b.getPid().equals(a.getId())).collect(Collectors.toList());
            List<BusinessLevel> threeList1 = twoList.parallelStream().filter(b -> !(b.getPid().equals(a.getId()))).collect(Collectors.toList());
            ArrayList<LinkedHashMap<String, Object>> twoLists = new ArrayList<>();
            //yi級
            if (CollectionUtils.isNotEmpty(threeList)) {
                threeList.forEach(c -> {
                    LinkedHashMap<String, Object> cmap = new LinkedHashMap() {{
                        put("value", (int) ((Math.random() * 9 + 1) * 1000));
                        put("pid",a.getId());
                        put("id", getId());
                        put("name", c.getName());
                        put("type","1");
                    }};
                    List<BusinessLevel> fourList = threeList1.parallelStream().filter(d -> d.getPid().equals(c.getId())).collect(Collectors.toList());
                    List<BusinessLevel> fourList1 = threeList1.parallelStream().filter(d -> !(d.getPid().equals(c.getId()))).collect(Collectors.toList());
                    ArrayList<LinkedHashMap<String, Object>> threeLists = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(fourList)) {
                        fourList.forEach(d -> {
                            LinkedHashMap<String, Object> dmap = new LinkedHashMap() {{
                                put("value", (int) ((Math.random() * 9 + 2) * 10000));
                                put("pid",a.getId());
                                put("id", getId());
                                put("name", d.getName());
                                put("type","2");
                            }};
                            List<BusinessLevel> fiveList = fourList1.parallelStream().filter(e -> e.getPid().equals(d.getId())).collect(Collectors.toList());
                            List<BusinessLevel> fiveList1 = fourList1.parallelStream().filter(e -> !(e.getPid().equals(d.getId()))).collect(Collectors.toList());
                            ArrayList<LinkedHashMap<String, Object>> fourLists = new ArrayList<>();
                            if (CollectionUtils.isNotEmpty(fiveList)) {
                                fiveList.forEach(e -> {
                                    LinkedHashMap<String, Object> emap = new LinkedHashMap() {{
                                        put("value", (int) ((Math.random() * 9 + 3) * 100000));
                                        put("pid",a.getId());
                                        put("id", getId());
                                        put("name", e.getName());
                                        put("type","3");
                                    }};
                                    List<BusinessLevel> sixList = fiveList1.parallelStream().filter(f -> f.getPid().equals(e.getId())).collect(Collectors.toList());
                                    List<BusinessLevel> sixList1 = fiveList1.parallelStream().filter(f -> !(f.getPid().equals(e.getId()))).collect(Collectors.toList());
                                    ArrayList<LinkedHashMap<String, Object>> fiveLists = new ArrayList<>();
                                    if (CollectionUtils.isNotEmpty(sixList)) {
                                        sixList.forEach(f -> {
                                            LinkedHashMap<String, Object> fmap = new LinkedHashMap() {{
                                                put("value", (int) ((Math.random() * 9 + 4) * 1000000));
                                                put("pid",a.getId());
                                                put("id", getId());
                                                put("name", f.getName());
                                                put("type","4");
                                            }};
                                            List<BusinessLevel> sevenList = sixList1.parallelStream().filter(g -> g.getPid().equals(f.getId())).collect(Collectors.toList());
                                            ArrayList<LinkedHashMap<String, Object>> sixLists = new ArrayList<>();
                                            if (CollectionUtils.isNotEmpty(sevenList)) {
                                                sevenList.forEach(g -> {
                                                    LinkedHashMap<String, Object> gmap = new LinkedHashMap() {{
                                                        put("value", (int) ((Math.random() * 9 + 5) * 10000000));
                                                        put("pid",a.getId());
                                                        put("id", getId());
                                                        put("name", g.getName());
                                                        put("size",(int)((Math.random()*3+2)*100));
                                                        put("type","5");
                                                    }};
                                                    sixLists.add(gmap);
                                                });
                                            }
                                            if (sixLists.isEmpty()) {
                                                fmap.put("value",(int) ((Math.random() * 9 + 6) * 1000000000));
                                                fmap.put("pid",a.getId());
                                                fmap.put("size",(int)((Math.random()*3+2)*100));
                                                fmap.put("type","4");
                                                fiveLists.add(fmap);
                                            } else {
                                                fmap.put("children", sixLists);
                                                fiveLists.add(fmap);
                                            }
                                        });
                                    }
                                    //三级
                                    if (fiveLists.isEmpty()) {
                                        emap.put("value", (int) ((Math.random() * 9 + 7) * 1000000000)+UUID.randomUUID().toString());
                                        emap.put("pid",a.getId());
                                        emap.put("size",(int)((Math.random()*3+2)*100));
                                        emap.put("type","3");
                                        fourLists.add(emap);
                                    } else {
                                        emap.put("children", fiveLists);
                                        fourLists.add(emap);
                                    }
                                });
                            }
                            if (fourLists.isEmpty()) {
                                List<Business> collect3 = functionPoint.parallelStream().filter(po -> po.getBusinessId().equals(d.getId())).collect(Collectors.toList());
                                ArrayList<LinkedHashMap<String, Object>> mLists3 = new ArrayList<>();
                                if (CollectionUtils.isNotEmpty(collect3)) {
                                    collect3.forEach(m3 -> {
                                        LinkedHashMap<String, Object> mmap = new LinkedHashMap() {{
                                            put("value", (int) ((Math.random() * 9 + 8) * 100000000)+UUID.randomUUID().toString());
                                            put("pid",a.getId());
                                            put("type","feature");
                                            put("id", getId());
                                            put("name", m3.getFeatures());
                                            put("size", (int) ((Math.random() * 3 + 2) * 100));
                                        }};
                                        mLists3.add(mmap);
                                    });
                                }
                                dmap.put("children", mLists3);
                                threeLists.add(dmap);
                            } else {
                                dmap.put("children", fourLists);
                                threeLists.add(dmap);
                            }
                        });
                    }
                    if (threeLists.isEmpty()) {
                        cmap.put("value", (int) ((Math.random() * 9 + 9) * 10000000)+UUID.randomUUID().toString());
                        cmap.put("pid",a.getId());
                        cmap.put("size", (int) ((Math.random() * 3 + 2) * 100));
                        cmap.put("type","1");
                        twoLists.add(cmap);
                    } else {
                        cmap.put("children", threeLists);
                        twoLists.add(cmap);
                    }
                });
            }
            map.put("children", twoLists);
            oneLists.add(map);
        });
        map1.put("name", "层级");
        map1.put("children", oneLists);
        return map1;
    }

    /**
     * 生成自增的id
     */
    public static int random=1;
    public static int getId(){
        return random+=1;
    }
}
