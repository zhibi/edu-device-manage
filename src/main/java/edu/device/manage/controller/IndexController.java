package edu.device.manage.controller;

import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.controller.BaseController;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.base.utils.MD5Utils;
import edu.device.manage.domain.User;
import edu.device.manage.mapper.UserMapper;
import edu.device.manage.model.DeviceModel;
import edu.device.manage.service.DeviceService;
import edu.device.manage.service.UserService;
import edu.device.manage.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * @author 执笔
 * @date 2019/4/13 16:46
 */
@Controller
@RequestMapping
public class IndexController extends BaseController {

    @Autowired
    private UserService   userService;
    @Autowired
    private UserMapper    userMapper;
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private VerifyCodeService verifyCodeService;


    /**
     * 首页展示
     *
     * @param model
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index(Model model, String name) {
        MybatisCondition example = new MybatisCondition()
                .order("d.id", false)
                .like("d.name", name)
                .page(1, 50);
        PageInfo<DeviceModel> pageInfo = deviceService.selectModelPage(example);
        model.addAttribute("deviceList", pageInfo.getList());
        return "index";
    }

    /**
     * 登录
     *
     * @return
     */
    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    /**
     * 跳转注册页
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @PostMapping(value = "login")
    public String login(String phone, String password, RedirectAttributes attributes) {
        User user = userService.login(phone, password, "user");
        if (null == user) {
            return redirect("用户名或密码错误", "login", attributes);
        }
        session.setAttribute(SESSION_USER, user);
        return redirect("/");
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, String password2, String verifyCode, RedirectAttributes attributes) {
        String code = verifyCodeService.getCode(request);
        if (!code.equalsIgnoreCase(verifyCode)) {
            return redirect("验证码错误", "register", attributes);
        }
        verifyCodeService.removeCode(request);
        if (!user.getPassword().equals(password2)) {
            return redirect("两次密码不一样", "register", attributes);
        }
        User temp = userService.selectByPhone(user.getPhone());
        if (null != temp) {
            return redirect("该手机号已经注册", "register", attributes);
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        return redirect("注册成功，请登录", "login", attributes);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout(RedirectAttributes attributes) {
        session.removeAttribute(SESSION_USER);
        return redirect("您已经安全退出", "login", attributes);
    }


}