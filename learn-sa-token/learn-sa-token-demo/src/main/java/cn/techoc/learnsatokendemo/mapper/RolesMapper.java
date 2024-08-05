package cn.techoc.learnsatokendemo.mapper;

import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.entity.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolesMapper extends BaseMapper<Roles> {

    @Select("select P.* from `sa-token`.RolePermissions left join `sa-token`.Permissions P on P.permission_id = RolePermissions.permission_id where role_id = #{roleId}")
    List<Permissions> getPermissionsByRoleId(Long roleId);
}
