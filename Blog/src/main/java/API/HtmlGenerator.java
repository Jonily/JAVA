package API;

import model.Article;
import model.User;

import java.util.List;

public class HtmlGenerator {
    //通过字符串拼接的格式，构造出一个html格式的内容
    //下面的代码实现是将html嵌入到java代码中
    //实际开发
    //1、服务器渲染页面，把业务代码嵌入到html（jsp，php）
    //2、服务器渲染页面，把html嵌入到业务代码中，不使用字符串拼接的方式，
    //而是使用模板的方法（FreeMarker）
    //3、前端渲染页面，通过前后端分离的方式，服务器只是返回简单数据，由前端代码通过js
    //构造页面内容（主流）
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset = \"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");
        stringBuilder.append(String.format("<a href=\"%s\">点击这里进行跳转 </a>",
                nextUrl));


        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();



    }

    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset = \"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        //css
        stringBuilder.append("a{"+
                "color: #333;"+
                "text-decoration: none;"+
                "}");
        stringBuilder.append("a:hover {"+
                "color: white;"+
                "background-color: orange"+
                "}");

        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3> 欢迎您！ "+ user.getName()+"</h3>");
        stringBuilder.append("<hr>");

        //要有一个文章列表，显示每个文章的标题
        for (Article a : articles) {
            stringBuilder.append(String.format("<div style=\"width: 200px; height:50px\"> <a href=\"article?articleId=%d\"> %s </a></div>))",
                    a.getArticleId(),a.getTitle()));
        }
        stringBuilder.append("<hr>");

        stringBuilder.append(String.format("<div> 当前共有博客 %d 篇</div>))", articles.size()));


        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetailPage(Article article, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset = \"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        //css
        stringBuilder.append("a{"+
                "color: #333;"+
                "text-decoration: none;"+
                "}");
        stringBuilder.append("a:hover {"+
                "color: white;"+
                "background-color: orange"+
                "}");

        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3> 欢迎您！ "+ user.getName()+"</h3>");
        stringBuilder.append("<hr>");

        stringBuilder.append(String.format("<h1>%s</h1>",article.getTitle()));
        stringBuilder.append(String.format("<h4>%d</h4>",article.getUserId()));
        stringBuilder.append(String.format("<div>%s</div>",article.getContent()));



        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();

    }
}
