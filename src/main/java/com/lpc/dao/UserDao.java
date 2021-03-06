package com.lpc.dao;

import com.lpc.domain.User;
import com.lpc.util.DataSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
@Service
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

    @DataSource("slave")
    List<User> selectAllUser();

}
