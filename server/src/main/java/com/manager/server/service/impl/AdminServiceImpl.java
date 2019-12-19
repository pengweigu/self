package com.manager.server.service.impl;

import com.manager.server.dao.AdminUserMapper;
import com.manager.server.entity.AdminUser;
import com.manager.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminUserMapper adminUserMapper;

}
