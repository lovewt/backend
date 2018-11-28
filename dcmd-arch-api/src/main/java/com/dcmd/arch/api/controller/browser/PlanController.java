package com.dcmd.arch.api.controller.browser;

import com.dcmd.arch.api.entity.Plan;
import com.dcmd.arch.api.service.impl.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("planController")
public class PlanController {
    @Autowired
    private PlanServiceImpl planService;

    /**
     * 获取所有
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllData")
    public List selectAll() throws Exception {
        List<Plan> list = planService.selectAll();
        return list;
    }
}
