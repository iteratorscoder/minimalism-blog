package com.iterators.minimalism.blog.wrapper;

import com.iterators.minimalism.blog.entity.MarkdownEntity;
import com.iterators.minimalism.blog.util.MarkdownUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.InputStream;

/**
 * @author iterators
 * @time 2020.06.07
 */
public class MarkdownToHtmlWrapper {

    public static final String MARKDOWN_STYLE_LOCATION = "classpath:static/css/md_style.css";
    public static String MD_CSS;

    static {
        try {

            MD_CSS = FileCopyUtils.copyToString(new FileReader(ResourceUtils.getFile(MARKDOWN_STYLE_LOCATION)));
            MD_CSS = "<style type=\"text/css\">\n" + MD_CSS + "\n</style>\n";
        } catch (Exception e) {
            MD_CSS = "";
        }
    }


    /**
     * 对markdown数据流增加css样式
     *
     * @param stream markdown数据流
     * @return
     */
    public static MarkdownEntity ofStream(InputStream stream) {
        String content = MarkdownUtils.mdToHtml(stream);
        return ofContent(content);
    }


    /**
     * 对markdown文本增加css样式
     *
     * @param content markdown文本
     * @return
     */
    public static MarkdownEntity ofContent(String content) {
        String html = MarkdownUtils.mdToHtml(content);
        MarkdownEntity entity = new MarkdownEntity();
        entity.setHtml(html);
        entity.setCss(MD_CSS);
        entity.addDivStyle("class", "markdown-body");
        return entity;
    }

}
