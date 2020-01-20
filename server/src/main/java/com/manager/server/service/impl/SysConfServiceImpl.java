package com.manager.server.service.impl;

import com.manager.server.dao.SysConfMapper;
import com.manager.server.entity.SysConf;
import com.manager.server.service.SysConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysConfServiceImpl")
public class SysConfServiceImpl implements SysConfService {

    @Autowired
    private SysConfMapper sysConfMapper;

    @Override
    public String save(SysConf sysConf) {
        int insert = sysConfMapper.insert(sysConf);
        return insert + "";
    }
}
