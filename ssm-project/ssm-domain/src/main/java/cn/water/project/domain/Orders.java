package cn.water.project.domain;

import cn.water.project.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Water
 * @date 2019/11/2 - 14:21
 * @description 订单
 */
public class Orders {

    /** 成员变量 */
    private String id; // 主键[UUID]
    private String orderNum; // 订单编号
    private Date orderTime; // 订单创建时间
    private String orderTimeStr; // 订单创建时间[字符串]
    private int orderStatus; // 订单状态（0未支付，1已支付）
    private String orderStatusStr; // 订单状态[字符串]
    private int peopleCount; // 出行人数
    private Integer payType; // 支付方式（0支付宝，1微信，2其它）
    private String payTypeStr; // 支付方式[字符串]
    private String orderDesc; // 描述
    private Product product; // 【产品】：一对一
    private List<Traveller> travellers; // 【旅客】：一对多
    private Member member; // 【会员】：一对一（多对一）


    /** 设值函数 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        /* 使用工具类转换格式 */
        if (orderTime!=null){
            orderTimeStr = DateUtils.date_string(orderTime,"yyyy-MM-dd hh-mm-ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        /* 设置值 */
        if (orderStatus==1){
            this.orderStatusStr = "已支付";
        }
        if (orderStatus==0){
            this.orderStatusStr = "未支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType==0){
            payTypeStr = "支付宝";
        }else if (payType==1){
            payTypeStr = "微信";
        }else if (payType==2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                '}';
    }
}
