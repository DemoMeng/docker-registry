package com.mqz.better.registry.model.dto;

import com.mqz.mars.base.page.PageCommonDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
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
@ApiModel(value = "镜像标签详情层信息")
public class ImageTagDetailDTO extends PageCommonDTO implements Serializable {


    @ApiModelProperty(value = "镜像名")
    @NotEmpty(message = "镜像名不得为空")
    private String name;

    @ApiModelProperty(value = "版本")
    @NotEmpty(message = "版本不得为空")
    private String tag;

}
