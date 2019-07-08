//package com.qf.travel.filter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//
//public class EncodingFilter extends DefaultFilter{
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
//       req.setCharacterEncoding("UTF-8");
//       resp.setContentType("text/html; charset=UTF-8");
//       filterChain.doFilter(req,resp);
//    }
//}
