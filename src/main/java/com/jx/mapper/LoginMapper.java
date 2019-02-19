package com.jx.mapper;

import com.jx.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginMapper {
    @Select("select * from t_user where username=#{username}")
    User queryUserByName(String name);


}
