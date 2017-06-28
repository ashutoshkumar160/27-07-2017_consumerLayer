package com.stackroute.asmsgsender;

import com.stackroute.asmsgsender.services.Asmsgsender;
import com.stackroute.asmsgsender.model.AsMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsmsgsenderApplication implements CommandLineRunner {
	
	@Autowired
	Asmsgsender producer;
	
	@Override
	public void run(String... args) throws Exception {
		long msgid = 0;
		for(int index=0; index < 1000; index++) {
			for(int circleIndex=1; circleIndex <= 5; circleIndex++) {
				AsMessage tmpMsg = new AsMessage(++msgid, "circle" + circleIndex, circleIndex, circleIndex, "Message " + circleIndex, 1);
				producer.send(tmpMsg);
				Thread.sleep(100);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AsmsgsenderApplication.class, args);
	}
}
