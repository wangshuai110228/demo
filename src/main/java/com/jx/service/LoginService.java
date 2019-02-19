package com.jx.service;

import com.jx.model.User;

import java.util.List;

public interface LoginService {
    User queryUserByName(String name);

}
