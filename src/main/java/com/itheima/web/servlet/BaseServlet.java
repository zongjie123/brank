package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换HttpServlet,根据请求的最后一段路径来进行方法分发
 */

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
        //1.获取请求数据
        String uri = req.getRequestURI();// /brand/brand/selectAll
//        System.out.println(uri);

        //2.获取最后一段路径 方法名
        int index=uri.lastIndexOf("/");//从右边开始数 第一次出现/
        String methodName = uri.substring(index+1);

//        System.out.println(methodName);
        //2.执行方法
        //2.1执行BrandServlet /UserServlet字节码对象class
        //
//        System.out.println(this);
        Class<? extends BaseServlet> cls = this.getClass();


        //2.2获取方法Method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        //2.3执行方法
            method.invoke(this,req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
