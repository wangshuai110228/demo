package com.jx.service;

import com.jx.model.WebUser;

import java.util.HashMap;
import java.util.List;

public interface WebUserService {
    void updateWebUser(WebUser webuser);

    void addWebUser(WebUser webuser);

    List<WebUser> queryWebUser();

    WebUser queryWebUserById(Integer id);

    void deleteWebUserAll(String id);
}
