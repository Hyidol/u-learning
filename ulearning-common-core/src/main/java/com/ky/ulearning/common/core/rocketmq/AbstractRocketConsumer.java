package com.ky.ulearning.common.core.rocketmq;

import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * 消费者基础信息
 *
 * @author luyuhao
 * @since 2020/3/25 20:37
 */
public abstract class AbstractRocketConsumer implements RocketConsumer {

    private String topics;
    private String tags;
    private MessageListenerConcurrently messageListenerConcurrently;
    private String consumerTitle;
    private MQPushConsumer mqPushConsumer;
    private MessageModel messageModel;
    private Integer consumeMessageBatchMaxSize;

    /**
     * 必要的信息
     *
     * @param topics        主题
     * @param tags          标签
     * @param consumerTitle 标题
     */
    public void necessary(String topics, String tags, String consumerTitle) {
        this.topics = topics;
        this.tags = tags;
        this.consumerTitle = consumerTitle;
        this.messageModel = MessageModel.CLUSTERING;
        this.consumeMessageBatchMaxSize = 1;
    }

    @Override
    public abstract void init();

    @Override
    public void registerMessageListener(MessageListenerConcurrently messageListenerConcurrently) {
        this.messageListenerConcurrently = messageListenerConcurrently;
    }

    public String getTopics() {
        return topics;
    }

    public String getTags() {
        return tags;
    }

    public MessageListenerConcurrently getMessageListenerConcurrently() {
        return messageListenerConcurrently;
    }

    public String getConsumerTitle() {
        return consumerTitle;
    }

    public void setMqPushConsumer(MQPushConsumer mqPushConsumer) {
        this.mqPushConsumer = mqPushConsumer;
    }

    public MessageModel getMessageModel() {
        return messageModel;
    }

    public Integer getConsumeMessageBatchMaxSize() {
        return consumeMessageBatchMaxSize;
    }

    public void setMessageModel(MessageModel messageModel) {
        this.messageModel = messageModel;
    }

    public void setConsumeMessageBatchMaxSize(Integer consumeMessageBatchMaxSize) {
        this.consumeMessageBatchMaxSize = consumeMessageBatchMaxSize;
    }
}
