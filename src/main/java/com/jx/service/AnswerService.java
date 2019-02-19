package com.jx.service;

import com.jx.model.Answer;

import java.util.HashMap;
import java.util.List;

public interface AnswerService {

    void updateAnswer(Answer answer);

    void addAnswer(Answer answer);

    List<Answer> queryAnswer();

    Answer queryAnswerById(Integer id);

    void deleteAnswerAll(String id);
}
