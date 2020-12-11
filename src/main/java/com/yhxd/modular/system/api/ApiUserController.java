package com.yhxd.modular.system.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/user")
@Api
public class ApiUserController {

    @GetMapping(value = "/index")
    public String list() {
        return "web/index";
    }
}
