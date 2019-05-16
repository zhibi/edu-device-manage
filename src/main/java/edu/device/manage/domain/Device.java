package edu.device.manage.domain;

import edu.device.manage.base.base.dto.BasePageDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;


/**
 * @author 执笔
 * @date 2019/4/9 18:29
 */
@Data
@Table(name = "device")
@Accessors(chain = true)
public class Device extends BasePageDTO implements Serializable {

    /**
     * 设备名
     */
    private String name;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 描述
     */
    private String description;

    /**
     * 购买时间
     */
    private String payTime;
    /**
     * 图片
     */
    private String icon;
    /**
     * 价格
     */
    private Double price;


    /**
     * 借出
     * 未借
     */
    private String status;

}