package edu.device.manage.service;

import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.service.BaseService;
import edu.device.manage.base.context.Constant;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Order;
import edu.device.manage.model.OrderModel;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
public interface OrderService extends BaseService<Order>, Constant {

    /**
     * 借用
     * @param userId
     * @param deviceId
     */
    void lend(Integer userId,Integer deviceId);

    /**
     * 通过条件查找
     *
     * @param example
     * @return
     */
    List<OrderModel> selectModel(MybatisCondition example);

    /**
     * 通过条件分页查找
     *
     * @param example
     * @return
     */
    PageInfo<OrderModel> selectModelPage(MybatisCondition example);

    OrderModel selectModelById(Long id);
}