package com.jx.mapper;

import com.jx.model.Answer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AnswerMapper {
    //查询
    @Select("select * from t_answer a left join t_problem pm on a.wid=pm.id ")
    List<Answer> queryPageProblem();
    //回显
    @Select("select * from t_answer where id=#{id}")
    Answer queryAnswerById(Integer id);
    //修改
    @Update("update t_answer p set p.contont=#{contont} ,p.createtime=#{createtime},p.wid=#{wid} where p.id=#{id}")
    void updateAnswer(Answer answer);

    //新增
    @Insert("insert into t_answer(contont,createtime,wid) values(#{contont},#{createtime},#{wid})")
    void addAnswer(Answer answer);

    //刪除
    @Delete("delete from t_answer where id=#{s}")
    void deleteAnswerAll(String s);
}
