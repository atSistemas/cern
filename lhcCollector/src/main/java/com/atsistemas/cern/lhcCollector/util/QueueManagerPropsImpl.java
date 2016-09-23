package com.atsistemas.cern.lhcCollector.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.atsistemas.cern.model.DataPack;

@ConfigurationProperties(prefix="rabbitmq")
public class QueueManagerPropsImpl implements QueueManager{

	private static Logger logger = LoggerFactory.getLogger(QueueManagerPropsImpl.class);

	private Properties queueNames;

	public String getQueueName(DataPack dataPack) {

		logger.debug("--> QueueManagerPropsImpl");
		logger.debug("--> getQueueName - task: {}", dataPack.getExperimentId());
		return queueNames.getProperty(dataPack.getExperimentId());
	}

	public List<Queue> getQueueList() {

		List<Queue> queueList = new ArrayList<>();
		Enumeration<?> propertyNames = queueNames.propertyNames();

		while (propertyNames.hasMoreElements()) {
			String key = (String) propertyNames.nextElement();
			queueList.add(new Queue(queueNames.getProperty(key)));
		}
		return queueList;
	}

	 public void setQueueNames(Properties queueNames) {
	 this.queueNames = queueNames;
	 }
	
	 public Properties getQueueNames() {
	 return queueNames;
	 }

}
