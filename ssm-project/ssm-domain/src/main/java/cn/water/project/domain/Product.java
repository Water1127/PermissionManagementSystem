package cn.water.project.domain;


import cn.water.project.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

/**
 * @author Water
 * @date 2019/11/1 - 13:13
 * @description 产品
 */
public class Product {

    /** 成员变量 */
    private String id; // 主键 [UUID]
    private String productNum; // 产品编号
    private String productName; // 产品名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime; // 出发时间
    private String departureTimeStr; //出发时间[字符串]
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 产品状态（1开启，0关闭）
    private String productStatusStr; // 产品状态[字符串]


    /** 设值函数 */
    public String getId() {
        /* 获取随机UUID */
        id = UUID.randomUUID().toString();
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        /* 使用工具类转换格式 */
        if (departureTime!=null){
            departureTimeStr = DateUtils.date_string(departureTime,"yyyy-MM-dd hh-mm-ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        /* 设置值 */
        if (productStatus==1){
            this.productStatusStr = "开启";
        }
        if (productStatus==0){
            this.productStatusStr = "关闭";
        }
        System.out.println(productStatus+"产品状态！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
