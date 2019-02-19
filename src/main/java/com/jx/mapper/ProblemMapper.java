package com.jx.mapper;

import com.jx.model.Answer;
import com.jx.model.Problem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProblemMapper {
    //回显
    @Select("select * from t_problem where id=#{id}")
    Answer queryProblemById(Integer id);
    //修改
    @Update("update t_problem p set p.name=#{name} ,p.createtime=#{createtime},p.sfzr=#{sfzr} where p.id=#{id}")
    void updateProblem(Problem problem);
    //新增
    @Insert("insert into t_problem(name,createtime,sfzr) values(#{name},#{createtime},#{sfzr})")
    void addProblem(Problem problem);

    //查询总条数
    @Select("select count(*)  from t_problem")
    long queryTotal(@Param("problem") Problem problem);
    //查询
    @Select("select * from t_problem limit #{start},#{rows}")
    List<Problem> queryPageProblem(@Param("start") int start, @Param("rows") int rows, @Param("problem") Problem problem);

    //删除
    @Delete("delete from t_problem where id=#{s}")
    void deleteAll(String s);
}
