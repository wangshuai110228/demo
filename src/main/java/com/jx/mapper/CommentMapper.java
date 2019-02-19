package com.jx.mapper;

import com.jx.model.Evaluate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {
    //查询
    @Select("select * from t_evaluate where status=1 ")
    List<Evaluate> queryPage();
    //回显
     @Select("select * from t_evaluate where id=#{id}")
    Evaluate queryEvaluateById(Integer id);
    //修改评价
    @Update("update t_evaluate p set p.puser=#{puser} ,p.kcid=#{kcid},p.contont=#{contont},p.ptime=#{ptime},p.status=#{status} where p.id=#{id}")
    void updateEvaluate(Evaluate evaluate);
    //新增评价
    @Insert("insert into t_evaluate(puser,kcid,contont,ptime,status) values(#{puser},#{kcid},#{contont},#{ptime},1)")
    void addEvaluate(Evaluate evaluate);

    //逻辑删
    @Update("update t_evaluate  set status=0 where id=#{s}")
    void deleteAll(String s);
}
