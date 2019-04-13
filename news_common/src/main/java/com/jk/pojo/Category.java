package com.jk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: Category
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  19:40
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private String cateId;

    private String text;

    private String href;

    private String pid;

    private List<Category> nodes;

    private Boolean selectable = false;

}
