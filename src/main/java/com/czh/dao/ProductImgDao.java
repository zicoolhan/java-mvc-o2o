package com.czh.dao;

import com.czh.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {

    /*
    批量添加商品详情图片
    @param productImgList
    @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);


    /*
    删除指定商品下所有的详情图
    @param productId
    @return
     */
    int deleteProductImgByProductId(long productId);

    /*
    列出某个商品的详情图列表
     */
    List<ProductImg> queryProductImgList(long productId);
}
