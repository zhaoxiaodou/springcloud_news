package com.jk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Mr.Zhang
 * @title: News
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:32
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class News {

    private String newsId;

    private String title;//主题

    private Date releaseTime;//发布时间

    private String content;//内容

    private String engineer;//策划

    private String compiler;//编辑

    private String categoryId;//类别

    private String categoryName;

    private Integer page;

    private Integer rows;

}
