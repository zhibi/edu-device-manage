package edu.device.manage.base.base.service;

import com.github.pagehelper.PageInfo;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.base.base.dto.BasePageDTO;

/**
 * 基础service
 * @author  执笔
 * @param <T>
 */
public interface BaseService<T extends BasePageDTO> {

    /**
     * 分页
     * @param dto
     * @return
     */
    PageInfo<T> selectPage(T dto);

    /**
     * 分页
     * @param condition
     * @return
     */
    PageInfo<T> selectPage(MybatisCondition condition);

}
