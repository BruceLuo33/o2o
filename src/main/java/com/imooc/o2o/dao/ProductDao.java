package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 通过 productId 获取 product 信息
     * @param productId
     * @return
     */
    Product queryProductById(long productId);

    /**
     * 查询商品列表并分页，可以输入的条件有：商品名（模糊）、商品状态、店铺Id、商品类别
     * @param productCondition
     * @param rowIndex
     * @return
     */
    List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize);

    /**
     * 查询对应的商品总数
     * @param productCondition
     * @return
     */
    int queryProductCount(@Param("productCondition") Product productCondition);

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除商品类别之前，将商品类别 ID 置为空
     * @param productCategoryId
     * @return
     */
    int updateProductCategoryToNull(long productCategoryId);
}
