package com.manager.server.service.impl;

import com.manager.server.dao.AdminUserMapper;
import com.manager.server.entity.AdminUser;
import com.manager.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public boolean reg(AdminUser adminUser) {
        int insert = adminUserMapper.insert(adminUser);
        return insert > 0;
    }

    @Override
    public boolean dologin(AdminUser adminUser) {
        List<AdminUser> adminUsers = adminUserMapper.selectByAdminUser(adminUser);
        return adminUsers.size() > 0;
    }
}
