package com.imooc.o2o.service;

import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.exceptions.ProductOperationException;

/**
 * ProductService
 *
 * @author luoyi
 * @date 2020-08-2020/8/31 11:37
 */
public interface ProductService {
    /**
     * 添加商品信息及图片处理
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct() throws ProductOperationException;
}
