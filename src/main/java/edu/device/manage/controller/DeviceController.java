package edu.device.manage.controller;

import edu.device.manage.base.annocation.RequestLogin;
import edu.device.manage.base.base.controller.BaseController;
import edu.device.manage.domain.Device;
import edu.device.manage.service.DeviceService;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/5/16 17:20
 */
@Controller
@RequestMapping("device")

public class DeviceController extends BaseController {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private OrderService  orderService;


    /**
     * 添加设备
     *
     * @return
     */
    @GetMapping("add")
    @RequestLogin
    public String add() {
        return "device/add";
    }

    /**
     * 添加设备
     */
    @PostMapping("add")
    @RequestLogin
    public String add(RedirectAttributes attributes, Device device, MultipartFile file) {
        String path = saveFile(file);
        device.setIcon(path);
        device.setUserId(sessionUser().getId());
        device.setStatus("未借");
        deviceService.insertSelective(device);
        return redirect("添加成功", "list", attributes);
    }

    /**
     * 我的设备列表
     */
    @GetMapping("list")
    @RequestLogin
    public String list(Model model) {
        List<Device> deviceList = deviceService.select(new Device().setUserId(sessionUser().getId()));
        model.addAttribute("deviceList", deviceList);
        return "device/list";
    }

    /**
     * 删除
     */
    @GetMapping("del/{id}")
    @RequestLogin
    public String del(@PathVariable Integer id, RedirectAttributes attributes) {
        deviceService.deleteByPrimaryKey(id);
        return refresh("删除成功", attributes);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public String del(@PathVariable Integer id, Model model) {
        Device device = deviceService.selectByPrimaryKey(id);
        model.addAttribute(device);
        return "device/detail";
    }

    /**
     * 借
     */
    @GetMapping("lend/{id}")
    @RequestLogin
    public String lend(@PathVariable Integer id, RedirectAttributes attributes) {
        orderService.lend(sessionUser().getId(), id);
        return refresh("借用成功，请记得归还", attributes);
    }
}
