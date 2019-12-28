package com.manager.server.service;

import com.manager.server.entity.AdminUser;

import java.util.List;

public interface AdminService {

    boolean reg(AdminUser adminUser);

    boolean dologin(AdminUser adminUser);

    List<AdminUser> adminUserList(AdminUser adminUser);
}
