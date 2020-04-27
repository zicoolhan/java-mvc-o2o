package com.czh.enums;

public enum ProductStateEnum {

    DOWN(0,"下架"),
    OFFLINE(-1,"非法商品"),
    SUCCESS(1,"操作成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY(-1002,"商品为空");

    private int state;
    private String stateInfo;

    private ProductStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /*
    依据传入的state返回值返回相应的enum值
     */

    public static ProductStateEnum stateOf(int state) {
        for (ProductStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {

        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
