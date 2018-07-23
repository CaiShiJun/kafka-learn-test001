package org.github.caishijun.util;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class SubscribeTopic5 {

    /**
     * 订阅主题
     */
    public static KafkaConsumer subscribeTopic(){

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("group.id","CountryCounter");
        kafkaPros.put("key.deserializer",StringDeserializer.class.getName());
        kafkaPros.put("value.deserializer",StringDeserializer.class.getName());

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(kafkaPros);

        consumer.subscribe(Collections.singletonList("customerCountries"));     //要订阅所有与 test 相关的主题，可以这样写：consumer.subscribe("test.*");
        return consumer;
    }

}
