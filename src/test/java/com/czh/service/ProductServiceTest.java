package com.czh.service;

import com.czh.BaseTest;
import com.czh.dto.ImageHolder;
import com.czh.dto.ProductExecution;
import com.czh.entity.Product;
import com.czh.entity.ProductCategory;
import com.czh.entity.Shop;
import com.czh.enums.ProductStateEnum;
import com.czh.exceptions.ShopOperationException;
import org.junit.Test;
import org.omg.CORBA.PERSIST_STORE;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() throws ShopOperationException, FileNotFoundException {
        //创建shopId为1 且productCategoryId 为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流

        File thumbnailFile = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naicha01.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
        //创建两个商品详情图文件流并将它们添加到详情图列表中
        File productImg1 = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naicha02.jpg");
        InputStream is1 = new FileInputStream(thumbnailFile);
        File productImg2 = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naicha03.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile);
        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(productImg1.getName(),is1));
        productImgList.add(new ImageHolder(productImg2.getName(),is2));
        //添加商品并验证
        ProductExecution productExecution = productService.addProduct(product, thumbnail, productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), productExecution.getState());

    }

    @Test
    public void testModifyProduct() throws ShopOperationException,FileNotFoundException {
        //创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory productCategory= new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("正式的商品");
        product.setProductDesc("正式的商品");
        //创建缩略图文件流
        File thumbnailFile = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naicha01.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
        //创建两个商品详情图文件流并将它们添加到详情图列表中
        File productImg1 = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naicha02.jpg");
        InputStream inputStream1 = new FileInputStream(productImg1);
        File productImg2 = new File("/Users/czh/Documents/java2019fall/o2o/src/test/resources/naichai03.jpg");
        InputStream inputStream2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(productImg1.getName(), inputStream1));
        productImgList.add(new ImageHolder(productImg2.getName(), inputStream2));
        //添加商品并验证
        ProductExecution productExecution = productService.modifyProduct(product,thumbnail,productImgList);
        assertEquals(productExecution.getState(),ProductStateEnum.SUCCESS.getState());
    }
}
