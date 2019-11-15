package cn.water.project.service;

import cn.water.project.domain.Permission;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 17:04
 * @description
 */
public interface RoleService {

    /** 查询所有角色信息（展示） */
    List<Role> findAll() throws Exception;

    /** 查询所有角色信息（展示），并分页 */
    List<Role> findAllByPage (int pageNum, int pageSize) throws Exception;

    /** 添加新角色（添加） */
    void save(Role role);

    /** 根据id，查询角色信息（详情） */
    Role findById(String roleId);

    /** 根据id，查询角色可以关联的权限（关联权限） */
    List<Permission> findOtherPermission(String roleId) throws Exception;

    /** 添加角色和权限的关联（关联权限） */
    void addPermissionToRole(String roleId,String[] permissionIdList) throws Exception;

    /** 根据id，删除单个角色（删除） */
    void deleteRoleById(String roleId);

    /** 根据id，删除多个角色（删除） */
    void deleteRoleListById(String[] roleIdList);


}
