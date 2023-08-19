package com.nsr.order.consumer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallback implements Callback {

	public void onCompletion(RecordMetadata recordMetadata, Exception arg1) {
		System.out.println("Partition \t"+recordMetadata.partition());
		System.out.println("Topic \t"+recordMetadata.topic());
		System.out.println("Message Sent Successfulyy..");
	}

}
