package com.jx.mapper;

import com.jx.model.WebUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WebUserMapper {
    //回显
    @Select("select * from t_webuser c where c.id=#{id}")
    WebUser queryWebUserById(Integer id);
    //修改
    @Update("update t_webuser c set c.name=#{name} ,c.pwd=#{pwd} ,c.email=#{email}, c.sex=#{sex} where c.id=#{id}")
    void updateWebUser(WebUser webuser);

    //新增
    @Insert("insert into t_webuser(name,pwd,email,sex) values(#{name},#{pwd},#{email},#{sex})")
    void addWebUser(WebUser webuser);


    //查询
    @Select("select * from t_webuser ")
    List<WebUser> queryPageWebUser();

    //删除 批量删除
    @Delete("delete  from t_webuser  where id=#{s}")
    void deleteWebUserAll(String s);
}
