package org.github.caishijun;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class UsingAvroSerializerInKafka3 {

    public static KafkaProducer usingAvroSerializerInKafka(){
        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",);
        kafkaPros.put("value.serializer",StringSerializer.class.getName());
    }

}
