package cn.techoc.learnsatokendemo;

import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.mapper.RolesMapper;
import cn.techoc.learnsatokendemo.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LearnSaTokenDemoApplicationTests {

    @Resource
    private RolesMapper rolesMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<Roles> rolesList = userMapper.getRolesByUserId(1819256913841557505L);
        for (Roles roles : rolesList) {
            System.out.println(roles.getRoleName());
        }
        List<Permissions> permissionsList = rolesMapper.getPermissionsByRoleId(1819256913841557505L);
        for (Permissions permissions : permissionsList) {
            System.out.println(permissions.getPermissionName());
        }
    }

}
