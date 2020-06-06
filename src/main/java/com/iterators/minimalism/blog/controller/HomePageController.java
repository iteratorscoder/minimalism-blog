package com.iterators.minimalism.blog.controller;

import com.iterators.minimalism.blog.entity.Blog;
import com.iterators.minimalism.blog.service.HomePageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author iterators
 * @time 2020.06.06
 */
@RestController
public class HomePageController {

    private final HomePageService homePageService;

    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @RequestMapping("/")
    public List<Blog> getAllBlogs(@RequestParam("page") Integer pageId) {
        return homePageService.getAllBlogs(pageId);
    }

}
