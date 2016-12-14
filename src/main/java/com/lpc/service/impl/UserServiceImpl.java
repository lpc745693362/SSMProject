package com.lpc.service.impl;

import com.lpc.constant.Constants;
import com.lpc.constant.IpUtils;
import com.lpc.dao.LoginLogDao;
import com.lpc.dao.UserDao;
import com.lpc.domain.LoginLog;
import com.lpc.domain.User;
import com.lpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
@Service
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
    public void LoginSuccess(User user) {
        Date date = new Date();

        user.setCredits(user.getCredits() + Constants.CREDITS_STEP);
        user.setLastIp(IpUtils.getIp());
        user.setLastVisit(date);

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setLoginIp(user.getLastIp());
        loginLog.setLoginTime(date);

        userDao.updateByPrimaryKeySelective(user);
        loginLogDao.insert(loginLog);
    }

}
