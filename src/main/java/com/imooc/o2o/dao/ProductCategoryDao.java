package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductCategory;

import java.util.List;

/**
 * ProductCategoryDao
 *
 * @author luoyi
 * @date 2020-08-2020/8/29 17:14
 */
public interface ProductCategoryDao {
    /**
     * 通过 shop id 查询店铺商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
}
