package com.soumyadeep.microservices.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	@KafkaListener(topics = "consumer-group")
		public void consumeWithSpecificPartition(ConsumerRecord<String, String> data) {
		LOGGER.info("Read Record is : " + data.value());
		LOGGER.info("Offset is : " + data.offset());
		LOGGER.info("Topic is : " + data.topic());
		LOGGER.info("Partition is : " + data.partition());
	}
}
