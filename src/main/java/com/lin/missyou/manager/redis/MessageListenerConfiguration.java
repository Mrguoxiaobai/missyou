package com.lin.missyou.manager.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

/**
 * @ClassName: MessageListenerConfiguration
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2515:38
 * @Version: 1.0
 */
public class MessageListenerConfiguration {
    @Value("${spring.redis.listen-pattern}")
    public String pattern;

    @Bean
    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory redisConnection) {
//        return new TopicMessageListener()
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnection);
        Topic topic = new PatternTopic(this.pattern);

        container.addMessageListener(new TopicMessageListener(), topic);
        return container;
    }

}
