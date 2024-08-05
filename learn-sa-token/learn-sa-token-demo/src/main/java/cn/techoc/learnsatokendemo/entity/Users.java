package cn.techoc.learnsatokendemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Users {
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
}
