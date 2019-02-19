package com.jx.service;

import com.jx.mapper.AnswerMapper;
import com.jx.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<Answer> queryAnswer() {
        return answerMapper.queryPageProblem();
    }
    //回显
    @Override
    public Answer queryAnswerById(Integer id) {
        return answerMapper.queryAnswerById(id);
    }


    //修改
    @Override
    public void updateAnswer(Answer answer) {
         answerMapper.updateAnswer(answer);
    }
    //新增
    @Override
    public void addAnswer(Answer answer) {
        answerMapper.addAnswer(answer);
    }
    //刪除
    @Override
    public void deleteAnswerAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            answerMapper.deleteAnswerAll(sid[i]);
        }
    }
}
