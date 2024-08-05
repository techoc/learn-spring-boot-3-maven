package cn.techoc.learnsatokendemo.service;

import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<Users> {

    List<Roles> getRolesByUserId(Long userId);

    List<Permissions> getPermissionsByRoleId(Long roleId);
}
