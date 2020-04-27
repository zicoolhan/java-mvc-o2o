package com.czh.dao;

import com.czh.BaseTest;
import com.czh.entity.Area;
import com.czh.entity.PersonInfo;
import com.czh.entity.Shop;
import com.czh.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopListAndCount() {
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(12L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
        System.out.println(shopList.size());
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println(count);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(2L);
        shopCondition.setShopCategory(sc);
        List<Shop> shopList1 = shopDao.queryShopList(shopCondition, 0, 2);
        for (Shop shop : shopList1) {
            System.out.println(shop.getShopId() + ": " + shop.getShopName());
        }

    }
    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId: " + shop.getArea().getAreaId());
        System.out.println("areaName: " + shop.getArea().getAreaName());
    }
    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopAddr("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);

    }
    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);

        shop.setShopAddr("测试地址");
        shop.setShopDesc("测试描述");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);

    }

}
