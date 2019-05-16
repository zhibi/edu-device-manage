package edu.device.manage.base.base.controller;

import edu.device.manage.base.context.Constant;
import edu.device.manage.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 执笔
 * @date 2019/4/9 21:48
 */
public abstract class BaseController implements Constant {

    @Autowired
    protected HttpSession        session;
    @Autowired
    protected HttpServletRequest request;
    @Value("${upload.path}")
    private   String             uploadPath;

    protected User sessionUser() {
        return (User) session.getAttribute(SESSION_USER);
    }

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    protected String saveFile(MultipartFile file) {
        String back     = file.getOriginalFilename().substring(("." + file.getOriginalFilename()).lastIndexOf("."));
        String fileName = UUID.randomUUID() + "." + back;
        File   newFile  = new File(uploadPath + "/upload/" + fileName);
        newFile.getParentFile().mkdirs();
        try {
            newFile.createNewFile();
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传文件: " + newFile.getAbsolutePath());
        return "/upload/" + fileName;
    }


    /**
     * 刷新页面
     *
     * @return
     * @Date 2016年2月24日 上午11:16:22
     */
    protected String refresh() {
        return "redirect:" + request.getHeader("Referer");
    }

    protected String refresh(String message, RedirectAttributes attributes) {
        attributes.addFlashAttribute(ERROR_MESSAGE, message);
        return "redirect:" + request.getHeader("Referer");
    }

    /**
     * 重定向
     *
     * @param viewName
     * @return
     */
    protected String redirect(String viewName) {
        return "redirect:" + viewName;
    }

    /**
     * 重定向
     *
     * @param viewName
     * @param message
     * @return
     */
    protected String redirect(String message, String viewName, RedirectAttributes attributes) {
        attributes.addFlashAttribute(ERROR_MESSAGE, message);
        return "redirect:" + viewName;
    }
}
