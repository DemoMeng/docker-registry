package com.mqz.better.registry.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public String hello(){
        return "hello";
    }


    @RequestMapping(value = "/repository")
    public String repository(){
        return "repository/repository";
    }


    @RequestMapping(value = "/image")
    public String image(){
        return "image/image";
    }




}
