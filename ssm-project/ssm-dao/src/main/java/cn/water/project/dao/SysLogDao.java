package cn.water.project.dao;

import cn.water.project.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/8 - 15:03
 * @description
 */
public interface SysLogDao {

    /** 查询所有日志信息（展示） */
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    /** 添加新日志（添加） */
    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;

}
