package cn.jzteam.task.service;

import cn.jzteam.task.dao.entity.UserEntity;

public interface IUserService {
    public UserEntity get(Integer id);
}
