package cn.techoc.learnsatokendemo.service.impl;

import cn.techoc.learnsatokendemo.entity.Roles;
import cn.techoc.learnsatokendemo.mapper.RolesMapper;
import cn.techoc.learnsatokendemo.service.RolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements RolesService {
}
