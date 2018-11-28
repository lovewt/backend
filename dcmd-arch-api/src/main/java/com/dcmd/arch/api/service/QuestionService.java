package com.dcmd.arch.api.service;


import com.dcmd.arch.api.entity.Question;

import java.util.List;

public interface QuestionService {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Question record) throws Exception;

    Question selectByPrimaryKey(Integer id) throws Exception;

    List<Question> selectAll() throws Exception;

    int updateByPrimaryKey(Question record) throws Exception;
}
