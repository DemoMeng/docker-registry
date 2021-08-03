package com.mqz.better.registry.common;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
public class Constant{

    public static class DockerRegistry{
        /** 请求前缀  */
        public final static String head = "/v2";
        /** 仓库列表url */
        public final static String repository_url = "/_catalog";


        /**  镜像版本名  */
        public final static String image_tag_list = "/tags/list";


    }


}
