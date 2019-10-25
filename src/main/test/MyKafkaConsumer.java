
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Kerven-HAN on 2019/10/22 11:41.
 * Talk is cheap , show me the code
 */
public class MyKafkaConsumer {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "xl.kafka8.coocaa.com:6667,xl.kafka9.coocaa.com:6667,xl.kafka10.coocaa.com:6667,xl.kafka11.coocaa.com:6667,xl.kafka12.coocaa.com:6667,xl.kafka13.coocaa.com:6667,xl.kafka14.coocaa.com:6667");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("video_online"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records){
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }

        }
    }

}
