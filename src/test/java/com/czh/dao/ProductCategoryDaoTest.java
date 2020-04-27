package com.czh.dao;

import com.czh.BaseTest;
import com.czh.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private  ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryProductCategory(){
        long shopId = 1L;

        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategory(shopId);
        assertEquals(3,productCategoryList.size());
        for (ProductCategory pc: productCategoryList
             ) {
            System.out.println(pc);
            System.out.println("-------------------------");
        }
    }
    @Test
    public void testBatchInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别1");
        productCategory2.setPriority(1);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testDeleteProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(7L);
        productCategory.setShopId(1L);
        int effectedNum = productCategoryDao.deleteProductCategory(7L, 1L);
        assertEquals(1,effectedNum);

    }
}
