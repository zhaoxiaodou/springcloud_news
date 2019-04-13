package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.Category;
import com.jk.pojo.News;
import com.jk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: NewsController
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:57
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("queryNews")
    public JSONObject queryNews(@RequestBody News news){
        return newsService.queryNews(news);
    }

    @RequestMapping("delNewById")
    public Boolean delNewById(@RequestParam(value = "ids") String ids){
        return newsService.delNewById(ids);
    }

    @RequestMapping("updOrSaveNew")
    public Boolean updOrSaveNew(@RequestBody News news){
        return newsService.updOrSaveNew(news);
    }

    @RequestMapping("queryNewById")
    public News queryNewById(@RequestParam(value = "newsId") String newsId){
        return newsService.queryNewById(newsId);
    }


}
