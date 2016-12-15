package com.lpc.controller;

import com.lpc.domain.LoginVo;
import com.lpc.domain.User;
import com.lpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.action")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/loginCheck.action")
    public ModelAndView loginCheck(HttpServletRequest request, LoginVo loginVo) {
        try {
            boolean isValidUser = userService.hasMatchuser(loginVo.getUserName(), loginVo.getPassword());
            if (!isValidUser) {
                return new ModelAndView("login", "error", "用户名或密码错误！");
            }

            User user = userService.findByUserName(loginVo.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");

        } catch (Exception e) {
            System.out.println("loginCheck e is ============ " + e);
        }
        return null;
    }

}
