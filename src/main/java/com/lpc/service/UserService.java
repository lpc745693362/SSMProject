package com.lpc.service;

import com.lpc.domain.User;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public interface UserService {

    boolean hasMatchuser(String userName, String password);

    User findByUserName(String userName);

    void loginSuccess(User user);

}
