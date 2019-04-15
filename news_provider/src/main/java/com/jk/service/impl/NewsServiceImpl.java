package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.NewsDao;
import com.jk.pojo.News;
import com.jk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: NewsServiceImpl
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:59
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public JSONObject queryNews(News news) {
        Integer count = newsDao.queryNewCount(news);
        List<News> list = newsDao.queryNews(news);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", count);
        jsonObject.put("rows", list);
        return jsonObject;
    }

    @Override
    public Boolean delNewById(String ids) {
        String[] split = ids.split(",");
        return newsDao.delNewById(split);
    }

    @Override
    public Boolean updOrSaveNew(News news) {
        int count;
        if (news.getNewsId() != null && news.getNewsId() != "") {
            count = newsDao.updateNew(news);
        } else {
            count = newsDao.saveNew(news);
        }
        return count == 1 ? true : false;
    }

    @Override
    public News queryNewById(String newsId) {
        return newsDao.queryNewById(newsId);
    }
}
