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
 * @Date: 2019/4/27 13:42
 * @Description: 订单消息接收监听
 */
@Component
public class OrderReceiveListener {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = RabbitMQConstants.ORDER_RECEIVE_QUEUE, durable = "true"),
                    exchange = @Exchange(value = RabbitMQConstants.ORDER_TOPIC_EXCHANGE, durable = "true",type = ExchangeTypes.TOPIC),
                    key = RabbitMQConstants.ORDER_RECEIVE_QUEUE
            )
    })
    public void receiveMessage(Message message){
        System.out.println("=====订单信息receiveMessage(message)");
        System.out.println(message.getMessageProperties());
        System.out.println(new String(message.getBody()));
    }

}
