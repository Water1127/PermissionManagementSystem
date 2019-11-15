package cn.water.project.service;

import cn.water.project.dao.SysLogDao;
import cn.water.project.domain.SysLog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/8 - 15:00
 * @description
 */
@Service
@Transactional
public class SysLogServiceImp implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    /** 查询所有日志信息（展示） */
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    /** 查询所有用户信息（展示），并分页 */
    public List<SysLog> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return sysLogDao.findAll();
    }

    /** 添加新日志（添加） */
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }


}
