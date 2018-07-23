package org.github.caishijun.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PollingConsumption6 {

    /**
     * 轮询消费
     */
    public static void pollingConsumption(){

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("group.id","CountryCounter");
        kafkaPros.put("key.deserializer",StringDeserializer.class.getName());
        kafkaPros.put("value.deserializer",StringDeserializer.class.getName());

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(kafkaPros);

        consumer.subscribe(Collections.singletonList("CustomerCountry"));     //要订阅所有与 test 相关的主题，可以这样写：consumer.subscribe("test.*");

        Map custCountryMap = new HashMap();

        try {
            while(true){
                ConsumerRecords<String,String> records = consumer.poll(1000);
                for(ConsumerRecord<String,String> record : records){
                    System.out.println("topic："+record.topic());
                    System.out.println("partition："+record.partition());
                    System.out.println("offset："+record.offset());
                    System.out.println("key："+record.key());
                    System.out.println("value："+record.value());

                   /*
                        业务逻辑处理
                    */
                }
            }
        }finally {
            consumer.close();
        }
    }
}
