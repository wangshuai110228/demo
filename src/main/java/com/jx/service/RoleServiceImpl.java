package com.jx.service;

import com.jx.mapper.RoleMapper;
import com.jx.model.PowerMenu;
import com.jx.model.Role;
import com.jx.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRole() {
        return roleMapper.queryRole();
    }

    //查询中间树
    @Override
    public List<Tree> authTree2(String id) {

        List<Tree>  RoleId = roleMapper.queryByRoleId(id);

        List<Tree> list = roleMapper.authTree2();
        for (Tree tree :list) {
            for ( Tree role: RoleId) {
                if (tree.getId()==role.getId()){
                    tree.setChecked(true);
                }
            }
        }

        return list;
    }

    //新增权限列表
    @Override
    public void saveRolePower(Integer roleId, String powerIds) {

        // 新增前删除 新增重复的
        roleMapper.deleteRolePowerById(roleId);
        //新增权限列表
        String[] split = powerIds.split(",");

        for (int i=0;i<split.length;i++){
            roleMapper.saveRolePower(roleId,split[i]);
        }
    }
    @Override
    public List<PowerMenu> querypowerMenu(String powerId) {

        return roleMapper.querypowerMenu(powerId);
    }
    //新权限详情
    @Override
    public String savePowerMenu(PowerMenu powerMenu) {
        return roleMapper.savePowerMenu(powerMenu);
    }
    //删除权限
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            roleMapper.deleteAll(sid[i]);
        }
    }
}
