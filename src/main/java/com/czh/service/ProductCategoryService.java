package com.czh.service;

import com.czh.dto.ProductCategoryExecution;
import com.czh.entity.ProductCategory;
import com.czh.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCategoryList(long shopId);

    /*
    批量添加商品类别
    @param productCategory
    @return
    @throws ShopOperationException
    */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /*
    删除商品类别
    将此类别下的商品里的类别设置为空
    @param productCategoryId
    @param shopId
    @return
    @throws ShopOperationException
    */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;


}
