package com.iterators.minimalism.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Data
public class Blog {

    /**
     * 博客id
     */
    private Integer id;

    /**
     * 博客具体内容的id,关联的article的id
     */
    private Integer articleId;

    /**
     * 博客创建时间
     */
    private Date createTime;
}
