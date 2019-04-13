package com.jk.dao;

import com.jk.pojo.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: CateDao
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:34
 */
public interface CateDao {

    @Select("select cateId as cateId , cateName as text , href as href ,pid as pid from t_category where pid = #{pid}")
    List<Category> queryCategory(String s);
}
