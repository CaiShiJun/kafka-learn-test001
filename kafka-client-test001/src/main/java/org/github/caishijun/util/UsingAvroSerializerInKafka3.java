package org.github.caishijun.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.github.caishijun.entity.Customer;
import java.util.Properties;

public class UsingAvroSerializerInKafka3 {


    public static KafkaProducer usingAvroSerializerInKafka(){

        String schemaUrl = null;
        String topic = "customerContacts";

        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",io.confluent.kafka.serializers.KafkaAvroSerializer.class.getName());
        kafkaPros.put("value.serializer",io.confluent.kafka.serializers.KafkaAvroSerializer.class.getName());
        kafkaPros.put("schema.registry.url",schemaUrl);

        Producer<String,Customer> producer = new KafkaProducer<String, Customer>(kafkaPros);

        //不断生成事件
        while (true){
            Customer customer = new Customer(1,"caishijun1");
            System.out.println(customer);
            ProducerRecord<String,Customer> record = new ProducerRecord<String, Customer>(topic,String.valueOf(customer.getCustomerID()),customer);

            producer.send(record);
        }

    }

}