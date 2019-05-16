package edu.device.manage.mapper;

import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Order;
import edu.device.manage.model.OrderModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author 执笔
 * @date 2019/4/9 18:17
 */
public interface OrderMapper extends Mapper<Order> {

    /**
     * 通过条件查找
     *
     * @param condition
     * @return
     */
    List<OrderModel> selectModel(MybatisCondition condition);
}
