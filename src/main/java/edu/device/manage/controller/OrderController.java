package edu.device.manage.controller;

import edu.device.manage.base.annocation.RequestLogin;
import edu.device.manage.base.base.controller.BaseController;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.domain.Order;
import edu.device.manage.mapper.DeviceMapper;
import edu.device.manage.mapper.OrderMapper;
import edu.device.manage.domain.Business;
import edu.device.manage.domain.Coupon;
import edu.device.manage.mapper.BusinessMapper;
import edu.device.manage.mapper.CouponMapper;
import edu.device.manage.model.OrderModel;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/13 23:16
 */
@RequestMapping("order")
@Controller
@RequestLogin
public class OrderController extends BaseController {

    @Autowired
    private OrderService   orderService;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private OrderMapper    orderMapper;
    @Autowired
    private CouponMapper   couponMapper;
    @Autowired
    private DeviceMapper   deviceMapper;


    /**
     * 发布预约页面
     *
     * @param businessId
     * @param model
     * @return
     */
    @GetMapping("send/{businessId}")
    public String send(@PathVariable Integer businessId, Model model) {
        Business business = businessMapper.selectByPrimaryKey(businessId);
        model.addAttribute(business);
        // 菜品
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
                .eq("business_id", businessId);
        List<Device> deviceList = deviceMapper.selectByExample(example);
        model.addAttribute(deviceList);
        return "business/order-send";
    }

    /**
     * 发布预约
     *
     * @param order
     * @return
     */
    @Transactional
    @PostMapping("send")
    public String send(Order order) {
        order.setAddTime(new Date());
        order.setUserId(sessionUser().getId());
        order.setStatus("预约");
        // 计算价格
        double   money = 0;
        String[] split = order.getFoods().split(",");
        for (String s : split) {
            Device device = deviceMapper.selectByPrimaryKey(s);
            if (null != device) {
                money += device.getPrice();
            }
        }
        order.setTotal(money);
        orderMapper.insertSelective(order);
        order.setOrderNo(order.getId() + 100000 + "");
        orderMapper.updateByPrimaryKeySelective(order);
        Business business = businessMapper.selectByPrimaryKey(order.getBusinessId());
        business.setOrderNum(business.getOrderNum() + 1);
        businessMapper.updateByPrimaryKeySelective(business);
        return redirect("预约成功", "/order/myOrder");
    }

    /**
     * 订单详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Order        order    = orderMapper.selectByPrimaryKey(id);
        Business     business = businessMapper.selectByPrimaryKey(order.getBusinessId());
        List<Coupon> coupons  = couponMapper.selectByExample(new MybatisCondition().eq("user_id", sessionUser().getId()).eq("status", "待使用"));
        model.addAttribute(business);
        model.addAttribute(order);
        if (coupons.size() > 0) {
            model.addAttribute("coupon", coupons.get(0));
        }
        // 菜
        String[]     ids        = order.getFoods().split(",");
        List<Device> deviceList = new ArrayList<>();
        for (String s : ids) {
            Device device = deviceMapper.selectByPrimaryKey(s);
            deviceList.add(device);
        }
        model.addAttribute(deviceList);
        return "user/order-detail";
    }


    /**
     * 订单支付
     *
     * @param orderId
     * @return
     */
    @RequestMapping("pay/{orderId}")
    public String pay(@PathVariable Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        orderService.pay(order);
        return refresh("支付成功，商家处理中");
    }

    /**
     * 我的订单
     *
     * @param model
     * @return
     */
    @RequestMapping("myOrder")
    public String myOrder(Model model) {
        MybatisCondition example = new MybatisCondition()
                .order("o.id", false)
                .eq("o.user_id", sessionUser().getId());
        List<OrderModel> orderList = orderService.selectModel(example);
        model.addAttribute("orderList", orderList);
        return "user/order-list";
    }


}
