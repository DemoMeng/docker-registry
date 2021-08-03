package com.mqz.better.registry.web;

import cn.hutool.json.JSONUtil;
import com.mqz.better.registry.common.ConfigProperty;
import com.mqz.better.registry.common.Constant;
import com.mqz.better.registry.model.vo.RepositoryListVO;
import com.mqz.mars.base.page.PageCommonDTO;
import com.mqz.mars.base.response.ResponseBean;
import com.mqz.mars.base.utils.OkHttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/list")
    public ResponseBean list(@RequestBody PageCommonDTO dto) throws IOException {//TODO全局异常处理
        StringBuffer url = new StringBuffer(configProperty.getRegistryUrl());
        url.append(Constant.DockerRegistry.head);
        url.append(Constant.DockerRegistry.repository_url);
        String result = OkHttpUtils.get(url.toString());
        RepositoryListVO vo = JSONUtil.toBean(result, RepositoryListVO.class);
        vo.setId(1);
        vo.setCreateTime("2021-01-02 15:25:22");
        vo.setResult("成功");
        vo.setOperateAccount("13128507506");
        vo.setOperatorRole("admin");
        vo.setSize(5);
        vo.setName(vo.getRepositories().toString());
        return ResponseBean.SUCCESS(vo);
    }



}
