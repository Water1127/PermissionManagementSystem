package cn.water.project.domain;

/**
 * @author Water
 * @date 2019/11/2 - 14:36
 * @description 旅客
 */
public class Traveller {

    /** 成员变量 */
    private String id; // 主键
    private String name; // 旅客姓名
    private String sex; // 旅客性别
    private String phoneNum; // 旅客的电话号码
    private Integer credentialsType; // 旅客的证件类型（0身份证，1护照，2军官证）
    private String credentialsTypeStr; // 旅客的证件类型[字符串]
    private String credentialsNum; // 旅客的证件号码
    private Integer travellerType; // 旅客类型（0成人，1儿童）
    private String travellerTypeStr; // 旅客类型[字符串]

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType==0){
            credentialsTypeStr="身份证";
        }else if (credentialsType==1){
            credentialsTypeStr="护照";
        }else if (credentialsType==2){
            credentialsTypeStr="军官证";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType==0){
            travellerTypeStr="成人";
        }else if(travellerType==1){
            travellerTypeStr="儿童";
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
