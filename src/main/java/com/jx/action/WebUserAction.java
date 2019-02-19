package com.jx.action;

import com.jx.model.WebUser;
import com.jx.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("web")
public class WebUserAction {
    @Autowired
    private WebUserService webUserService;
    //查询用户表
    @RequestMapping("queryWebUser")
    @ResponseBody
    public List<WebUser> queryCatalog(){
        return webUserService.queryWebUser();
    }
    //修改回显
    @RequestMapping("queryWebUserById")
    @ResponseBody
     public WebUser queryWebUserById(Integer id){
        return webUserService.queryWebUserById(id);
    }
    //修改 ： 新增
    @RequestMapping("addWebUser")
    @ResponseBody
    public void  addAnswer(WebUser webuser) {

        Integer id = webuser.getId();
        if (id != null) {
            //修改
            webUserService.updateWebUser(webuser);
        } else {
            //新增
            webUserService.addWebUser(webuser);
        }
    }
    //删除 批量删除
    @RequestMapping("deleteWebUserAll")
    @ResponseBody
    public void deleteWebUserAll(String id){
        webUserService.deleteWebUserAll(id);
    }
}
