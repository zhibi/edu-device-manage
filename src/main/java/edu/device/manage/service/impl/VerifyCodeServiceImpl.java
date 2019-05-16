package edu.device.manage.service.impl;


import edu.device.manage.base.context.Constant;
import edu.device.manage.service.VerifyCodeService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * 验证码service
 *
 * @author 执笔
 * @date 2018/12/28 22:28
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Override
    public void saveCode(HttpServletRequest request, String code, String deviceId) {
        request.getSession().setAttribute(Constant.VERIFY_CODE, code);
    }

    @Override
    public String getCode(HttpServletRequest request) {
        Object codeInSession = request.getSession().getAttribute(Constant.VERIFY_CODE);
        return codeInSession == null ? "" : codeInSession.toString();
    }

    @Override
    public void removeCode(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.VERIFY_CODE);
    }
}
