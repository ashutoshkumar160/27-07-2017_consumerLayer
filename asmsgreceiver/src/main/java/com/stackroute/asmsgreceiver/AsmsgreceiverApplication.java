package com.stackroute.asmsgreceiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stackroute.asmsgreceiver.services.Asmsgreceiver;

@SpringBootApplication
public class AsmsgreceiverApplication implements CommandLineRunner {

	@Autowired
	Asmsgreceiver consumer;

	/*@Autowired
	Asmsgsender producer;*/

	@Override
	public void run(String... args) throws Exception {
		/*long msgid = 0;
		for (int index = 0; index < 1000; index++) {
			for (int circleIndex = 1; circleIndex <= 5; circleIndex++) {
				AsMessage tmpMsg = new AsMessage(++msgid, "circle" + circleIndex, circleIndex, circleIndex,
						"Message " + circleIndex, 1);
				// producer.send(tmpMsg);
				producer.sendToTopic(tmpMsg);
				Thread.sleep(100);
			}
		}*/
	}

	public static void main(String[] args) {
		SpringApplication.run(AsmsgreceiverApplication.class, args);
	}
}
