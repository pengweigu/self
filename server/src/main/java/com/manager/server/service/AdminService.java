package com.manager.server.service;

import com.manager.server.entity.AdminUser;

public interface AdminService {

    boolean reg(AdminUser adminUser);

    boolean dologin(AdminUser adminUser);
}
