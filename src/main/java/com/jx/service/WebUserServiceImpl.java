package com.jx.service;

import com.jx.mapper.WebUserMapper;
import com.jx.model.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WebUserServiceImpl implements  WebUserService {
    @Autowired
    private WebUserMapper webUserMapper;

    //修改
    @Override
    public void updateWebUser(WebUser webuser) {
        webUserMapper.updateWebUser(webuser);
    }

    //新增
    @Override
    public void addWebUser(WebUser webuser) {
        webUserMapper.addWebUser(webuser);
    }

    @Override
    public List<WebUser> queryWebUser() {
        return webUserMapper.queryPageWebUser();
    }
    //修改 回显
    @Override
    public WebUser queryWebUserById(Integer id) {
        return webUserMapper.queryWebUserById(id);
    }

    @Override
    public void deleteWebUserAll(String id) {
        String[] split = id.split(",");
        for (int i=0;i<split.length;i++){
             webUserMapper.deleteWebUserAll(split[i]);
        }
    }
}
