package cn.techoc.learnsatokendemo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.techoc.learnsatokendemo.entity.Users;
import cn.techoc.learnsatokendemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        Users user = userService.getOne(new LambdaQueryWrapper<Users>().eq(Users::getUsername, username).eq(Users::getPassword, password));
        if (user != null) {
            StpUtil.login(user.getUserId());
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin() + "会话id为 " + StpUtil.getLoginId();
    }
}
