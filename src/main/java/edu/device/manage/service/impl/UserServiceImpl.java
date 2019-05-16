package edu.device.manage.service.impl;

import edu.device.manage.base.base.service.BaseServiceImpl;
import edu.device.manage.base.utils.MD5Utils;
import edu.device.manage.domain.User;
import edu.device.manage.mapper.UserMapper;
import edu.device.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 执笔
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userMapper.selectOne(user);
    }

    @Override
    public User login(String username, String password, String role) {
        User user = new User();
        user.setRole(role);
        user.setUsername(username);
        user.setPassword(MD5Utils.encrypt(password));
        return userMapper.selectOne(user);
    }

    @Override
    public List<Map<String, Integer>> count(Integer id) {
        return userMapper.count(id);
    }
}