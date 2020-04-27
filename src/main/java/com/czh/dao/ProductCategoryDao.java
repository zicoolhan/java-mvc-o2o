package com.czh.dao;

import com.czh.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> queryProductCategory(@Param("shopId")long shopId);

    /*
   批量新增产品种类
   @Param productCategoryList
   @return
    */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /*
    删除指定商品类别
    @param productCategoryId
    @param shopId
    @return effectedNum
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
