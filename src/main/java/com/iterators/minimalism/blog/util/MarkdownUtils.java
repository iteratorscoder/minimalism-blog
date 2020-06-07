package com.iterators.minimalism.blog.util;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 参考 {@link https://www.jianshu.com/p/cb21b4accdd9}
 * @author iterators
 * @time 2020.06.06
 */
public class MarkdownUtils {

    public static String mdToHtml(InputStream inputStream) {
        String htmlStr = "";
        try {
            String mdContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
            htmlStr = mdToHtml(mdContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlStr;
    }

    public static String mdToHtml(String mdContent) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(mdContent);
        return renderer.render(document);
    }

}
