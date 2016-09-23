package com.atsistemas.cern.lhcCollector.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.atsistemas.cern.model.DataPack;

@ConfigurationProperties(prefix="rabbitmq")
public class QueueManagerMapImpl implements QueueManager{

	private static Logger logger = LoggerFactory.getLogger(QueueManagerMapImpl.class);

	private Map<String,String> queueNames = new HashMap<>();

	public String getQueueName(DataPack dataPack) {
		
		logger.debug("--> QueueManagerMapImpl");
		logger.debug("--> getQueueName - task: {}", dataPack.getExperimentId());
		return queueNames.get(dataPack.getExperimentId());
	}

	public List<Queue> getQueueList() {

		List<Queue> queueList = new ArrayList<>();
		for(String key : queueNames.keySet()){
			queueList.add(new Queue(queueNames.get(key)));
		}
		return queueList;
	}

	public Map<String, String> getQueueNames() {
		return queueNames;
	}

}
