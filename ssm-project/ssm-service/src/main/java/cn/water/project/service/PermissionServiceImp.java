package cn.water.project.service;

import cn.water.project.dao.PermissionDao;
import cn.water.project.domain.Permission;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 17:05
 * @description
 */
@Service
@Transactional
public class PermissionServiceImp implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /** 查询所有权限信息（展示） */
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /** 查询所有权限信息（展示），并分页 */
    public List<Permission> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return permissionDao.findAll();
    }


    /** 添加新权限（添加） */
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    /** 根据id，查询权限信息（详情） */
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }


    /** 根据id，删除单个用户（删除） */
    public void deletePermissionById(String permissionId) throws Exception{
        permissionDao.deletePermissionById(permissionId);
    }

    /** 根据id，删除多个用户（删除） */
    public void deletePermissionListById(String[] permissionIdList) throws Exception{
        for (String permissionId : permissionIdList) {
            permissionDao.deletePermissionById(permissionId);
        }
    }



}
