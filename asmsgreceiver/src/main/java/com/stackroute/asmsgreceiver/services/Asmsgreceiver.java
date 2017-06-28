package com.stackroute.asmsgreceiver.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.asmsgreceiver.model.AsMessage;

@Service
public class Asmsgreceiver {
	private static final Logger log = LoggerFactory.getLogger(Asmsgreceiver.class);
		
	@KafkaListener(topics="${as.kafka.topic}")
    public void processMessage(AsMessage message) {
		log.info("received content = {}", message);
	}
}
