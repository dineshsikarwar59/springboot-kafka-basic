package com.stock.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class MessageController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
    @Value("${myapp.kafka.topic}")
    private String topic;
	
	@GetMapping("send/{msg}")
	public String sendMessage(@PathVariable String msg) {
		kafkaTemplate.send(topic, msg);
		System.out.println("Kafka message sent:");
		return "message sent";
	}

}
