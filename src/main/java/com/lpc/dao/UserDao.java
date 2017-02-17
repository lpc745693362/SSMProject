package com.lpc.dao;

import com.lpc.domain.User;
import com.lpc.util.DataSource;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public interface UserDao {

    @DataSource("master")
    int deleteById(Long userId);

    @DataSource("master")
    int insert(User user);

    @DataSource("master")
    int insertSelective(User user);

    @DataSource("slave")
    User selectById(Long userId);

    @DataSource("master")
    int updateByIdSelective(User user);

    @DataSource("master")
    int updateById(User user);

    @DataSource("slave")
    User selectBySelective(User user);

}
