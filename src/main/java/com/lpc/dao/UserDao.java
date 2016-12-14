package com.lpc.dao;

import com.lpc.domain.User;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public interface UserDao {

    int deleteById(Long userId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectBySelective(User user);

}
