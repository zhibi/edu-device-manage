package edu.device.manage.domain;

import edu.device.manage.base.base.dto.BasePageDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;


/**
 * 借出订单
 *
 * @author 执笔
 * @date 2019/4/9 18:11
 */
@Table(name = "orders")
@Data
@Accessors(chain = true)
public class Order extends BasePageDTO implements Serializable {

    /**
     * 状态 借出  已还
     */
    private String status;

    private Integer userId;

    /**
     * 设备Id
     */
    private Integer deviceId;

}