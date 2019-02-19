package com.jx.mapper;

import com.jx.model.Tree;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreeMapper {
    @Select("select * from t_tree where pid = #{id}")
    List<Tree> queryTree(Integer id);
}
