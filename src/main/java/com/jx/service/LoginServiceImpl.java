package com.jx.service;

import com.jx.mapper.LoginMapper;
import com.jx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Override
    public User queryUserByName(String name) {
        return loginMapper.queryUserByName(name);
    }




}