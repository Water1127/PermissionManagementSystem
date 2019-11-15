package cn.water.project.dao;

import cn.water.project.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 15:41
 * @description
 */
public interface PermissionDao {

    /** 根据RoleId，查询权限信息 */
    @Select("SELECT * FROM permission WHERE id IN (SELECT permissionId FROM role_permission WHERE roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId) throws Exception;

    /** 查询所有权限信息（展示） */
    @Select("SELECT * FROM permission")
    List<Permission> findAll() throws Exception;

    /** 添加新权限（添加） */
    @Insert("INSERT INTO permission(id,permissionName,url) VALUES(#{id},#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    /** 根据id，查询权限信息（详情） */
    @Select("SELECT * FROM permission WHERE id=#{id}")
    Permission findById(String id) throws Exception;

    /** 根据id，删除权限（删除） */
    @Delete("DELETE FROM permission WHERE id=#{permissionId}")
    void deletePermissionById(String permissionId);

}
