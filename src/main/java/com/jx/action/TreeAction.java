package com.jx.action;

import com.jx.model.Tree;
import com.jx.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tree")
public class TreeAction {
    @Autowired
    private TreeService treeService;
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(Integer pid){
        return treeService.queryTree(pid);
    }
}
