package com.jx.service;

import com.jx.mapper.CommentMapper;
import com.jx.model.Evaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements  CommentService {
     @Autowired
     private CommentMapper commentMapper;

     @Override
     public List<Evaluate> queryPinLun() {



          return commentMapper.queryPage();
     }
     //回显
     @Override
     public Evaluate queryEvaluateById(Integer id) {
          return commentMapper.queryEvaluateById(id);
     }
      //删除
     @Override
     public void deleteAll(String id) {
          String[] sid = id.split(",");
          for (int i=0;i<sid.length;i++){
               commentMapper.deleteAll(sid[i]);
          }     }

     //修改评价
     @Override
     public void updateEvaluate(Evaluate evaluate) {
          commentMapper.updateEvaluate(evaluate);
     }
     //新增评价
     @Override
     public void addEvaluate(Evaluate evaluate) {
          commentMapper.addEvaluate(evaluate);
     }



}
