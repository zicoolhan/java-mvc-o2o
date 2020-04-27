package com.czh.dto;

import com.czh.entity.ProductCategory;
import com.czh.entity.Shop;
import com.czh.enums.ProductCategoryStateEnum;
import com.czh.enums.ShopStateEnum;

import java.util.List;

public class ProductCategoryExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //返回店铺数量
    private int count;

    //操作的shop
    private List<ProductCategory> productCategoryList;

    public ProductCategoryExecution() {
    }

    //店铺操作失败时使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //店铺操作成功时使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productCategoryList=productCategoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
