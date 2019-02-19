package com.jx.action;

import com.jx.model.User;
import com.jx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginAction {
    @Autowired
    private LoginService loginService;
    @RequestMapping("queryUserByLogin")
    @ResponseBody
    public String login(User users, HttpSession session){
        //根据用户名查询用户信息
        User user2=loginService.queryUserByName(users.getUsername());
        if (user2==null) {
            return"用户名错误";
        }
        //验证密码
        String pwd = users.getUserpwd();
        if (!user2.getUserpwd().equals(pwd)) {
            return"密码错误";
        }
        session.setAttribute("user", user2);
        return"登录成功";
    }

}
