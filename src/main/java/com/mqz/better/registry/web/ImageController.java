package com.mqz.better.registry.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mqz.better.registry.compent.RegistryComponent;
import com.mqz.better.registry.model.dto.ImageTagsListDTO;
import com.mqz.better.registry.model.vo.ImageTagVO;
import com.mqz.mars.base.response.ResponseBean;
import com.mqz.mars.base.utils.PageHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */

@RestController
@RequestMapping(value = "/image")
@Api(value = "仓库管理-入口",tags = "仓库管理")
public class ImageController {

    @Resource
    private RegistryComponent registryComponent;

    @ApiOperation(value = "镜像版本列表",httpMethod = "GET")
    @PostMapping(value = "/tags/list")
    public ResponseBean list(@RequestBody ImageTagsListDTO dto){
        List<ImageTagVO> list = registryComponent.getImageTagsList(dto.getName());
        PageInfo<ImageTagVO> page = PageHandler.pageList(list, dto.getPageCurrent(), dto.getPageSize());
        return ResponseBean.SUCCESS(page);
    }


}
