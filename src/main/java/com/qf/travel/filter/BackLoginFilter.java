//package com.qf.travel.filter;
//
////import com.qf.entity.User;
//
//import com.qf.travel.entity.User;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class BackLoginFilter extends DefaultFilter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//        //1.获取session中的登录凭证
//        User user = (User)request.getSession().getAttribute("backUser");
//        String uri = request.getRequestURI();
//        System.out.println(uri);
//        String action = request.getParameter("action");
//        if(user != null || "backLogin".equals(action) || uri.contains("jquery") || "login".equals(action)){
//            filterChain.doFilter(request,response);
//        }else{
//            //转发和重定向会根据当前路径进行跳转
//            //response.sendRedirect("backLogin.jsp");
//            //request.getRequestDispatcher("backLogin.jsp").forward(request,response);
//
//            //获取项目的根目录
//            String contextPath = request.getContextPath();
//            response.getWriter().write("<script>window.open('"+contextPath+"/backLogin.jsp','_parent')</script>");
//        }
//    }
//}
