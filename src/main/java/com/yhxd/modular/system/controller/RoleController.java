package com.yhxd.modular.system.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/role")
@Api
public class RoleController {

    /**
     * 跳转到角色管理列表页
     * @return
     */
    @GetMapping(value = "/list")
    public String list() {
        return "mng/system/role_list";
    }
}
