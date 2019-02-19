package com.jx.action;

import com.jx.model.Evaluate;
import com.jx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("comment")
public class CommentAction {
     @Autowired
     private CommentService commentService;
     //查询
     @RequestMapping("queryPinLun")
     @ResponseBody
     public List<Evaluate> queryPinLun(){
          return  commentService.queryPinLun();
     }
     //修改回显
     @RequestMapping("queryEvaluateById")
     @ResponseBody
     public Evaluate queryEvaluateById(Integer id) {
          return commentService.queryEvaluateById(id);
     }
     //新增修改
     @RequestMapping("addEvaluate")
     @ResponseBody
     public void  addEvaluate(Evaluate evaluate){
          Integer id = evaluate.getId();
          if (id!=null){
               //修改
               commentService.updateEvaluate(evaluate);
          }else {
               //新增

               commentService.addEvaluate(evaluate);
          }
     }
     //删除
     @RequestMapping("deleteAll")
     @ResponseBody
     public  void  deleteAll(String id) {
          commentService.deleteAll(id);
     }


     }
