package com.nsr.order.consumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class OrderConsumer {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("group.id", "OrderGroup");
		
		KafkaConsumer<String,Integer> consumer = new KafkaConsumer<String,Integer>(props);
		consumer.subscribe(Collections.singletonList("OrderTopic"));
		
		ConsumerRecords<String, Integer>  records = consumer.poll(Duration.ofSeconds(20));
		for(ConsumerRecord<String, Integer> record: records) {
			System.out.println("Record \t:"+record.key()+"\t"+record.value());
		}
		consumer.close();
		
	}

}
