package com.czh.dao;

import com.czh.BaseTest;
import com.czh.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class shopCategoryDaoTest  extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
//        List<ShopCategory> shopCateGoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
//        assertEquals(2,shopCateGoryList.size());
//        ShopCategory testCategory = new ShopCategory();
//        ShopCategory parentCategory = new ShopCategory();
//        parentCategory.setShopCategoryId(1L);
//        testCategory.setParent(parentCategory);
//        shopCateGoryList = shopCategoryDao.queryShopCategory(testCategory);
//        assertEquals(1,shopCateGoryList.size());
//        System.out.println(shopCateGoryList.get(0).getShopCategoryDesc());
        List<ShopCategory> shopCateGoryList = shopCategoryDao.queryShopCategory(null);
        assertEquals(6,shopCateGoryList.size());

    }
}
