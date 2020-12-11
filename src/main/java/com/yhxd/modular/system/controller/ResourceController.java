package com.yhxd.modular.system.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/res")
@Api
public class ResourceController {

    /**
     * 跳转到资源管理列表页
     * @return
     */
    @GetMapping(value = "/list")
    public String list() {
        return "mng/system/res_list";
    }
}
