package cn.techoc.learnsatokendemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Permissions {
    @TableId(type = IdType.ASSIGN_ID)
    private Long permissionId;
    private String permissionName;
    private LocalDateTime createdAt;
}
