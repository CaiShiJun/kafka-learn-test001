package org.github.caishijun;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 创建 Kafka 生产者
 *
 * bootstrap.servers
 *
 * 	该属性指定 broker 的地址清单，地址的格式为 host:port 。清单里不需要包含所有的 broker 地址，生产者会从给定的 broker 里查找到其他 broker 的信息。不过建议至少要提供两个 broker 的信息，一旦其中一个宕机，生产者仍然能够连接到集群上。
 *
 * key.serializer
 *
 * 	broker 希望接收到的消息的键和值都是字节数组。生产者接口允许使用参数化类型，因此可以把 Java 对象作为键和值发送给 broker 。这样的代码具有良好的可读性，不过生产者需要知道如何把这些 Java 对象转换成字节数组。 key.serializer 必须被设置为一个实现了 org.apache.kafka.common.serialization.Serializer 接口的类，生产者会使用这个类把键对象序列化成字节数组。Kafka 客户端默认提供了  ByteArraySerializer（这个只做很少的事情）、StringSerializer 和 IntegerSerializer ，因此，如果你只使用常见的几种 Java 对象类型，那么就没必要实现自己的序列化器。要注意，key.serializer  是必须设置的，就算你打算只发送值内容。
 *
 * value.serializer
 *
 * 	与 key.serializer 一样， value.serializer 指定的类会将值序列化。如果键和值都是字符串，可以使用与 key.serializer 一样的序列化器。如果键是整数类型而值是字符串，那么需要使用不同的序列化器。
 */
public class CreateKafkaProducers1 {

    public static KafkaProducer CreateKafkaProducer(){
        Properties kafkaPros = new Properties();
        kafkaPros.put("bootstrap.servers","192.168.228.132:9092,192.168.228.133:9092,192.168.228.134:9092");
        kafkaPros.put("key.serializer",StringSerializer.class.getName());
        kafkaPros.put("value.serializer",StringSerializer.class.getName());

        KafkaProducer producer = new KafkaProducer(kafkaPros);
        return producer;
    }

}
