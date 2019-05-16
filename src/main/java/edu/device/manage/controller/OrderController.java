package edu.device.manage.controller;

import edu.device.manage.base.annocation.RequestLogin;
import edu.device.manage.base.base.controller.BaseController;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.domain.Order;
import edu.device.manage.mapper.DeviceMapper;
import edu.device.manage.mapper.OrderMapper;
import edu.device.manage.model.OrderModel;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private OrderService orderService;



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

    @RequestMapping("remand/{id}")
    public String remand(@PathVariable Integer id,RedirectAttributes attributes){
        orderService.remand(id);
        return refresh("归还成功",attributes);
    }


}
