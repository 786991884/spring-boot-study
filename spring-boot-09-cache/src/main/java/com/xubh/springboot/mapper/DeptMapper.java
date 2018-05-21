package com.xubh.springboot.mapper;

import com.xubh.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {

    @Select("select * from department where id = #{id}")
    Department selectOneById(Integer id);
}
