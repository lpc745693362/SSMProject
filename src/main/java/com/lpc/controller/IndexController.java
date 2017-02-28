package com.lpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/login")
    public String loginIndex(){
        return "login";
    }

    @RequestMapping("/service")
    public String serviceIndex(){
        return "service";
    }

    @RequestMapping("/layout")
    public String layoutIndex(){
        return "layout";
    }

    @RequestMapping("/param")
    public String paramIndex(){
        return "param";
    }

    @RequestMapping("/charts")
    public String chartsIndex(){
        return "charts";
    }

}
