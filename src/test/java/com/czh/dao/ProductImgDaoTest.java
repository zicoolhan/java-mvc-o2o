package com.czh.dao;

import com.czh.BaseTest;
import com.czh.entity.Product;
import com.czh.entity.ProductImg;
import com.czh.entity.Shop;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private  ProductImgDao productImgDao;

    @Test
    public void testBatchInsertProductImg() {
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片1");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectetNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2,effectetNum);
    }

    @Test
    public void testDeleteProductImgByProductId(){
        int effectedNum = productImgDao.deleteProductImgByProductId(1L);
        assertEquals(4, effectedNum);
    }

    @Test
    public void testQueryProductImgList() {
        List<ProductImg> productImgList = productImgDao.queryProductImgList(1L);
        assertEquals(2,productImgList.size());
    }
}
