package com.lin.missyou.api.v1;

import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.lib.LinWxNotify;
import com.lin.missyou.service.WxPaymentNotifyService;
import com.lin.missyou.service.WxPaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @ClassName: WXPaymentController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2411:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("v1/payment")
class WxPaymentController {
    @Resource
    private WxPaymentService wxPaymentService;
    @Resource
    private WxPaymentNotifyService wxPaymentNotifyService;

    @PostMapping("/pay/order/{id}")
    @ScopeLevel
    public Map<String, String> preWxOrder(@PathVariable(name="id") Long oid){
        Map<String,String> miniPayParams=wxPaymentService.preOrder(oid);
        return miniPayParams;
    }

    @RequestMapping("/wx/notiy")
    @ScopeLevel
    private String payCallback(HttpServletRequest request, HttpServletResponse response){
        InputStream s;
        try {
            s=request.getInputStream();
        } catch (IOException e) {
           return LinWxNotify.fail();
        }
        String xml=LinWxNotify.readNotify(s);
        try {
            this.wxPaymentNotifyService.processPayNotify(xml);
        } catch (Exception e) {
            return LinWxNotify.fail();
        }
        return LinWxNotify.success();
    }

}
