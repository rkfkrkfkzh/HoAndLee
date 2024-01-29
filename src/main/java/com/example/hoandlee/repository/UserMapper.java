package com.example.hoandlee.repository;

import com.example.hoandlee.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users(username, password) VALUES(#{username},#{password}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);
}
