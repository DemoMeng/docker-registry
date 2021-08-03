package com.mqz.better.registry.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@ApiModel(value = "仓库列表")
public class RepositoryListVO implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "镜像名列表",example = "['nacos-gateway']")
    private List<String> repositories;
    @ApiModelProperty(value = "镜像名列表",example = "['nacos-gateway']")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "操作人账号")
    private String operateAccount;
    @ApiModelProperty(value = "操作人角色")
    private String operatorRole;
    @ApiModelProperty(value = "结果")
    private String result;

    @ApiModelProperty(value = "大小")
    private Integer size;

}
