package com.jx.service;

import com.jx.model.Kecheng;

import java.util.HashMap;

public interface CourseService {
    HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng);

    void updateKecheng(Kecheng kecheng);

    void addKecheng(Kecheng kecheng);

    void deleteAll(String id);

    Kecheng queryKechengById(Integer id);
}
