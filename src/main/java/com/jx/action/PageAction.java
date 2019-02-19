package com.jx.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("page")
public class PageAction {
    @RequestMapping("tree")
    public String tree(HttpServletRequest request){

        return "index";
    }
    @RequestMapping("rolepower")
    public  String  rolepower(){

        return "rolepower";
    }
    @RequestMapping("kecheng")
    public  String  kecheng(){

        return "kecheng";
    }
    @RequestMapping("webuser")
    public  String  webuser(){

        return "webuser";
    }
    @RequestMapping("pinglun")
    public  String  pinglun(){

        return "pinglun";
    }
    @RequestMapping("answer")
    public  String  answer(){

        return "answer";
    }
    @RequestMapping("problem")
    public  String  problem(){

        return "problem";
    }
    @RequestMapping("ecahers")
    public  String  ecahers(){

        return "ecahers";
    }
    @RequestMapping("catalog")
    public String  catalog(){
        return  "catalog";
    }

    @RequestMapping("slideshow")
    public String  slideshow(){
        return  "slideshow";
    }

}
