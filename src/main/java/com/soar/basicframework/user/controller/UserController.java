package com.soar.basicframework.user.controller;

import com.soar.basicframework.user.model.User;
import com.soar.basicframework.user.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * user控制器demo
 * @author Soar
 * @date 2018/4/21
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("getuser")
    public Object getUser() {
        User user = new User();
        List<User> userList = userService.getList(user);
        return userList;
    }
}
