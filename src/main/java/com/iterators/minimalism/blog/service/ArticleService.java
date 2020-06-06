package com.iterators.minimalism.blog.service;

import com.iterators.minimalism.blog.entity.Article;
import com.iterators.minimalism.blog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Service
public class ArticleService {

    private final ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    public void insertArticle(MultipartFile article) {

        Article article1 = new Article();
        articleMapper.insertArticle(article1);
    }
}
