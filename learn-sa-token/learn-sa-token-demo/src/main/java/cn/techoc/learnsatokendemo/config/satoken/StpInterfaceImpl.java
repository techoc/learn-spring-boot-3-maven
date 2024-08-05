package cn.techoc.learnsatokendemo.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.service.PermissionsService;
import cn.techoc.learnsatokendemo.service.RolesService;
import cn.techoc.learnsatokendemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserService userService;

    @Resource
    private RolesService rolesService;

    @Resource
    private PermissionsService permissionsService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String loginIdStr = loginId.toString();
        List<String> permissionsList = new ArrayList<>();
        List<Roles> rolesList = userService.getRolesByUserId(Long.valueOf(loginIdStr));
        if (rolesList == null) {
            return null;
        }
        for (Roles roles : rolesList) {
            List<Permissions> permissions = userService.getPermissionsByRoleId(roles.getRoleId());
            if (permissions != null) {
                permissions.forEach(p -> {
                    permissionsList.add(p.getPermissionName());
                });
            }
        }
        return permissionsList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> RoleList = new ArrayList<>();
        List<Roles> rolesList = userService.getRolesByUserId((Long) loginId);
        if (rolesList != null) {
            rolesList.forEach(r -> {
                RoleList.add(r.getRoleName());
            });
            return RoleList;
        }
        return null;
    }
}
