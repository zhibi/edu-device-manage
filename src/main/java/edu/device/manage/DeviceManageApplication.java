package edu.device.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 执笔
 * @date 2019/4/9 15:22
 */
@SpringBootApplication
@MapperScan("edu.device.manage.mapper")
public class DeviceManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeviceManageApplication.class, args);
    }
}
