-- 创建用户
INSERT INTO `sa-token`.Users (user_id, username, password)
VALUES (1819256834577600514, 'normal', 'normal');
INSERT INTO `sa-token`.Users (user_id, username, password)
VALUES (1819256913841557505, 'admin', 'admin');
INSERT INTO `sa-token`.Users (user_id, username, password)
VALUES (1819258860669702146, 'ghost', 'ghost');

-- 创建角色
INSERT INTO `sa-token`.Roles (role_id, role_name)
VALUES (1819256834577600514, 'normal');
INSERT INTO `sa-token`.Roles (role_id, role_name)
VALUES (1819256913841557505, 'admin');
INSERT INTO `sa-token`.Roles (role_id, role_name)
VALUES (1819258860669702146, 'ghost');

-- 创建权限
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557505, 'admin.add');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557506, 'admin.delete');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557507, 'admin.update');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557509, 'admin.read');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557510, 'normal.add');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557511, 'normal.delete');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557512, 'normal.update');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557513, 'normal.read');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557514, 'ghost.add');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557515, 'ghost.delete');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557516, 'ghost.update');
INSERT INTO `sa-token`.Permissions (permission_id, permission_name)
VALUES (1819256913841557517, 'ghost.read');

-- 创建用户与角色关联
INSERT INTO `sa-token`.UserRoles (user_id, role_id)
VALUES (1819256834577600514, 1819256834577600514);
INSERT INTO `sa-token`.UserRoles (user_id, role_id)
VALUES (1819256913841557505, 1819256913841557505);
INSERT INTO `sa-token`.UserRoles (user_id, role_id)
VALUES (1819258860669702146, 1819258860669702146);

-- 创建角色与权限关联
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256913841557505, 1819256913841557505);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256913841557505, 1819256913841557506);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256913841557505, 1819256913841557507);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256913841557505, 1819256913841557509);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256834577600514, 1819256913841557510);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256834577600514, 1819256913841557511);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256834577600514, 1819256913841557512);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819256834577600514, 1819256913841557513);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819258860669702146, 1819256913841557514);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819258860669702146, 1819256913841557515);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819258860669702146, 1819256913841557516);
INSERT INTO `sa-token`.RolePermissions (role_id, permission_id)
VALUES (1819258860669702146, 1819256913841557517);
