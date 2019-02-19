package com.jx.service;

import com.jx.model.Evaluate;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    void updateEvaluate(Evaluate evaluate);

    void addEvaluate(Evaluate evaluate);

    List<Evaluate> queryPinLun();

    Evaluate queryEvaluateById(Integer id);

    void deleteAll(String id);
}
