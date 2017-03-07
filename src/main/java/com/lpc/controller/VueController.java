package com.lpc.controller;

import com.lpc.domain.User;
import com.lpc.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * vue - ajax 请求返回json数据
 */
@Controller
@RequestMapping("/vue")
public class VueController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/getUser")
    public String getUser(User user) {
        try {
            List<User> userList = new ArrayList<User>();
            userList = userService.selectAllUser();
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            String outJson = mapper.writeValueAsString(userList);
            System.out.println("outJson is ======== " + outJson);
            return outJson;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
