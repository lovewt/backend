package com.dcmd.arch.api.service.impl;

import com.dcmd.arch.api.entity.Question;
import com.dcmd.arch.api.mapper.QuestionMapper;
import com.dcmd.arch.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Question record) throws Exception {
        return questionMapper.insert(record);
    }

    @Override
    public Question selectByPrimaryKey(Integer id) throws Exception {
        return questionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Question> selectAll() throws Exception {
        return questionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Question record) throws Exception {
        return questionMapper.updateByPrimaryKey(record);
    }
}
