-- 如果数据库存在，则先删除数据库
drop database if exists `sa-token`;

-- 创建数据库
create database `sa-token` character set utf8mb4 collate utf8mb4_unicode_ci;

-- 选择数据库
use `sa-token`;

-- 创建用户表
CREATE TABLE Users
(
    user_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 创建角色表
CREATE TABLE Roles
(
    role_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name  VARCHAR(50) NOT NULL UNIQUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 创建权限表
CREATE TABLE Permissions
(
    permission_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    permission_name VARCHAR(50) NOT NULL UNIQUE,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 创建用户角色关联表
CREATE TABLE UserRoles
(
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Roles (role_id) ON DELETE CASCADE
);

-- 创建角色权限关联表
CREATE TABLE RolePermissions
(
    role_id       BIGINT,
    permission_id BIGINT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES Roles (role_id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES Permissions (permission_id) ON DELETE CASCADE
);