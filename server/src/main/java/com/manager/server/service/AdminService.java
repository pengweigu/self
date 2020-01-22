package com.manager.server.service;

import com.manager.server.entity.AdminUser;

import java.util.List;

public interface AdminService {

    /**
     * 注册用户
     * @param adminUser
     * @return
     */
    boolean reg(AdminUser adminUser);

    /**
     * 登录
     * @param adminUser
     * @return
     */
    boolean dologin(AdminUser adminUser);

    /**
     * 列表信息查询
     * @param adminUser
     * @return
     */
    List<AdminUser> adminUserList(AdminUser adminUser);

    /**
     * 用户删除
     * @param adminUser
     * @return
     */
    int adminUserDelete(AdminUser adminUser);
}
