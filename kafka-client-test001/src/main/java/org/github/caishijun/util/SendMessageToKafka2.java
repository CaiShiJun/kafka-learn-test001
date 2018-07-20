package org.github.caishijun.util;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class SendMessageToKafka2 {

    /**
     * 最简单的消息发送方式
     * @param producer
     */
    public static void sendMessageToKafka(KafkaProducer producer) {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Producer", "France");

        producer.send(record);

    }

    /**
     * 同步发送消息
     * @param producer
     */
    public static void synchronousSendMessage(KafkaProducer producer) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Producer", "France");

        try {
            producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步发送消息
     * @param producer
     */
    public static void asynchronousSendMessage(KafkaProducer producer) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Producer", "France");

        producer.send(record, new org.apache.kafka.clients.producer.Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null){
                    e.printStackTrace();
                }
            }
        });
    }

}