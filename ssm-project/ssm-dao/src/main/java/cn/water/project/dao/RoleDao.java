package cn.water.project.dao;

import cn.water.project.domain.Permission;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author Water
 * @date 2019/11/5 - 10:43
 * @description
 */
public interface RoleDao {

    /** 根据UserId，查询角色信息 */
    @Select("SELECT * FROM role WHERE id IN ( SELECT roleId FROM users_role WHERE userId = #{userId} ) ")
    @Results(
        id = "roleMap",
        value = {@Result(id = true,property = "id",column = "id"),
                @Result(property = "roleName",column = "roleName"),
                @Result(property = "roleDesc",column = "roleDesc"),
                @Result(property = "permissions",
                        column = "id",
                        javaType = List.class,
                        many = @Many(select = "cn.water.project.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findByUserId(String userId) throws Exception;

    /** 查询所有角色信息（展示） */
    @Select("SELECT * FROM role")
    List<Role> findAll() throws Exception;

    /** 添加新角色（添加） */
    @Insert("INSERT INTO role(id,roleName,roleDesc) VALUES(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    /** 根据id，查询角色信息（详情） */
    @Select("SELECT * FROM role WHERE id=#{roleId}")
    @ResultMap("roleMap")
    Role findById(String roleId);

    /** 根据id，查询角色可以关联的权限（关联权限） */
    @Select("SELECT * FROM permission WHERE id NOT IN (SELECT permissionId FROM role_permission WHERE roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId) throws Exception;

    /** 添加角色和权限的关联（关联权限） */
    @Insert("INSERT INTO role_permission VALUES(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    /** 根据id，删除角色（删除） */
    @Delete("DELETE FROM role WHERE id=#{roleId}")
    void deleteRoleById(String roleId);

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);

}
