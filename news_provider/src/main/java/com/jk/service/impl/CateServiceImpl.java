package com.jk.service.impl;

import com.jk.dao.CateDao;
import com.jk.pojo.Category;
import com.jk.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: CateServiceImpl
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:33
 */
@Service
public class CateServiceImpl implements CateService{

    @Autowired
    private CateDao cateDao;

    @Override
    public List<Category> queryCategory() {
        List<Category> list = cateDao.queryCategory("0");
        queryCategory(list);
        return list;
    }

    private void queryCategory(List<Category> list) {
        for(Category category : list){
            List<Category> data = cateDao.queryCategory(category.getCateId());
            if (data != null && data.size() > 0){
                category.setNodes(data);
                category.setSelectable(true);
            }
        queryCategory(data);
        }
    }
}
