package com.manager.server.api;

import com.manager.server.entity.AdminUser;
import com.manager.server.enums.EnumAdminUserStatus;
import com.manager.server.response.BaseResult;
import com.manager.server.response.admin.AdminBaseResult;
import com.manager.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台用户api
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserApi {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test.json")
    @ResponseBody
    public String test(){
        return "OK";
    }

    @RequestMapping("/dologin.json")
    @ResponseBody
    public BaseResult adminUserDoLogin(@RequestBody @Validated AdminUser adminUser, BindingResult bindingResult){
        AdminBaseResult result = new AdminBaseResult();
        if(bindingResult.hasErrors()){
            result.setIsSuccess("false");
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            result.setMsgInfo(fieldError.getField() + fieldError.getDefaultMessage());
            return result;
        }
        boolean login = adminService.dologin(adminUser);
        result.setIsSuccess(login+"");
        return result;
    }



    @RequestMapping("/reg.json")
    @ResponseBody
    public BaseResult adminUserReg(@RequestBody @Validated AdminUser adminUser, BindingResult bindingResult){
        AdminBaseResult result = new AdminBaseResult();
        if(bindingResult.hasErrors()){
            result.setIsSuccess("false");
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            result.setMsgInfo(fieldError.getField() + fieldError.getDefaultMessage());
            return result;
        }
        adminUser.setStatus(EnumAdminUserStatus.NORMAL.getValue());
        boolean reg = adminService.reg(adminUser);
        result.setIsSuccess(reg+"");
        return result;
    }

}
