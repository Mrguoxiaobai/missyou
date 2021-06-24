package com.lin.missyou.service;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.lin.missyou.core.enumeration.OrderStatus;
import com.lin.missyou.exception.http.ServerErrorException;
import com.lin.missyou.model.Order;
import com.lin.missyou.repository.OrderRepostory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: WxPaymentNotifyService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2415:55
 * @Version: 1.0
 */
@Service
public class WxPaymentNotifyService {
    @Resource
    private WxPaymentService wxPaymentService;

    @Resource
    private OrderRepostory orderRepository;

    public void processPayNotify(String data) {
        Map<String, String> dataMap;
        try {
            dataMap = WXPayUtil.xmlToMap(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

        WXPay wxPay = this.wxPaymentService.assembleWxPayConfig();
        boolean valid;
        try {
            valid = wxPay.isResponseSignatureValid(dataMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);

        }
        if (!valid) {
            throw new ServerErrorException(9999);
        }

        String returnCode = dataMap.get("return_code");
        String orderNo = dataMap.get("out_trade_no");
        String resultCode = dataMap.get("result_code");

        if (!returnCode.equals("SUCCESS")) {
            throw new ServerErrorException(9999);
        }
        if (!resultCode.equals("SUCCESS")) {
            throw new ServerErrorException(9999);
        }
        if (orderNo == null) {
            throw new ServerErrorException(9999);
        }
        this.deal(orderNo);
    }

    private void deal(String orderNo) {
        Optional<Order> orderOptional = this.orderRepository.findFirstByOrderNo(orderNo);
        Order order = orderOptional.orElseThrow(() -> new ServerErrorException(9999));

        // unpaid -> paid
        // 支付后扣除
        // 3/3
        // unpaid -> paid
        // paid -> paid
        // Cancel
        //
        int res = -1;
        if (order.getStatus().equals(OrderStatus.UNPAID.value())
                || order.getStatus().equals(OrderStatus.CANCELED.value())) {
            res = this.orderRepository.updateStatusByOrderNo(orderNo, OrderStatus.PAID.value());
        }
        if (res != 1) {
            throw new ServerErrorException(9999);
        }
    }

}
