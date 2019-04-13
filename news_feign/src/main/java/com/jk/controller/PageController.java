package com.jk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.Zhang
 * @title: CateController
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:32
 */
@Controller
public class PageController {

    @RequestMapping("goToNewShow")
    public String goToNewShow(){
        return "newshow";
    }


    @RequestMapping("goToAddNew")
    public String goToAddNew(){
        return "addnews";
    }




}
