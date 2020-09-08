package com.imooc.o2o.dao;

import com.imooc.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * HeadLineDao
 *
 * @author luoyi
 * @date 2020-09-2020/9/6 16:45
 */
public interface HeadLineDao {

    /**
     * 根据传入的条件查询（头条名查询头条）
     * @param headLineCondition
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
