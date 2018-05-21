package com.xubh.springboot.mapper;

import com.xubh.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id= #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},id=#{id},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete * from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(id,lastName,email,gender,d_id) values (#{id},#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpBylastName(String lastName);
}