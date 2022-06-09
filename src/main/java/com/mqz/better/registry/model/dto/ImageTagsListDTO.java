package com.mqz.better.registry.model.dto;

import com.mqz.mars.base.page.PageCommonDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "镜像标签列表")
public class ImageTagsListDTO extends PageCommonDTO implements Serializable {


    @ApiModelProperty(value = "镜像名")
    private String name;

}
