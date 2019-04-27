package com.xiaofeng.pro.common.constant;

/**
 * @Author: Xiaofeng
 * @Date: 2019/4/27 9:56
 * @Description: 定义RabbitMQ相关的Exchange、Topic Queue相关的常量名称等信息
 */
public class RabbitMQConstants {

    /** start: topic exchange 示例*/
    /** 机构相关信息配置 */
    // topic exchange名称
    public static final String ORGANIZTION_TOPIC_EXCHANGE = "xiaofeng.organization.topic.exchange";
    // 消息队列名称——接收
    public static final String ORGANIZATION_RECEIVE_QUEUE = "xiaofeng.organization.topic.receive";
    // 消息队列名称——发送
    public static final String ORGANIZATION_SEND_QUEUE = "xiaofeng.organization.topic.send";

    /** 订单相关信息配置 */
    // topic exchange名称
    public static final String ORDER_TOPIC_EXCHANGE = "xiaofeng.order.topic.exchange";
    // 消息队列名称——接收
    public static final String ORDER_RECEIVE_QUEUE = "xiaofeng.order.topic.receive";
    // 消息队列名称——发送
    public static final String ORDER_SEND_QUEUE = "xiaofeng.order.topic.send";
    /** end: topic exchange 示例*/

    /** start: Fanout Exchange队列示例 */
    public static final String TEST_FANOUT_EXCHANGE = "xiaofeng.test.fanout.exchange";
    public static final String TEST_FANOUT_RECEIVE_QUEUE1 = "xiaofeng.test.fanout.receive.queue1";
    public static final String TEST_FANOUT_RECEIVE_QUEUE2 = "xiaofeng.test.fanout.receive.queue2";
    public static final String TEST_FANOUT_SEND_QUEUE = "xiaofeng.test.fanout.send.queue2";
    /** end: Fanout Exchange队列示例 */

}
