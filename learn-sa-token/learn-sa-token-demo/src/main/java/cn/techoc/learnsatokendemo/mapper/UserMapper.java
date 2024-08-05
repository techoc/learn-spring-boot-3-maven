package cn.techoc.learnsatokendemo.mapper;

import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Users> {

    @Select("select * from `sa-token`.UserRoles left join `sa-token`.Roles R on R.role_id = UserRoles.role_id where user_id = #{userId}")
    List<Roles> getRolesByUserId(Long userId);
}
