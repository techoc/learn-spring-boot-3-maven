package cn.techoc.springsecuritydemorole.controller;

import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private AuthenticationManager authenticationManager;

    @PermitAll
    @GetMapping("/echo")
    public String demo() {
        return "示例返回";
    }

    @PreAuthorize("hasPermission('home')")
    @GetMapping("/home")
    public String home() {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin", "admin"));
        return "我是首页";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "我是管理员";
    }

    @PreAuthorize("hasRole('ROLE_NORMAL')")
    @GetMapping("/normal")
    public String normal() {
        return "我是普通用户";
    }
}
