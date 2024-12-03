package xiyu1296.tlias.filter;


import com.alibaba.fastjson2.JSON;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import xiyu1296.tlias.pojo.Result;
import xiyu1296.tlias.utils.jwtutils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/")
public class loginfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletRequest;

        String url = request.getRequestURI();
        log.info("拦截请求：{}",url);

        if(url.contains("login")) {
            filterChain.doFilter(request,response);
            log.info("放行请求：{}",url);
            return;
        }

        String jwt = request.getHeader("token");

        if(!StringUtils.hasText(jwt)){
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSON.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }

        try {
            jwtutils.parseJwt(jwt);
        } catch (Exception e) {
            log.info("解析失败");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSON.toJSONString(error);
            response.getWriter().write(notlogin);
        }

        log.info("放行请求：{}",url);
        filterChain.doFilter(request,response);
        return;

    }
}
