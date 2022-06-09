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
@RequestMapping(value = "/")
public class IndexController {


    @RequestMapping(value = "")
    public String index1(){
        return "hello";
    }

    @RequestMapping(value = "index")
    public String index2(){
        return "hello";
    }

    @RequestMapping(value = "index/index")
    public String hello3(){
        return "hello";
    }


    @RequestMapping(value = "index/repository")
    public String repository(){
        return "repository/repository";
    }


    @RequestMapping(value = "index/image")
    public String image(){
        return "image/image";
    }

    @RequestMapping(value = "index/image/tag/detail")
    public String imageTagDetail(){
        return "image/image-detail";
    }

}
