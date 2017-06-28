package com.stackroute.asmsgreceiver.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.asmsgreceiver.model.AsMessage;
import com.stackroute.asmsgreceiver.services.RouteCache;

@Service
public class Asmsgreceiver {
	
	private static final Logger log = LoggerFactory.getLogger(Asmsgreceiver.class);
	
	@Autowired
	private RouteCache rc;
	
	public void setRouteCache(RouteCache rc){
		this.rc = rc;
	}
		
	@KafkaListener(topics="${as.kafka.topic}")
    public void processMessage(AsMessage message) {
		log.info("{} => MMDU => {}", message, this.rc.getMmdclist(message.getCirclename()));
	}
}
