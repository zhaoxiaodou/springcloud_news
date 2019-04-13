package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.Category;
import com.jk.pojo.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: NewsService
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:59
 */
@FeignClient("news-provider")
public interface NewsService {

    @RequestMapping("cate/queryCategory")
    List<Category> queryCategory();

    @RequestMapping("news/queryNews")
    JSONObject queryNews(News news);

    @RequestMapping("news/delNewById")
    Boolean delNewById(@RequestParam(value = "ids") String ids);

    @RequestMapping("news/updOrSaveNew")
    Boolean updOrSaveNew(News news);

    @RequestMapping("news/queryNewById")
    News queryNewById(@RequestParam(value = "newsId") String newsId);

}
