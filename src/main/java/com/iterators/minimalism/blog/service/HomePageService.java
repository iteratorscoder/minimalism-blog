package com.iterators.minimalism.blog.service;

import com.iterators.minimalism.blog.entity.Blog;
import com.iterators.minimalism.blog.mapper.HomePageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Service
public class HomePageService {

    public static final int PAGE = 10;

    private final HomePageMapper homePageMapper;

    public HomePageService(HomePageMapper homePageMapper) {
        this.homePageMapper = homePageMapper;
    }

    public List<Blog> getAllBlogs(Integer pageId) {
        int offset = (pageId - 1) * PAGE;
        return homePageMapper.getAllBlogs(PAGE, offset);
    }
}
