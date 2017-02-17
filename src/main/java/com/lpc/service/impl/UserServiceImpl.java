package com.lpc.service.impl;

import com.lpc.constant.Constants;
import com.lpc.dao.LoginLogDao;
import com.lpc.dao.UserDao;
import com.lpc.domain.LoginLog;
import com.lpc.domain.User;
import com.lpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public boolean hasMatchuser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User newUser = userDao.selectBySelective(user);
        if (newUser != null) {
            return true;
        }
        return false;
    }

    @Override
    public User findByUserName(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userDao.selectBySelective(user);
    }

    @Override
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + Constants.CREDITS_STEP);

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setLoginIp(user.getLastIp());
        loginLog.setLoginTime(user.getLastVisit());

        userDao.updateByIdSelective(user);
        loginLogDao.insert(loginLog);
    }

}
