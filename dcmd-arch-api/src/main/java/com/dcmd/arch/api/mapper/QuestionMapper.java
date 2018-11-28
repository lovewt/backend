package com.dcmd.arch.api.mapper;

import com.dcmd.arch.api.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    Question selectByPrimaryKey(Integer id);

    List<Question> selectAll();

    int updateByPrimaryKey(Question record);
}