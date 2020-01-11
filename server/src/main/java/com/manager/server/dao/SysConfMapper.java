package com.manager.server.dao;

import com.manager.server.entity.SysConf;
import java.util.List;

public interface SysConfMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_conf
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_conf
     *
     * @mbg.generated
     */
    int insert(SysConf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_conf
     *
     * @mbg.generated
     */
    SysConf selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_conf
     *
     * @mbg.generated
     */
    List<SysConf> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_conf
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysConf record);
}