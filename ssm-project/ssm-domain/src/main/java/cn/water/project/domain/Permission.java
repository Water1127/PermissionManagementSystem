package cn.water.project.domain;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/4 - 19:22
 * @description
 */
public class Permission {

    /** 成员变量 */
    private String id; // 主键
    private String permissionName; // 权限名称
    private String url; // 资源路径
    private List<Role> roles; // 【角色】：多对多

    /** 设值函数 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
