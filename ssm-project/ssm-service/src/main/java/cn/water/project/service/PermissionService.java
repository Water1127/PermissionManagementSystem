package cn.water.project.service;

import cn.water.project.domain.Permission;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 17:05
 * @description
 */
public interface PermissionService {

    /** 查询所有权限信息（展示） */
    List<Permission> findAll() throws Exception;

    /** 查询所有权限信息（展示），并分页 */
    List<Permission> findAllByPage (int pageNum, int pageSize) throws Exception;

    /** 添加新权限（添加） */
    void save(Permission permission) throws Exception;

    /** 根据id，查询权限信息（详情） */
    Permission findById(String id) throws Exception;

    /** 根据id，删除单个权限（删除） */
    void deletePermissionById(String permissionId) throws Exception;

    /** 根据id，删除多个权限（删除） */
    void deletePermissionListById(String[] permissionIdList) throws Exception;

}
