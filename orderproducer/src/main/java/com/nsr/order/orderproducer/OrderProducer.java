package com.nsr.order.orderproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class OrderProducer {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		
		KafkaProducer<String,Integer> producer = new KafkaProducer<String,Integer>(props);
		
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("OrderTopic", "Apple Ear POD:",100);
		ProducerRecord<String, Integer> record1 = new ProducerRecord<String, Integer>("OrderTopic", "Books:",130);
		ProducerRecord<String, Integer> record2 = new ProducerRecord<String, Integer>("OrderTopic", "Pen:",90);
		producer.send(record, new OrderCallback());
		producer.send(record1, new OrderCallback());
		producer.send(record2, new OrderCallback());
		producer.close();
	}

}
