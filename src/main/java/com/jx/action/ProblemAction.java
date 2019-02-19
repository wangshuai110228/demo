package com.jx.action;

import com.jx.model.Answer;
import com.jx.model.Problem;
import com.jx.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("problem")
public class ProblemAction {
         @Autowired
         private ProblemService problemService;
    //回显
    @RequestMapping("queryProblemById")
    @ResponseBody
    public Answer queryProblemById(Integer id) {
        return problemService.queryProblemById(id);
    }
    //修改新增
    @RequestMapping("addProblem")
    @ResponseBody
    public void  addProblem(Problem problem){
        Integer id = problem.getId();
        if (id!=null){
            //修改
            problemService.updateProblem(problem);
        }else {
            problemService.addProblem(problem);
        }
    }
    //查询
    @RequestMapping("queryProblem2")
    @ResponseBody
    public HashMap<String,Object> queryProblem2(int page, int rows, Problem problem){
        return problemService.queryProblem2(page,rows, problem);
    }
    //删除
    @RequestMapping("deleteProblemAll")
    @ResponseBody
    public  void  deleteAll(String id){

        problemService.deleteAll(id);
    }
}
