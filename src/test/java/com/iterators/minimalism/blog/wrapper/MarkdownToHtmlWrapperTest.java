package com.iterators.minimalism.blog.wrapper;

import com.iterators.minimalism.blog.entity.MarkdownEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownToHtmlWrapperTest {

    @Test
    void ofContent() {
        String content = "Markdown cells support standard Markdown syntax as well as GitHub Flavored Markdown (GFM). Open the preview to see these rendered.\n" +
                "\n" +
                "### Basics\n" +
                "\n" +
                "# H1\n" +
                "## H2\n" +
                "### H3\n" +
                "#### H4\n" +
                "##### H5\n" +
                "###### H6\n" +
                "\n" +
                "---\n" +
                "\n" +
                "*italic*, **bold**, ~~Scratch this.~~\n" +
                "\n" +
                "`inline code`\n" +
                "\n" +
                "### Lists\n" +
                "\n" +
                "1. First ordered list item\n" +
                "2. Another item\n" +
                "  * Unordered sub-list. \n" +
                "1. Actual numbers don't matter, just that it's a number\n" +
                "  1. Ordered sub-list\n" +
                "4. And another item.\n" +
                "\n" +
                "### Quote\n" +
                "\n" +
                "> Peace cannot be kept by force; it can only be achieved by understanding.\n" +
                "\n" +
                "### Links\n" +
                "\n" +
                "[I'm an inline-style link](https://www.google.com)\n" +
                "http://example.com\n" +
                "\n" +
                "You can also create a link to another note: (Note menu -> Copy Note Link -> Paste)\n" +
                "[01 - Getting Started](quiver-note-url/D2A1CC36-CC97-4701-A895-EFC98EF47026)\n" +
                "\n" +
                "### Tables\n" +
                "\n" +
                "| Tables        | Are           | Cool  |\n" +
                "| ------------- |:-------------:| -----:|\n" +
                "| col 3 is      | right-aligned | $1600 |\n" +
                "| col 2 is      | centered      |   $12 |\n" +
                "| zebra stripes | are neat      |    $1 |\n" +
                "\n" +
                "### GFM Task Lists\n" +
                "\n" +
                "- [ ] a task list item\n" +
                "- [ ] list syntax required\n" +
                "- [ ] normal **formatting**, @mentions, #1234 refs\n" +
                "- [ ] incomplete\n" +
                "- [x] completed\n" +
                "\n" +
                "### Inline LaTeX\n" +
                "\n" +
                "You can use inline LaTeX inside Markdown cells as well, for example, $x^2$.";
        MarkdownEntity entity = MarkdownToHtmlWrapper.ofContent(content);
        System.out.println(entity);
    }
}