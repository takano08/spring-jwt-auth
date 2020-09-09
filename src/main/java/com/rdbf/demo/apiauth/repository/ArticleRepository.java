package com.rdbf.demo.apiauth.repository;

import com.rdbf.demo.apiauth.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {
    //articlesの指定したカラムをselectする
    @Select("SELECT article_id,title,created_date,tag,body,owner FROM articles WHERE article_id = #{articleId}")
    Article findByArticleId(Integer articleId);

    @Select("SELECT article_id,title,created_date,tag,body,owner FROM articles ORDER BY article_id DESC")
    List<Article> findAll();

    @Insert("INSERT INTO articles(article_id,title,created_date,tag,body,owner) VALUES (#{articleId},#{title},#{createdDate},#{tag},#{body},#{owner})")
    void createArticle(Article createArticleData);

    @Update("UPDATE articles SET title=#{title},created_date=#{createdDate},tag=#{tag},body=#{body},owner=#{owner} WHERE article_id = #{articleId}")
    void updateArticle(Article updateArticleData);

    @Delete("DELETE FROM articles WHERE article_id = #{articleId}")
    void deleteByArticleId(Integer articleId);
}
