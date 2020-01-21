package com.manager.server.api.admin;

import com.manager.server.entity.SysConf;
import com.manager.server.enums.EnumSysConfCode;
import com.manager.server.response.BaseResult;
import com.manager.server.response.admin.AdminBaseResult;
import com.manager.server.service.SysConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统配置api
 */
@RestController
@RequestMapping("/admin/sys")
public class AdminSysConfApi {

    @Autowired
    private SysConfService sysConfService;

    /**
     * 配置信息列表查询
     * @param sysConf
     * @return
     */
    @RequestMapping("/list.json")
    @ResponseBody
    public BaseResult sysConfList(@RequestBody SysConf sysConf){
        AdminBaseResult<SysConf> result = new AdminBaseResult();
        List<SysConf> sysConfs = sysConfService.list(sysConf);
        result.setItems(sysConfs);
        result.setIsSuccess((sysConfs.size()>0)+"");
        return result;
    }

    /**
     * 获取跑马灯配置
     * @param sysConf
     * @return
     */
    @RequestMapping("/carousel.json")
    @ResponseBody
    public BaseResult carousel(@RequestBody SysConf sysConf){
        AdminBaseResult<SysConf> result = new AdminBaseResult();
        sysConf.setCode(EnumSysConfCode.CAROUSEL.getCode());
        List<SysConf> sysConfs = sysConfService.list(sysConf);
        if(sysConfs.size()>0){
            result.setObj(sysConfs.get(0));
            result.setIsSuccess("true");
        }else{
            result.setIsSuccess("false");
        }
        return result;
    }

    /**
     * 配置信息新增
     * @param sysConf
     * @return
     */
    @RequestMapping("/save.json")
    @ResponseBody
    public BaseResult sysConfSave(@RequestBody SysConf sysConf){
        AdminBaseResult<SysConf> result = new AdminBaseResult();
        String id = sysConfService.save(sysConf);
        result.setIsSuccess(!StringUtils.isEmpty(id) +"");
        return result;
    }


}
