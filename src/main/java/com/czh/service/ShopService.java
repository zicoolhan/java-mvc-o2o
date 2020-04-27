package com.czh.service;

import com.czh.dto.ImageHolder;
import com.czh.dto.ShopExecution;
import com.czh.entity.Shop;
import com.czh.exceptions.ShopOperationException;

public interface ShopService {

    /*
    根据shopCondtion分页返回相应店铺列表
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
    /*
    通过店铺Id获取店铺信息
    @param shopId
    @return
     */
    Shop getByShopId(long shopId);

    /*
    更新店铺信息，包括对图片的处理
    @param shop
    @param shopImg
    @return
    @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /*
    注册店铺信息，包括对图片的处理
    @param shop
    @param shopImg
    @return
    @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
