package com.jx.mapper;

import com.jx.model.Kecheng;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    //查询总条数
    @Select("select count(*)  from t_kecheng")
    long queryTotak(@Param("kecheng") Kecheng kecheng);



    //查询
    @Select("select * from t_kecheng limit #{start},#{rows}")
    List<Kecheng> queryPageKecheng(@Param("start") int start, @Param("rows") int rows, @Param("kecheng") Kecheng kecheng);

    //新增

    @Insert("insert into t_kecheng(kname,kss,lls,lteacher,oktime,ktype,kdesc,kurl) values(#{kname},#{kss},#{lls},#{lteacher},#{oktime},#{ktype},#{kdesc},#{kurl})")
    void addKecheng(Kecheng kecheng);

    //回显
    @Select("select * from  t_kecheng c where c.id=#{id}")
    Kecheng queryKechengById(Integer id);
    //修改
    @Update("update t_kecheng  set kname=#{kname} ,kss=#{kss},lls=#{lls},lteacher=#{lteacher},oktime=#{oktime},ktype=#{ktype},kdesc=#{kdesc},kurl=#{kurl} where id=#{id}")
    void updateKecheng(Kecheng kecheng);

    //删除
    @Delete("delete from t_kecheng where id=#{s}")
    void deleteAll(String s);


}
