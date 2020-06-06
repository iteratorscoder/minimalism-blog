package com.iterators.minimalism.blog.mapper;

import com.iterators.minimalism.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Mapper
public interface HomePageMapper {

    @Select("SELECT * FROM blogs LIMIT #{page} OFFSET #{offset}")
    List<Blog> getAllBlogs(int page, int offset);
}
