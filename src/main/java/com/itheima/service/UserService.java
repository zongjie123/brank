package com.itheima.service;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserService {
     /**
      * 登录方法
      * @param username
      * @param password
      * @return
      */
     User login(String username, String password);
     /**
      * 注册方法
      * @return
      */

     boolean register(User user);
}
