package com.jk.service;

import com.jk.pojo.Category;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: CateService
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:33
 */
public interface CateService {
    List<Category> queryCategory();
}
