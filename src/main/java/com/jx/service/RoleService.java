package com.jx.service;

import com.jx.model.PowerMenu;
import com.jx.model.Role;
import com.jx.model.Tree;

import java.util.List;

public interface RoleService {
    List<Role> queryRole();

    void saveRolePower(Integer roleId, String powerIds);

    List<Tree> authTree2(String id);

    void deleteAll(String id);

    String savePowerMenu(PowerMenu powerMenu);

    List<PowerMenu> querypowerMenu(String powerId);
}
