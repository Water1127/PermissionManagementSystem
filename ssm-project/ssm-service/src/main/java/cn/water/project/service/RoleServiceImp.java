package cn.water.project.service;

import cn.water.project.dao.RoleDao;
import cn.water.project.domain.Permission;
import cn.water.project.domain.Role;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 17:04
 * @description
 */
@Service
@Transactional
public class RoleServiceImp implements RoleService{

    @Autowired
    private RoleDao roleDao;

    /** 查询所有角色信息（展示） */
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /** 查询所有角色信息（展示），并分页 */
    public List<Role> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return roleDao.findAll();
    }

    /** 添加新角色（添加） */
    public void save(Role role) {
        roleDao.save(role);
    }

    /** 根据id，查询角色信息（详情） */
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    /** 根据id，查询角色可以关联的权限（关联权限） */
    public List<Permission> findOtherPermission(String roleId) throws Exception{
        return roleDao.findOtherPermission(roleId);
    }

    /** 添加角色和权限的关联（关联权限） */
    public void addPermissionToRole(String roleId,String[] permissionIdList) throws Exception{
        for (String permission : permissionIdList) {
            roleDao.addPermissionToRole(roleId,permission);
        }
    }

    /** 根据id，删除单个角色（删除） */
    public void deleteRoleById(String roleId){
        roleDao.deleteRoleById(roleId);
    }

    /** 根据id，删除多个角色（删除） */
    public void deleteRoleListById(String[] roleIdList){
        for (String roleId : roleIdList) {
            roleDao.deleteRoleById(roleId);
        }
    }


}
