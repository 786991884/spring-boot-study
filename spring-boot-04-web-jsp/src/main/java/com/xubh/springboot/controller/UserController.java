package com.xubh.springboot.controller;

import com.xubh.springboot.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * SpringBoot整合jsp
 */
@Controller
public class UserController {
    /**
     * 处理请求，产生数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model) {
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "张三", 20));
        list.add(new Users(2, "李四", 22));
        list.add(new Users(3, "王五", 24));

        //需要一个Model对象
        model.addAttribute("list", list);
        //跳转视图
        return "userList";
    }
}
