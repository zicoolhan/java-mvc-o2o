package com.czh.dao;

import com.czh.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {

    /*
    返回queryShopList总数
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);

    /*
    分页查询店铺，可输入的条件有： 店铺名（模糊查询）,店铺状态，店铺类别，区域id，owner
    @param shopCondition
    @param rowIndex 从第几行开始取数据
    @param pageSize 从第几行开始取数据
    @param pageSize 返回的条数
    @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
    /*
    通过shop id 查询店铺
     @param shopId
     @return shop
     */
    Shop queryByShopId(long shopId);

    /*
    新增店铺
    @Param shop
    @return
     */
    int insertShop(Shop shop);

    /*
    更新店铺信息
     */
    int updateShop(Shop shop);
}
