package com.mqz.better.registry.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@ApiModel(value = "镜像所有版本")
public class ImageTagVO implements Serializable {

    @ApiModelProperty(value = "镜像名称")
    private String name;

    @ApiModelProperty(value = "版本信息")
    private List<String> tags;

}
