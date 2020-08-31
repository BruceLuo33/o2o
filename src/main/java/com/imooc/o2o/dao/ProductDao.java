package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;

/**
 * ProductDao
 *
 * @author luoyi
 * @date 2020-08-2020/8/31 08:59
 */
public interface ProductDao {
    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(Product product);
}
