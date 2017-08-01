package com.stackroute.asmsgreceiver.services;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.asmsgreceiver.model.AsMessage;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AsmsgsenderTest {

	private static String TOPIC = "test-1";

	@Autowired
	private Asmsgsender sender;

	@Value("${as.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Autowired
	KafkaTemplate<String, AsMessage> kT;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("bootstrapServer", embeddedKafka.getBrokersAsString());
	}

	@Test
	public void testSender() throws Exception {
		// sender part test.
		AsMessage asm = new AsMessage();
		sender.send(TOPIC, asm);
		// receiving part test
		// receiver.getLatch().await(100, TimeUnit.MILLISECONDS);
		// assertThat(receiver.getLatch().getCount()).isEqualTo(1);
	}

}
