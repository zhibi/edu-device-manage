package edu.device.manage.model;

import edu.device.manage.domain.Order;
import lombok.Data;

/**
 * @author 执笔
 * @date 2019/5/16 13:18
 */
@Data
public class OrderModel extends Order {

    /**
     * 发布人
     */
    private String userName;
    /**
     *
     */
    private String deviceName;

    /**
     * 图标
     */
    private String deviceIcon;

}
