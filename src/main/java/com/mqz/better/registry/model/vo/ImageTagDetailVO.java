package com.mqz.better.registry.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@ApiModel(value = "镜像版本详情返回实体")
public class ImageTagDetailVO implements Serializable {


    @ApiModel(value = "镜像版本详情返回实体-异常类")
    @Data
    class Errors{
        @ApiModelProperty(value = "异常码",example = "MANIFEST_UNKNOWN")
        private String code;
        @ApiModelProperty(value = "异常信息",example = "manifest unknown")
        private String message;
    }
    @ApiModelProperty(value = "异常信息")
    private List<Errors> errors;
    @ApiModelProperty(value = "架构版本")
    private String schemaVersion;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "版本")
    private String tag;
    @ApiModelProperty(value = "架构信息")
    private String architecture;
    @ApiModelProperty(value = "签名信息")
    private List<Object> fsLayers;
    @ApiModelProperty(value = "历史信息")
    private List<Object> history;
    @ApiModelProperty(value = "签名信息")
    private List<Object> signatures;
}
