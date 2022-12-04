package io.michlangner.webfiltersdemo.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
@Order(Integer.MIN_VALUE)
public class MyFilter implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info(SecurityContextHolder.getContext().toString());
        filterChain.doFilter(servletRequest,servletResponse);


    }
}
