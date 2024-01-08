package com.nsr.order.orderproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class OrderProducer {

	public static void main(String[] args) {
		
		//1
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		
		//2
		KafkaProducer<String,Integer> producer = new KafkaProducer<String,Integer>(props);
		
		
		//3
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("OrderTopic", "Apple Ear POD:",100);
		ProducerRecord<String, Integer> record1 = new ProducerRecord<String, Integer>("OrderTopic", "Books:",130);
		ProducerRecord<String, Integer> record2 = new ProducerRecord<String, Integer>("OrderTopic", "Pen:",90);
		ProducerRecord<String, Integer> record3 = new ProducerRecord<String, Integer>("OrderTopic", "Mobile:",900);
		
		//4
		producer.send(record, new OrderCallback());
		producer.send(record1, new OrderCallback());
		producer.send(record2, new OrderCallback());
		producer.send(record3, new OrderCallback());
		//5
		producer.close();
	}

}
