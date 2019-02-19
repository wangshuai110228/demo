package com.jx.action;

import com.jx.model.PowerMenu;
import com.jx.model.Role;
import com.jx.model.Tree;
import com.jx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("role")
public class RoleAction {
    @Autowired
    private RoleService roleService;
    //查询角色
    @RequestMapping("queryRole")
    @ResponseBody
    public List<Role> queryRole(){

        return roleService.queryRole();
    }
    //查询中间表的树
    @RequestMapping("authTree2")
    @ResponseBody
    public  List<Tree>  authTree2(String id){
        return roleService.authTree2(id);
    }

    //赋权限
    @RequestMapping("saveRolePower")
    @ResponseBody
    public  void  saveRolePower(Integer roleId,String powerIds){
        roleService.saveRolePower(roleId,powerIds);
    }
    //查询 权限详情
    @ResponseBody
    @RequestMapping("querypowerMenu")
    public  List<PowerMenu> querypowerMenu(String powerId){

        return roleService.querypowerMenu(powerId);
    }
    //新增
    @ResponseBody
    @RequestMapping("savePowerMenu")
    public  String savePowerMenu(PowerMenu powerMenu){

        return roleService.savePowerMenu(powerMenu);
    }

    //删除权限
    //批量删除
    @RequestMapping("deletePowerMenuAll")
    @ResponseBody
    public  void  deleteAll(String id){
        roleService.deleteAll(id);
    }
}
