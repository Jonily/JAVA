package main.java.frank.config;

import frank.model.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


//指定身份：拦截controller中web请求的类
@ControllerAdvice
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {

    //指定请求方法中抛出的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e){
        e.printStackTrace();
        return null;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //执行Controller中的veb请求方法结束，返回数据到前端的时候，是否要重写响应体

        return true;//如果为true进行下面的方法
    }

    @Override
    public ResponseResult beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果存在返回字符韦的情况，需要返回字符串类型，否则会报错
//解决方案:判断jbody对象的类型:如果是字符串，就返回objectmapper序列化后的字符串，否则返回统一封装的类型

        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setData(body);
        return r;
    }
}
