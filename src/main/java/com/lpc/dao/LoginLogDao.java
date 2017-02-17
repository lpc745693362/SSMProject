package com.lpc.dao;

import com.lpc.domain.LoginLog;
import com.lpc.util.DataSource;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public interface LoginLogDao {

    @DataSource("master")
    int deleteById(Long loginLogId);

    @DataSource("master")
    int insert(LoginLog loginLog);

    @DataSource("master")
    int insertSelective(LoginLog loginLog);

    @DataSource("slave")
    LoginLog selectById(Long loginLogId);

    @DataSource("master")
    int updateByIdSelective(LoginLog loginLog);

    @DataSource("master")
    int updateById(LoginLog loginLog);

    @DataSource("slave")
    LoginLog selectBySelective(LoginLog loginLog);

}
