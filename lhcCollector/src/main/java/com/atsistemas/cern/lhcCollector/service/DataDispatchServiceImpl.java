package com.atsistemas.cern.lhcCollector.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.cern.lhcCollector.util.QueueManager;
import com.atsistemas.cern.model.DataPack;


@Service
public class DataDispatchServiceImpl implements DataDispatchService {

	@Autowired
	public RabbitTemplate rabbitTemplate;
	
	@Autowired
	public QueueManager queueManager;
	
	
	@Override
	public void dispatchData(DataPack dataPack) {

		rabbitTemplate.convertAndSend(queueManager.getQueueName(dataPack),dataPack);
	}

	
}
