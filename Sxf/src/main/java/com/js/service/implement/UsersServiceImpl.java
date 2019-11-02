package com.js.service.implement;

import com.js.DAO.UsersMapper;
import com.js.Common.Users;
import com.js.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int addService(Users users) {
        return usersMapper.addUsers(users);
    }
}
