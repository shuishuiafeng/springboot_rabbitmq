package com.feng.rabbit.listener;

import com.feng.rabbit.constant.RabbitMQConstants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiaofeng
 * @Date: 2019/4/27 13:50
 * @Description: fanout全部队列都接收
 */
@Component
public class TestFanoutReceiveListener {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = RabbitMQConstants.TEST_FANOUT_RECEIVE_QUEUE1, durable = "true"),
                    exchange = @Exchange(value = RabbitMQConstants.TEST_FANOUT_EXCHANGE, durable = "true", type = ExchangeTypes.FANOUT),
                    key = RabbitMQConstants.TEST_FANOUT_RECEIVE_QUEUE1
            )
    })
    public void receiveMessage(Message message){
        System.out.println("=====fanout接收receiveMessage(message)");
        System.out.println(message.getMessageProperties());
        System.out.println(new String(message.getBody()));
    }

}
