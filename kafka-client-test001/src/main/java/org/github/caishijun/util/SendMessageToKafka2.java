package org.github.caishijun.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SendMessageToKafka2 {

    //最简单的消息发送方式
    public static void sendMessageToKafka() {

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",StringSerializer.class.getName());
        kafkaPros.put("value.serializer",StringSerializer.class.getName());

        KafkaProducer producer = new KafkaProducer(kafkaPros);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Producer", "France");

        producer.send(record);

    }

    //同步发送消息
    public static void synchronousSendMessage() {

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",StringSerializer.class.getName());
        kafkaPros.put("value.serializer",StringSerializer.class.getName());

        KafkaProducer producer = new KafkaProducer(kafkaPros);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("CustomerCountry", "Precision Producer", "France");

        try {
            producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //异步发送消息
    public static void asynchronousSendMessage() {

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",StringSerializer.class.getName());
        kafkaPros.put("value.serializer",StringSerializer.class.getName());

        KafkaProducer producer = new KafkaProducer(kafkaPros);

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