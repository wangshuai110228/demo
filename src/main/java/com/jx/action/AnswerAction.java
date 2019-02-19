package com.jx.action;

import com.jx.model.Answer;
import com.jx.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("answer")
public class AnswerAction {
     @Autowired
    private AnswerService answerService;
     //回显
     @RequestMapping("queryAnswerById")
     @ResponseBody
     public Answer queryAnswerById(Integer id) {
          return answerService.queryAnswerById(id);
     }
     //修改新增
      @RequestMapping("addAnswer")
      @ResponseBody
      public void  addAnswer(Answer answer){
          Integer id = answer.getId();
          if (id!=null){
             //修改111111
              answerService.updateAnswer(answer);
          }else {
              answerService.addAnswer(answer);
          }
      }
    //查询
    @RequestMapping("queryAnswer")
    @ResponseBody
    public List<Answer> queryAnswer(){
             return  answerService.queryAnswer();
    }
    //刪除
    @RequestMapping("deleteAnswerAll")
    @ResponseBody
    public  void  deleteAnswerAll(String id) {
         answerService.deleteAnswerAll(id);
     }
    }
