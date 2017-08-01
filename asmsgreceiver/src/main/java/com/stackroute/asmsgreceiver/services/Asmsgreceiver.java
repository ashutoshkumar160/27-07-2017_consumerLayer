package com.stackroute.asmsgreceiver.services;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.asmsgreceiver.model.AsMessage;

@Service
public class Asmsgreceiver {

	private static Logger log = LoggerFactory.getLogger(Asmsgreceiver.class);
	
	@Autowired
	private RouteCache rc;

	@Autowired
	Asmsgsender producer;

	public void setRouteCache(RouteCache rc) {
		this.rc = rc;
	}

	// only for testing purpose latch is used here.
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${as.kafka.topic}")
	public void processMessage(AsMessage message) {
		ArrayList<String> mmduList = this.rc.getMmdclist(message.getCirclename());
		log.info("{} => MMDU => {}", message, mmduList);
		for (int index = 0; index < mmduList.size(); index++) {
			producer.send(mmduList.get(index), message);
		}
	}
}
