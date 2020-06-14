package com.tooyi.swagger.controller;

import com.tooyi.swagger.model.UserModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ceated by tooyi on 20/6/14 08:58
 */

@RestController
public class HelloController {

    @ApiOperation("hello控制类")
    @GetMapping("/hello")
    public String hello() {
        return "Hello Word";
    }

    // 接口中返回值是实体类，就会被swagger扫描到
    @ApiOperation("用户控制类")
    @PostMapping("/user")
    public UserModel user(UserModel userModel) {
        return userModel;
    }
}
