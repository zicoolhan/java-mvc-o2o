package com.czh.service;

import com.czh.dto.ImageHolder;
import com.czh.dto.ProductExecution;
import com.czh.entity.Product;
import com.czh.entity.ProductCategory;
import com.czh.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    /*
    添加商品信息以及图片处理
    @param product
    @param thumbnail
    @param productImg
    @return
    @throws ProductOperationException
     */

    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgHolderList) throws ProductOperationException;

    /*
    修改商品信息以及图片处理
    @param product
    @param thumbnail
    @param productImgs
    @return
    @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws  ProductOperationException;
    /*
    通过商品Id查询唯一的商品
     */
    Product getProductById(long productId);


    ProductExecution getProductList(Product productCondition,int pageIndex, int pageSize);


}
