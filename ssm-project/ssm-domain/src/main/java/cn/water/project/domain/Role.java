package cn.water.project.domain;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/4 - 19:21
 * @description
 */
public class Role {

    /** 成员变量 */
    private String id; // 主键
    private String roleName; // 角色名称
    private String roleDesc; // 角色描述
    private List<Permission> permissions; // 【权限】：多对多
    private List<UserInfo> users; // 【用户】：多对多

    /** 设值函数 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
