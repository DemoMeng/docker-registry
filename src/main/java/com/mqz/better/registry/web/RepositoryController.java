package com.mqz.better.registry.web;

import com.mqz.better.registry.common.ConfigProperty;
import com.mqz.better.registry.common.Constant;
import com.mqz.better.registry.utils.OkHttpUtils;
import com.mqz.mars.base.page.PageCommonDTO;
import com.mqz.mars.base.response.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

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
public class RepositoryController {

    @Resource
    private ConfigProperty configProperty;

    @ApiOperation(value = "所有仓库列表",httpMethod = "GET")
    @GetMapping(value = "/list")
    public ResponseBean list(@RequestBody PageCommonDTO dto) throws IOException {//TODO全局异常处理
        StringBuffer url = new StringBuffer(configProperty.getRegistryUrl());
        url.append(Constant.DockerRegistry.head);
        url.append(Constant.DockerRegistry.repository_url);
        return ResponseBean.SUCCESS(OkHttpUtils.get(url.toString()));
    }



}
