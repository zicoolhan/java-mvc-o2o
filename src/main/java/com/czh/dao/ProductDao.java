package com.czh.dao;

import com.czh.entity.Product;
import com.czh.entity.ProductCategory;
import com.czh.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    /**
     * 插入商品
     * @param product
     * @return
     *
     */
    int insertProduct(Product product);

    /*
   通过product id 查询商品
    @param productId
    @return product
    */
    Product queryByProductId(long productId);

    /*
    更新商品信息
    */
    int updateProduct(Product product);

    /*
   分页查询商品，可输入的条件有： 商店id,商品名（模糊查询）,商品状态，商品类别，区域id，owner
   @param productCondition
   @param rowIndex 从第几行开始取数据
   @param pageSize 从第几行开始取数据
   @param pageSize 返回的条数
   @return
    */
    List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /*
   返回queryProductList总数
    */
    int queryProductCount(@Param("productCondition") Product productCondition);

    /*
    删除商品类别之前，将商品类别ID置为空

     */
    int updateProductCategoryToNull(long productCategoryId);
}
