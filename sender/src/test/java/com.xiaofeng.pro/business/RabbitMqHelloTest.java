package com.xiaofeng.pro.business;

import com.alibaba.druid.support.json.JSONUtils;
import com.xiaofeng.pro.common.constant.RabbitMQConstants;
import com.xiaofeng.pro.common.utils.JsonUtil;
import com.xiaofeng.pro.common.utils.SpringUtils;
import com.xiaofeng.pro.entity.Organization;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Xiaofeng
 * @Date: 2019/3/22 20:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqHelloTest.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendOrganiztionMsg(){
        Organization o = new Organization();
        o.setAddress("dddd小请安了");
        rabbitTemplate.convertAndSend(RabbitMQConstants.ORGANIZTION_TOPIC_EXCHANGE, RabbitMQConstants.ORGANIZATION_RECEIVE_QUEUE, JsonUtil.objectToJson(o));
    }

    @Test
    public void testSendOrderMsg(){
        String msg = "this is a order msg";
        rabbitTemplate.convertAndSend(RabbitMQConstants.ORGANIZTION_TOPIC_EXCHANGE, RabbitMQConstants.ORGANIZATION_RECEIVE_QUEUE, msg);
    }

    @Test
    public void testSendFanoutMsg(){
        String msg = "this is a fanout msg";
        rabbitTemplate.convertAndSend(RabbitMQConstants.TEST_FANOUT_EXCHANGE, "", msg);
    }
}
