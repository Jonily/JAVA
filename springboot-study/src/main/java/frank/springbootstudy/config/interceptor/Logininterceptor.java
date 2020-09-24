package frank.springbootstudy.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import frank.springbootstudy.model.ResponseResult;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


/*
定义拦截器
只有配置的拦截路径匹配请求路径时，才会执行拦截器中的方法
 */
public class Logininterceptor implements HandlerInterceptor {
    private ObjectMapper objectMapper;
    public Logininterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*
        controller中请求方法执行前就调用preHandle，返回值决定是否继续执行Controller中的方法
        return true 继续执行 controller中方法
        return false 不执行

         */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        //登陆允许访问
        if(session != null && session.getAttribute("user") != null){
            return  true;
        }
        //没有登录，可以通过response对象，返回json数据，或者重定向到某个页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        ResponseResult r = new ResponseResult();
        r.setCode("ERR401");
        r.setMessage("用户未登录不允许访问");
        String json = objectMapper.writeValueAsString(r);//将java对象序列化json字符串
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
