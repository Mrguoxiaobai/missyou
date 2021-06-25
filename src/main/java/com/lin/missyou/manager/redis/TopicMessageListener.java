package com.lin.missyou.manager.redis;

import com.lin.missyou.bo.OrderMessageBO;
import com.lin.missyou.service.couponBackService;
import com.lin.missyou.service.orderCancelService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import javax.annotation.Resource;

/**
 * @ClassName: TopicMessageListener
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2515:38
 * @Version: 1.0
 */
public class TopicMessageListener implements MessageListener {
    @Resource
    private orderCancelService orderCancelService;

    @Resource
    private couponBackService couponBackService;
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();

        String expiredKey = new String(body);
        String topic = new String(channel);

        OrderMessageBO messageBO = new OrderMessageBO(expiredKey);
        orderCancelService.cancel(messageBO);
        couponBackService.returnBack(messageBO);
    }
}
