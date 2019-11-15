package cn.water.project.domain;

/**
 * @author Water
 * @date 2019/11/2 - 14:36
 * @description 会员
 */
public class Member {

    /** 成员变量 */
    private String id; // 主键[UUID]
    private String name; // 会员姓名
    private String nickname; // 会员昵称
    private String phoneNum; // 会员的电话号码
    private String email; // 会员的邮箱


    /** 设值函数 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
