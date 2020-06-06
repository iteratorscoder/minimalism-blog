package com.iterators.minimalism.blog.controller;

import com.iterators.minimalism.blog.entity.Article;
import com.iterators.minimalism.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author iterators
 * @time 2020.06.06
 */
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/article/{id}")
    public Article getArticle(@PathVariable("id") Integer articleId) {
        return articleService.getArticleById(articleId);
    }

    @PostMapping("/article")
    public void uploadArticle(@RequestParam("file") MultipartFile file) {
        articleService.insertArticle(file);
    }
}
