package com.mqz.better.registry.web;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mqz.better.registry.common.ConfigProperty;
import com.mqz.better.registry.common.Constant;
import com.mqz.better.registry.compent.RegistryComponent;
import com.mqz.better.registry.model.vo.ImageTagVO;
import com.mqz.better.registry.model.vo.RepositoryListVO;
import com.mqz.mars.base.page.PageCommonDTO;
import com.mqz.mars.base.response.ResponseBean;
import com.mqz.mars.base.utils.OkHttpUtils;
import com.mqz.mars.base.utils.PageHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
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
@RequestMapping(value = "/repository")
@Api(value = "仓库管理-入口",tags = "仓库管理")
public class RepositoryController {

    @Resource
    private RegistryComponent registryComponent;


    @ApiOperation(value = "所有仓库列表",httpMethod = "GET")
    @PostMapping(value = "/list")
    public ResponseBean list(@RequestBody PageCommonDTO dto) {//TODO全局异常处理
        List<String> nameList = registryComponent.getRepositoryNameList();
        List<RepositoryListVO> list = new ArrayList<>();
        for(String name:nameList){
            RepositoryListVO vo = new RepositoryListVO();
            vo.setId(1);
            vo.setName(name);
            vo.setCreateTime("2021-01-02 15:25:22");
            vo.setResult("成功");
            vo.setOperateAccount("蒙大拿");
            vo.setOperatorRole("admin");
            vo.setSize(5);
            list.add(vo);
        }
        PageInfo<RepositoryListVO> page = PageHandler.pageList(list, dto.getPageCurrent(), dto.getPageSize());
        return ResponseBean.SUCCESS(page);
    }

    @ApiOperation(value = "分页不得得劲",httpMethod = "POST")
    @PostMapping(value = "/page")
    public ResponseBean page(@RequestBody PageCommonDTO dto) {//TODO全局异常处理
        //PageHelper.startPage(dto.getPageCurrent(),dto.getPageSize()); //针对mysql分页
        //对List数据分页
        List<ImageTagVO> list = registryComponent.getImageTagsList(null);
        PageInfo<ImageTagVO> pageInfo = PageHandler.pageList(list,dto.getPageCurrent(),dto.getPageSize());
        return ResponseBean.SUCCESS(pageInfo);
    }


}
