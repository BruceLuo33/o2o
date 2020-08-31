package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductImg;

import java.util.List;

/**
 * ProductImgDao
 *
 * @author luoyi
 * @date 2020-08-2020/8/31 09:00
 */
public interface ProductImgDao {
    /**
     * 列出某个商品的详情图列表
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);

    /**
     * 批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品下的详情图
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);
}
