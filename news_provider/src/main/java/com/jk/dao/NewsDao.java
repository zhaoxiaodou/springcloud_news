package com.jk.dao;

import com.jk.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Mr.Zhang
 * @title: NewsDao
 * @projectName springcloud_news
 * @description: TODO
 * @date 2019/4/12  20:00
 */
public interface NewsDao {

    @SelectProvider(type = queryNewsClass.class,method = "queryNewCount")
    Integer queryNewCount(News news);

    @SelectProvider(type = queryNewsClass.class,method = "queryNews")
    List<News> queryNews(News news);

    class queryNewsClass{
        String newsType = "all";
        public String queryNews(News news){
            String sql = "select t.newsId as newsId,t.title as title,t.releaseTime as releaseTime,t.content as content,t.engineer as engineer,t.compiler as compiler,t.categoryId as categoryId,c.cateName as categoryName from t_news t left join t_category c on t.categoryId = c.cateId ";
            if (!news.getCategoryId().equals(newsType)){
                sql += " where t.categoryId = "+news.getCategoryId();
            }
            sql += news.getPage()!=null && news.getRows() !=null ? " limit "+(news.getPage()-1) * news.getRows()+" , "+news.getRows() : "";
            return sql;
        }
        public String queryNewCount(News news){
            String sql = "select count(*) from t_news t left join t_category c on t.categoryId = c.cateId ";
            sql += !news.getCategoryId().equals(newsType) ? " where t.categoryId = "+news.getCategoryId() : "";
            return sql;
        }
    }

    @Delete("delete from t_news where newsId in (#{_parameter})")
    Boolean delNewById(String ids);

    @Update(" update t_news set title = #{title},content = #{content},engineer = #{engineer},compiler = #{compiler},categoryId = #{categoryId} where newsId = #{newsId}")
    int updateNew(News news);

    @Insert("insert into t_news(newsId,title,releaseTime,content,engineer,compiler,categoryId) values (UUID(),#{title},NOW(),#{content},#{engineer},#{compiler},#{categoryId})")
    int saveNew(News news);

    @Select("select t.newsId as newsId,t.title as title,t.releaseTime as releaseTime,t.content as content,t.engineer as engineer,t.compiler as compiler,t.categoryId as categoryId from t_news t where t.newsId= #{newsId}")
    News queryNewById(String newsId);
}
