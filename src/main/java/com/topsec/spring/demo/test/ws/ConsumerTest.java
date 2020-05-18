package com.topsec.spring.demo.test.ws;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.config.SslConfigs;

import java.util.Collections;
import java.util.Properties;

/**
 * @Author: G.J
 * @Date: 2019/12/10 16:23
 */
public class ConsumerTest {
    private static final String KAFKA_TOPIC = "topsec";
    private static final String KAFKA_GROUP_ID = "test";
    private static final String BOOTSTRAP_SERVER = "docker31:9092,docker32:9092,docker33:9092";

    public static void main(String[] args) {
        consumer();
    }

    private static void consumer() {
        Properties props = new Properties();
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
        props.put(SslConfigs.DEFAULT_SSL_TRUSTSTORE_TYPE,"JKS");
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "C:\\Users\\trx_gk\\Desktop\\certification\\ca\\trust\\client.truststore.jks");
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "hadoop");

        // SSL用户认证
        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "C:\\Users\\trx_gk\\Desktop\\certification\\ca\\client\\client.keystore.jks");
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "hadoop");
        props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "hadoop");


        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        props.put(ConsumerConfig.GROUP_ID_CONFIG,KAFKA_GROUP_ID);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "2000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "6000");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Collections.singletonList(KAFKA_TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(2000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s, partition = %d %n",
                        record.offset(),
                        record.key(),
                        record.value(),
                        record.partition());
            }
        }
    }
}