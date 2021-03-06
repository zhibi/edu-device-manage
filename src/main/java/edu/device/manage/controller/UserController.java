package edu.device.manage.controller;

import edu.device.manage.base.annocation.RequestLogin;
import edu.device.manage.base.base.controller.BaseController;
import edu.device.manage.base.utils.MD5Utils;
import edu.device.manage.domain.User;
import edu.device.manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("user")
@Controller
@RequestLogin
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 个人中心
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "user/index";
    }

    /**
     * 个人信息
     */
    @GetMapping("info")
    public String info(Model model) {
        User user = userMapper.selectByPrimaryKey(sessionUser().getId());
        model.addAttribute(user);
        return "user/info";
    }

    /**
     * 更新个人信息
     *
     * @param user
     * @return
     */
    @PostMapping("update")
    public String update(User user, RedirectAttributes attributes) {
        userMapper.updateByPrimaryKeySelective(user);
        return refresh("更新成功", attributes);
    }

    /**
     * 修改密码
     *
     * @return
     */
    @GetMapping("modifyPwd")
    public String modifyPwd() {
        return "user/modify-pwd";
    }

    /**
     * 修改密码
     *
     * @param pwd
     * @param pwd2
     * @param pwd3
     * @return
     */
    @PostMapping("modifyPwd")
    @RequestLogin
    public String modifyPwd(String pwd, String pwd2, String pwd3, RedirectAttributes attributes) {
        if (!pwd2.equals(pwd3)) {
            return redirect("两次密码不一样", "/user/modifyPwd", attributes);
        }
        User user = sessionUser();
        if (!user.getPassword().equalsIgnoreCase(MD5Utils.encrypt(pwd))) {
            return redirect("原密码错误", "/user/modifyPwd", attributes);
        }
        user.setPassword(MD5Utils.encrypt(pwd2));
        userMapper.updateByPrimaryKeySelective(user);
        return redirect("修改成功", "/logout", attributes);
    }
}
