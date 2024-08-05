package cn.techoc.learnsatokendemo.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permissions")
public class PermissionsController {

    @GetMapping("/admin/add")
    public String adminAdd() {
        StpUtil.checkPermission("admin.add");
        return "admin.add";
    }

    @SaCheckPermission("normal.add")
    @GetMapping("/normal/add")
    public String normalAdd() {
        return "normal.add";
    }
}
