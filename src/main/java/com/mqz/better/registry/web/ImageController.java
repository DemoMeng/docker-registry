package com.mqz.better.registry.web;

import com.mqz.better.registry.compent.RegistryComponent;
import com.mqz.mars.base.response.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */

@RestController
@RequestMapping(value = "/repository")
@Api(value = "仓库管理-入口",tags = "仓库管理")
public class ImageController {

    @Resource
    private RegistryComponent registryComponent;

    @ApiOperation(value = "镜像版本列表",httpMethod = "GET")
    @GetMapping(value = "/tags/list")
    public ResponseBean list(@ApiParam(value = "镜像名",name = "name")
                             @RequestParam(value = "name") String name){//TODO全局异常处理
        return ResponseBean.SUCCESS(registryComponent.getImageTagsList(name));
    }


}
