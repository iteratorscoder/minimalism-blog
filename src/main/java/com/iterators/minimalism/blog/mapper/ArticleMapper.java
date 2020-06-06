package com.iterators.minimalism.blog.mapper;

import com.iterators.minimalism.blog.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Mapper
public interface ArticleMapper {
    
    @Select("SELECT * FROM articles where id = #{id}")
    Article getArticleById(Integer id);

    @Insert("INSERT INTO articles (content, create_time, views) VALUES (#{article.content}, #{article.createTime}, #{article.views})")
    void insertArticle(Article article);
}
