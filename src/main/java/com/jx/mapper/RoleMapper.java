package com.jx.mapper;

import com.jx.model.PowerMenu;
import com.jx.model.Role;
import com.jx.model.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    //查询
    @Select("select * from t_role")
    List<Role> queryRole();

    //删除 关联角色表 重复新增内容 (等于修改)
    @Delete("delete  from t_role_power  where  roleid=#{roleId}")
    void deleteRolePowerById(Integer roleId);


    //新增角色关联权限树表
    @Insert("insert into t_role_power(roleid,powerid) values(#{roleId},#{s})")
    void saveRolePower(@Param("roleId") Integer roleId, @Param("s") String s);

    //查询角色关联树
    @Select("select * from t_tree t left join t_role_power rp on t.id=rp.powerid where rp.roleid=#{id}")
    List<Tree> queryByRoleId(String id);

    //查询中间表的树
    @Select("select * from t_tree")
    List<Tree> authTree2();

    @Select("select * from t_powermenu pm where  pm.power_id =#{powerId}")
    List<PowerMenu> querypowerMenu(String powerId);

    //删除
    @Delete("delete  from t_powermenu  where id=#{s} ")
    void deleteAll(String s);
    //新增权限详情
    @Insert("insert into t_powermenu (name,url,power_id) values(#{name},#{url},#{power_id})")
    String savePowerMenu(PowerMenu powerMenu);
}
