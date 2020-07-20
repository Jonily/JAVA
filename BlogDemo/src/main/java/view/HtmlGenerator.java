package view;

import model.Article;
import model.User;

import java.util.List;

public class HtmlGenerator {
    // 通过字符串拼接的形式, 构造出一个 html 格式的内容来.
    // 下面的代码实现起来非常麻烦. (HTML 嵌入到 Java 代码中)
    // 如果页面简单还好, 如果页面复杂, 那就非常不好整了.
    // 课堂上使用这种写法, 代码简单粗暴(不需要引入新的知识的)
    // 实际开发中还有更科学的写法:
    // 1. 服务器渲染页面, 把业务代码嵌入到 HTML (JSP, PHP);
    // 2. 服务器渲染页面, 把 HTML 嵌入到业务代码中, 不使用字符串拼接的方式,
    //    而是使用模板的方式. (FreeMarker)
    // 3. 前端渲染页面, 通过前后端分离的方式, 服务器只是返回简单数据, 由前端代码同过 JS
    //    构造页面内容. [主流]
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");

        stringBuilder.append(String.format("<a href=\"%s\"> 点击这里进行跳转 </a>",
                nextUrl));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    // 按照字符串拼装的方式, 生成 html
    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        // style 标签内部就是写 CSS 的逻辑
        stringBuilder.append(".article {" +
                "color: #333;" +
                "text-decoration: none;" +
//                "display: inline-block;" +
                "width: 200px;" +
                "height: 50px;" +
                "}");
        stringBuilder.append(".article:hover {" +
                "color: white;" +
                "background-color: orange;" +
                "}");
        stringBuilder.append("body {" +
                "background-repeat: none;" +
                "background-position: 0 center;" +
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3> 欢迎您! " + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        // 要有一个文章列表. 显示每个文章的标题.
        for (Article article : articles) {
            stringBuilder.append(String.format("<div style=\"width: 200px; height: 50px; line-height: 50px\"> <a class=\"article\" href=\"article?articleId=%d\"> %s </a>" +
                            "<a href=\"deleteArticle?articleId=%d\"> 删除 </a></div>",
                    article.getArticleId(), article.getTitle(), article.getArticleId()));
        }
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<div>当前共有博客 %d 篇</div>", articles.size()));

        // 在这里新增发布文章的区域
        stringBuilder.append("<div> 发布文章 </div>");
        stringBuilder.append("<div>");
        stringBuilder.append("<form method=\"post\" action=\"article\">");
        stringBuilder.append("<input type=\"text\" style=\"width: 500px; margin-bottom: 5px;\" name=\"title\" placeholder=\"请输入标题\">");
        stringBuilder.append("<br>");
        stringBuilder.append("<textarea name=\"content\" style=\"width: 500px; height: 300px;\"></textarea>");
        stringBuilder.append("<br>");
        stringBuilder.append("<input type=\"submit\" value=\"发布文章\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</div>");

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetailPage(Article article, User user, User author) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        // style 标签内部就是写 CSS 的逻辑
        stringBuilder.append("a {" +
                "color: #333;" +
                "text-decoration: none;" +
                "display: inline-block;" +
                "width: 200px;" +
                "height: 50px;" +
                "}");
        stringBuilder.append("a:hover {" +
                "color: white;" +
                "background-color: orange;" +
                "}");
        stringBuilder.append("body {" +
                "background-repeat: none;" +
                "background-position: 0 center;" +
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3> 欢迎您! " + user.getName() + "</h3>");
        stringBuilder.append("<hr>");

        stringBuilder.append(String.format("<h1>%s</h1>", article.getTitle()));
        stringBuilder.append(String.format("<h4>作者: %s</h4>", author.getName()));
        // 构造正文的地方.
        // HTML 中本来就不是用 \n 表示换行的.
        stringBuilder.append(String.format("<div>%s</div>", article.getContent()
                .replace("\n", "<br>")));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
