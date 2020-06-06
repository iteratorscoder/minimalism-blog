package com.iterators.minimalism.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author iterators
 * @time 2020.06.06
 */
@Data
public class Article {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 文章浏览量
     */
    private Integer views;

}
