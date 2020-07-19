package API;

import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {
    //浏览器是通过POST方法提交注册信息给服务器的

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset-utf-8");
        //1、验证用户是否已经登陆了，如果未登录，就提示用户要先登录
        HttpSession httpSession = req.getSession(false);
        if(httpSession == null){
            //当前是未登录状态
            String html = HtmlGenerator.getMessagePage("请先登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(name == null || "".equals(name)
        || password == null || "".equals(password)){
            //用户提交的数据有误
            //返回一个错误页面（一段字符串，html构成得到）
            String html  = HtmlGenerator.getMessagePage("用户名或者密码为空","register.html");
            resp.getWriter().write(html);
        }
        //2、判断请求中是否存在articleId参数
        String articleIdStr = req.getParameter("articleId");
        if(articleIdStr == null){
            //  a）没有这个参数就去执行文章列表操作
            getAllArticle(user,resp);

        }else {
            //   b）有这个参数就去执行获取文章详情操作
            getOneArticle(Integer.parseInt(articleIdStr),user,resp);

        }


    }

    private void getOneArticle(int articleId, User user, HttpServletResponse resp) throws IOException {
        //1、查找数据库
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if(article == null){
            //文章未找到
            String html = HtmlGenerator.getMessagePage("文章不存在",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        //2、构造页面
        String html  = HtmlGenerator.getArticleDetailPage(article,user);
        resp.getWriter().write(html);
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        //1、查找数据库
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        //2、构造页面
        String html = HtmlGenerator.getArticleListPage(articles,user);
        resp.getWriter().write(html);

    }
    //实现新增文章的逻辑

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset-utf-8");
        req.setCharacterEncoding("utf-8");

        //1、判定用户的登陆状态，如果用户尚未登陆，就提示用户来登录
        HttpSession httpSession = req.getSession(false);
        if(httpSession == null){
            String html = HtmlGenerator.getMessagePage("您尚未登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //2、从请求中读取浏览器提交的数据（title，content），进行简单校验
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title == null || "".equals(title)
                || content == null || "".equals(content)){
            //返回一个错误页面（一段字符串，html构成得到）
            String html  = HtmlGenerator.getMessagePage("提交的标题或正文为空",
                    "article");
            resp.getWriter().write(html);
            return;
        }

        // 3. 把数据插入到数据库中.
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent( content) ;
        article.setUserId(user.getUseId());
        articleDao. add(article);
//4.返回一个插入成功的页面。
        String html = HtmlGenerator.getMessagePage( "发布成功!”",
                "article" );
        resp.getWriter( ).write(html);
        return;


    }
}
