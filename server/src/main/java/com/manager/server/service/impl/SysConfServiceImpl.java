package com.manager.server.service.impl;

import com.manager.server.dao.SysConfMapper;
import com.manager.server.entity.SysConf;
import com.manager.server.service.SysConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysConfServiceImpl")
public class SysConfServiceImpl implements SysConfService {

    @Autowired
    private SysConfMapper sysConfMapper;

    @Override
    public String save(SysConf sysConf) {
        int insert = sysConfMapper.insert(sysConf);
        return insert > 0 ? insert + "" : null;
    }

    @Override
    public List<SysConf> list(SysConf sysConf) {
        List<SysConf> sysConfs = sysConfMapper.selectBySysConf(sysConf);
        return sysConfs;
    }
}
