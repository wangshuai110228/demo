package com.jx.mapper;

import com.jx.model.Catalog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CatalogMapper {
    //查询目录
    @Select("select  *  from  t_catalog")
    List<Catalog> queryCatalog();
    //新增目录
    @Insert("insert into  t_catalog (caname,calink,catime)  values (#{caname},#{calink},sysdate())")
    void addCalalog(Catalog catalog);

}
