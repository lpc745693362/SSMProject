package com.lpc.controller;

import com.lpc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * list<Object>类型参数接收
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/list")
    @ResponseBody
    public String listUser(HttpServletRequest request, @RequestBody List<User> users) {
        System.out.println("contextPath：====== " + request.getContextPath());
        for (User user : users) {
            System.out.println("user is ======= " + user);
        }
        return "param";
    }

}
