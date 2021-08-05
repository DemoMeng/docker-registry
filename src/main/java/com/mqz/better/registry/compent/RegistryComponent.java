package com.mqz.better.registry.compent;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mqz.better.registry.common.ConfigProperty;
import com.mqz.better.registry.common.Constant;
import com.mqz.better.registry.model.vo.ImageTagVO;
import com.mqz.better.registry.model.vo.RepositoryListVO;
import com.mqz.mars.base.utils.OkHttpUtils;
import com.mqz.mars.validation.exceptions.ServicesException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Component
public class RegistryComponent {

    @Resource
    private ConfigProperty configProperty;


    /**
     * 获取所有镜像名
     * @return
     */
    public List<String> getRepositoryNameList(){
        StringBuffer url = new StringBuffer(configProperty.getRegistryUrl());
        url.append(Constant.DockerRegistry.head);
        url.append(Constant.DockerRegistry.repository_url);
        String result = null;
        try {
            result = OkHttpUtils.get(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServicesException("调用registry的api接口异常");
        }
        List<String> repositoryList = new ArrayList<>();
        if(StringUtils.isEmpty(result)){
            throw new ServicesException("调用registry的api接口异常");
        }
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if (jsonObject.isNull("repositories")) {
            throw new ServicesException("调用registry的api接口异常");
        }
        JSONArray jsonArray = jsonObject.getJSONArray("repositories");
        for(Object ja : jsonArray){
            repositoryList.add(String.valueOf(ja));
        }
        return repositoryList;
    }


    public List<ImageTagVO> getImageTagsList(String name){
        List<String> nameList = new ArrayList<>();
        if(StringUtils.isEmpty(name)){
            nameList = getRepositoryNameList();
        }else{
            nameList.add(name);
        }

        List<ImageTagVO> imageTagList = new ArrayList<>();
        for(String searchName:nameList ){
            StringBuffer url = new StringBuffer(configProperty.getRegistryUrl());
            url.append(Constant.DockerRegistry.head);
            url.append("/");
            url.append(searchName);
            url.append(Constant.DockerRegistry.image_tag_list);
            String result = null;
            try {
                 result = OkHttpUtils.get(url.toString());
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServicesException("调用registry的api接口异常");
            }
            if(!StringUtils.isEmpty(result)){
                ImageTagVO vo = JSONUtil.toBean(result, ImageTagVO.class);
                imageTagList.add(vo);
            }
        }
        return imageTagList;
    }

}
