package com.lpc.dao;

import com.lpc.domain.LoginLog;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public interface LoginLogDao {

    int deleteById(Long loginLogId);

    int insert(LoginLog loginLog);

    int insertSelective(LoginLog loginLog);

    LoginLog selectById(Long loginLogId);

    int updateByIdSelective(LoginLog loginLog);

    int updateById(LoginLog loginLog);

    LoginLog selectBySelective(LoginLog loginLog);

}
