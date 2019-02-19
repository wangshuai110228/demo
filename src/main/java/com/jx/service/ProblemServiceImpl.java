package com.jx.service;

import com.jx.mapper.ProblemMapper;
import com.jx.model.Answer;
import com.jx.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProblemServiceImpl implements  ProblemService {
        @Autowired
        private ProblemMapper problemMapper;
    //回显
    @Override
    public Answer queryProblemById(Integer id) {
        return problemMapper.queryProblemById(id);
    }



    //修改
    @Override
    public void updateProblem(Problem problem) {
           problemMapper.updateProblem(problem);
    }
    //新增
    @Override
    public void addProblem(Problem problem) {
        problemMapper.addProblem(problem);
    }

    @Override
    public HashMap<String, Object> queryProblem2(int page, int rows, Problem problem) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =problemMapper.queryTotal(problem);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Problem> list  = problemMapper.queryPageProblem(start,rows, problem);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }
    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            problemMapper.deleteAll(sid[i]);
        }
    }

}
