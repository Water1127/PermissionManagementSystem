package cn.water.project.domain;

import java.util.List;
import java.util.UUID;

/**
 * @author Water
 * @date 2019/11/4 - 19:21
 * @description
 */
public class UserInfo {

    /** 成员变量 */
    private String id; // 主键
    private String username; // 用户的账号
    private String password; // 用户的密码
    private String email; // 用户的邮箱
    private String phoneNum; // 用户的手机号码
    private int status; // 用户的状态（0未开启，1开启）
    private String statusStr; // 用户的状态[字符串]
    private List<Role> roles; // 【角色】：多对多

    /** 设值函数 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        /* 赋值 */
        if(status==0){
            statusStr="未开启";
        }else if (status==1){
            statusStr="开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", roles=" + roles +
                '}';
    }
}
