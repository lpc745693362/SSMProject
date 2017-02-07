package com.lpc.controller;

import com.lpc.domain.ServiceDesc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Created by liupengcheng1 on 2017/2/6.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/init")
    public ModelAndView init(@ModelAttribute("serviceDesc") ServiceDesc serviceDesc) {
        serviceDesc.clearParams();
        ServiceInvoker serviceInvoker = new ServiceInvoker(serviceDesc);
        try {
            serviceInvoker.getParametersOfService();
        } catch (Exception e) {
            return new ModelAndView("service", "error", e.getMessage());
        }
        return new ModelAndView("service");
    }

    @RequestMapping("invokeService")
    public ModelAndView invokeService(@ModelAttribute("serviceDesc") ServiceDesc serviceDesc){
        ServiceInvoker serviceInvoker = new ServiceInvoker(serviceDesc);
        try {
            serviceInvoker.getParametersOfService();
        } catch (Exception e) {
            return new ModelAndView("service", "error", e.getMessage());
        }
        String jsonResult = serviceInvoker.invoke();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jsonResult", jsonResult);
        modelAndView.setViewName("service");
        return modelAndView;
    }

}
