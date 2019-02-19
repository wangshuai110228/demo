package com.jx.action;

import com.jx.model.Kecheng;
import com.jx.model.WebUser;
import com.jx.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("course")
public class CourseAction {
     @Autowired
     private CourseService courseService;

    //查询用户表
    @RequestMapping("querykechen")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Kecheng kecheng){
        HashMap<String,Object> list = courseService.querykechen(page,rows, kecheng);

        return list;

    }
    //修改回显
    @RequestMapping("queryKechengById")
    @ResponseBody
    public Kecheng queryKechengById(Integer id){

        Kecheng  kecheng   = courseService.queryKechengById(id);
        return kecheng;
    }

    //修改 ： 新增
    @RequestMapping("addKechen")
    @ResponseBody
    public void  addAnswer(Kecheng kecheng){

        Integer id = kecheng.getId();
        if (id!=null){
            //修改
            courseService.updateKecheng(kecheng);
        }else {
            //新增
            kecheng.setLls(0);
            courseService.addKecheng(kecheng);
        }

    }

    //批量删除
    @RequestMapping("deleteKechenAll")
    @ResponseBody
    public  void  deleteAll(String id){

        courseService.deleteAll(id);
    }


    //上传图片
    @RequestMapping("courseuploadImg")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam(value="picFile",required=false) MultipartFile picFile) {
        String path = null;
        try {
            path = com.jx.utils.FileUtil.FileUpload(picFile, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(path.contains("null")) {
            return null;
        }else {
            System.out.println(path);
            return path;

        }
    }
}
