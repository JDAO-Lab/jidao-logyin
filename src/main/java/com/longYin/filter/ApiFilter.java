package com.longYin.filter;

import com.longYin.utils.PrintUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * api请求过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/api/*")
public class ApiFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintUtils.print("放行Api~");
        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }
}
