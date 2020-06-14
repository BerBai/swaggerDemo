package com.tooyi.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Ceated by tooyi on 20/6/14 13:46
 */
@ApiModel("用户实体类")
public class UserModel {
    @ApiModelProperty("用户名")
    public String name;
    @ApiModelProperty("密码")
    public String password;

    UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
