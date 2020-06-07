package com.iterators.minimalism.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author iterators
 * @time 2020.06.07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkdownEntity {

    public static String TAG_WIDTH = "<style type=\"text/css\"> %s { width:85%%} </style>";

    /**
     * css样式
     */
    private String css;


    /**
     * 最外层的div样式
     */
    private Map<String, String> divStyle = new ConcurrentHashMap<>();

    /**
     * html内容
     */
    private String html;

    public MarkdownEntity(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return css + "\n<div " + parseDiv() + ">\n" + html + "\n</div>";
    }


    private String parseDiv() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : divStyle.entrySet()) {
            builder.append(entry.getKey()).append("=\"")
                    .append(entry.getValue()).append("\" ");
        }
        return builder.toString();
    }


    public void addDivStyle(String attrKey, String value) {
        if (divStyle.containsKey(attrKey)) {
            divStyle.put(attrKey, divStyle.get(attrKey) + " " + value);
        } else {
            divStyle.put(attrKey, value);
        }
    }


    public void addWidthCss(String tag) {
        String wcss = String.format(TAG_WIDTH, tag);
        css += wcss;
    }
}
