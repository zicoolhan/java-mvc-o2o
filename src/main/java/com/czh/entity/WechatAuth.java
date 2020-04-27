package com.czh.entity;

import java.util.Date;

public class WechatAuth {
    private Long wechatAuthId;
    private String opdnId;
    private Date createTime;
    private PersonInfo personInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpdnId() {
        return opdnId;
    }

    public void setOpdnId(String opdnId) {
        this.opdnId = opdnId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
