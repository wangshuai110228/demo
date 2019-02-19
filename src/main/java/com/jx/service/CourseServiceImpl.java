package com.jx.service;

import com.jx.mapper.CourseMapper;
import com.jx.model.Kecheng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =courseMapper.queryTotak(kecheng);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Kecheng> list  = courseMapper.queryPageKecheng(start,rows, kecheng);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }
    //回显
    @Override
    public Kecheng queryKechengById(Integer id) {
        return courseMapper.queryKechengById(id);
    }
    //新增
    @Override
    public void addKecheng(Kecheng kecheng) {
        courseMapper.addKecheng(kecheng);
    }
    //修改
    @Override
    public void updateKecheng(Kecheng kecheng) {
        courseMapper.updateKecheng(kecheng);
    }
    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            courseMapper.deleteAll(sid[i]);
        }
    }
}
