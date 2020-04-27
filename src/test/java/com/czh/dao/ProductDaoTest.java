package com.czh.dao;

import com.czh.BaseTest;
import com.czh.entity.Product;
import com.czh.entity.ProductCategory;
import com.czh.entity.ProductImg;
import com.czh.entity.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private  ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testInsertProduct() {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setProductName("旺旺小小酥");
        product.setPriority(10);
        product.setShop(shop);
        int effectedNum = productDao.insertProduct(product);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testQueryProductByProductId(){
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

        Product product = productDao.queryByProductId(1L);
        assertEquals(2,product.getProductImgList().size());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product();
        ProductCategory productCategory = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        productCategory.setProductCategoryId(1L);
        product.setShop(shop);
        product.setProductId(1L);
        product.setProductName("第二个产品");
        product.setProductCategory(productCategory);

        int effectedNum = productDao.updateProduct(product);
        assertEquals(1,effectedNum);

    }


    @Test
    public void testQueryProductList() {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);

        product.setProductName("测试商品");
//        List<Product> productList = productDao.queryProductList(product,0,4);
        int i = productDao.queryProductCount(product);
        assertEquals(2,i);
//        assertEquals(0, productList.size());
    }

    @Test
    public void testUpdateProductCategoryToNull(){
        int effectedNum = productDao.updateProductCategoryToNull(2L);
        assertEquals(2, effectedNum);
    }
}
