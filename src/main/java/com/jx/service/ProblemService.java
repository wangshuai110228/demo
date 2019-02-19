package com.jx.service;

import com.jx.model.Answer;
import com.jx.model.Problem;

import java.util.HashMap;

public interface ProblemService {
    void updateProblem(Problem problem);

    void addProblem(Problem problem);

    HashMap<String, Object> queryProblem2(int page, int rows, Problem problem);

    Answer queryProblemById(Integer id);

    void deleteAll(String id);
}
