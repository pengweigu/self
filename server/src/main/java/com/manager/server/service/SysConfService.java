package com.manager.server.service;

import com.manager.server.entity.SysConf;

import java.util.List;

public interface SysConfService {
    String save(SysConf sysConf);

    List<SysConf> list(SysConf sysConf);
}
