package cn.water.project.service;

import cn.water.project.domain.SysLog;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/8 - 15:00
 * @description
 */
public interface SysLogService {

    /** 查询所有日志信息（展示） */
    List<SysLog> findAll() throws Exception;

    /** 查询所有用户信息（展示），并分页 */
    List<SysLog> findAllByPage (int pageNum, int pageSize) throws Exception;

    /** 添加新日志（添加） */
    void save(SysLog sysLog) throws Exception;

}
