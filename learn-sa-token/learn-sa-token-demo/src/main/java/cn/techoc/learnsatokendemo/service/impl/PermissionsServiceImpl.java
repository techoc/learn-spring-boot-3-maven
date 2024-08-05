package cn.techoc.learnsatokendemo.service.impl;

import cn.techoc.learnsatokendemo.entity.Permissions;
import cn.techoc.learnsatokendemo.mapper.PermissionsMapper;
import cn.techoc.learnsatokendemo.service.PermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements PermissionsService {
}
