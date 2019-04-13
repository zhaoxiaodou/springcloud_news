package com.jk.controller;

import com.jk.pojo.Category;
import com.jk.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: CateController
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:32
 */
@RestController
@RequestMapping("cate")
public class CateController {

    @Autowired
    private CateService cateService;

    @RequestMapping("queryCategory")
    public List<Category> queryCategory(){
        return cateService.queryCategory();
    }

}
