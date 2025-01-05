package com.stock.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	
	@KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
	public void consumeMessage(String msg) {
		System.out.println("Recived message at port 9090:"+msg);
	}

}
