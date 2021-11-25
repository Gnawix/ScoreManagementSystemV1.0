package com.sms.dao;

import com.sms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User queryUser(@Param("username") String username);

    @Update("update user set password=#{password} where username=#{username}")
    int updatePassword(@Param("username") String username, @Param("password") String password);
}
