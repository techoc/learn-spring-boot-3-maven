package cn.techoc.learnsatokendemo.service.impl;

import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.entity.Users;
import cn.techoc.learnsatokendemo.mapper.PermissionsMapper;
import cn.techoc.learnsatokendemo.mapper.RolesMapper;
import cn.techoc.learnsatokendemo.mapper.UserMapper;
import cn.techoc.learnsatokendemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RolesMapper rolesMapper;

    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    public List<Roles> getRolesByUserId(Long userId) {
        return userMapper.getRolesByUserId(userId);
    }

    @Override
    public List<Permissions> getPermissionsByRoleId(Long roleId) {
        return rolesMapper.getPermissionsByRoleId(roleId);
    }
}
