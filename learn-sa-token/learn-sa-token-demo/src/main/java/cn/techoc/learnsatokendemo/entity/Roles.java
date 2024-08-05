package cn.techoc.learnsatokendemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Roles {
    @TableId(type = IdType.ASSIGN_ID)
    private Long roleId;
    private String roleName;
    private LocalDateTime createdAt;
}
