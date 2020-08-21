package com.rdbf.demo.apiauth.repository;

import com.rdbf.demo.apiauth.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ArticleRepository {
    //articlesの指定したカラムをselectする
    @Select("SELECT article_id,  FROM articles WHERE article_id = #{articleId}")
    Article findByArticleId(Long articleId);

    @Select("SELECT article_id,  FROM articles")
    List<Article> findAll();

}
