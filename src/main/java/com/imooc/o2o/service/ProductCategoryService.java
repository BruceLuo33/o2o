package com.imooc.o2o.service;

import com.imooc.o2o.entity.ProductCategory;

import java.util.List;

/**
 * ProductCategoryService
 *
 * @author luoyi
 * @date 2020-08-2020/8/29 17:39
 */
public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(Long shopId);
}
