package cn.jzteam.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jzteam.task.dao.UserEntityMapper;
import cn.jzteam.task.dao.entity.UserEntity;
import cn.jzteam.task.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserEntityMapper userMapper;
    
    @Override
    public UserEntity get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
