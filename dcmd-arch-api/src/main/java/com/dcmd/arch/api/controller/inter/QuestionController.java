package com.dcmd.arch.api.controller.inter;

import com.dcmd.arch.api.entity.Question;
import com.dcmd.arch.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questionController")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 获取所有
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllData")
    public List selectAll() throws Exception {
        List<Question> list = questionService.selectAll();
        return list;
    }
}
