package com.atsistemas.cern.lhcCollector.util;

import java.util.List;

import org.springframework.amqp.core.Queue;

import com.atsistemas.cern.model.DataPack;


public interface QueueManager {

	public String getQueueName(DataPack dataPack);
	
	public List<Queue> getQueueList();
	
}
