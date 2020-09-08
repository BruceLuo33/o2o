package com.imooc.o2o.service;

import com.imooc.o2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

/**
 * HeadLineService
 *
 * @author luoyi
 * @date 2020-09-2020/9/8 10:45
 */
public interface HeadLineService {
    /**
     * 根据传入的条件返回指定的头条列表
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
