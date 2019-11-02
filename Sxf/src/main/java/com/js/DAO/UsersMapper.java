package com.js.DAO;

import com.js.Common.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Insert("insert into users(id, name) values (#{id}, #{name})")
    int addUsers(Users users);
}