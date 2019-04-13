package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.News;

/**
 * @author Mr.Zhang
 * @title: NewsService
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:59
 */
public interface NewsService {


    JSONObject queryNews(News news);

    Boolean delNewById(String ids);

    Boolean updOrSaveNew(News news);

    News queryNewById(String newsId);
}
