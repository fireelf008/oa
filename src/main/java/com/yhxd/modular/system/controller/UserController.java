package com.yhxd.modular.system.controller;

import com.yhxd.modular.system.entity.Resource;
import com.yhxd.modular.system.entity.User;
import com.yhxd.modular.system.service.UserService;
import com.yhxd.modular.system.vo.ResultVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@Api
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    @PostMapping(value = "/loginVali")
    @ResponseBody
    public ResultVo loginVali(HttpSession session, HttpServletRequest request, String username, String pwd) {

        try {
            // 添加用户认证信息
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, pwd);
            SecurityUtils.getSubject().login(usernamePasswordToken);
            User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
            session.setAttribute("user", user);
            List<Resource> resourceList = this.userService.loadResource(user);
            session.setAttribute("menu", resourceList);
            return ResultVo.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 登出
     * @return
     */
    @GetMapping(value = "/logout")
    @ResponseBody
    public ResultVo logout() {
        try {
            SecurityUtils.getSubject().logout();

            return ResultVo.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 跳转到后台首页
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return "mng/index";
    }

    /**
     * 跳转到用户管理列表页
     * @return
     */
    @GetMapping(value = "/list")
    public String list() {
        return "mng/system/user_list";
    }
}
