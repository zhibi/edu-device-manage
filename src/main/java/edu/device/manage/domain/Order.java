package edu.device.manage.domain;

import edu.device.manage.base.base.dto.BasePageDTO;
import lombok.Data;

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
public class Order extends BasePageDTO implements Serializable {

    private String orderNo;
    /**
     * 状态 借出  已还
     */
    private String status;
    /**
     * 备注
     */
    private String remark;

    private Integer userId;

    /**
     * 归还时间
     */
    private String remandTime;

}