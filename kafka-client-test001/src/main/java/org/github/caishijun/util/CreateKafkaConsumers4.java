package org.github.caishijun.util;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.Properties;

public class CreateKafkaConsumers4 {

    /**
     * 创建 Kafka 消费者
     * @return
     */
    public static KafkaConsumer createKafkaConsumers(){
        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("group.id","CountryCounter");
        kafkaPros.put("key.deserializer",StringDeserializer.class.getName());
        kafkaPros.put("value.deserializer",StringDeserializer.class.getName());

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(kafkaPros);

        return consumer;
    }

}
