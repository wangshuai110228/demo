package com.jx.service;

import com.jx.mapper.TreeMapper;
import com.jx.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> queryTree(Integer pid) {
        return com(pid);
    }
    private List<Tree> com(int pid){
        List<Tree> list=treeMapper.queryTree(pid);
        for (Tree tree : list) {
            Integer id = tree.getId();
            List<Tree> com = com(id);
            tree.setChildren(com);
        }
        return list;
    }
}
