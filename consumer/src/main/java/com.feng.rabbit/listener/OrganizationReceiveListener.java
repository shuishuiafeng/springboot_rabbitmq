package com.feng.rabbit.listener;

import com.feng.rabbit.constant.RabbitMQConstants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiaofeng
 * @Date: 2019/4/27 11:12
 * @Description: 机构接收信息监听和处理
 */
@Component
public class OrganizationReceiveListener {

    /**
     * 通过queues参数设置一个或多个队列监听
     * @RabbitListener(queues = RabbitMQConstants.ORDER_RECEIVE_QUEUE)
     * @RabbitListener(queues = {RabbitMQConstants.ORDER_RECEIVE_QUEUE,ORDER_RECEIVE_QUEUE })
     * 下面的具体使用的是通过binding声明监听队列,bindings和queues不能共存
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = RabbitMQConstants.ORGANIZATION_RECEIVE_QUEUE, durable = "true"),
                    exchange = @Exchange(value = RabbitMQConstants.ORGANIZTION_TOPIC_EXCHANGE, durable = "true"),
                    key = RabbitMQConstants.ORGANIZATION_RECEIVE_QUEUE
            )
    })
    public void receiveMessage(Message message){
        System.out.println("=====机构消费信息receiveMessage(message)");
        System.out.println(message.getMessageProperties());
        System.out.println(new String(message.getBody()));
    }

//    @RabbitListener(...)
//    public void receiveMessage(@Payload String body, @Header String token){
//        System.out.println("=====机构消费信息receiveMessage(body,token)");
//        System.out.println(body);
//        System.out.println(token);
//    }
}
