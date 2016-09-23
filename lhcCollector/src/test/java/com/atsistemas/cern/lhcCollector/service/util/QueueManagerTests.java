package com.atsistemas.cern.lhcCollector.service.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atsistemas.cern.lhcCollector.Application;
import com.atsistemas.cern.lhcCollector.util.QueueManager;
import com.atsistemas.cern.model.DataPack;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class QueueManagerTests {

	private static Logger logger = LoggerFactory.getLogger(QueueManagerTests.class);
	
	@Autowired
	private QueueManager queueManager;
	
	@Test
	public void getQueueTest(){
		
		assertNotNull(queueManager);
		
		DataPack dataPack = new DataPack("atlas");
		
		String queue = queueManager.getQueueName(dataPack);
		
		assertNotNull(queue);
		logger.debug("--> experiment: {} - queue: {}",dataPack.getExperimentId(),queue);
		
	}
	
	@Test
	public void getQueueListTest(){
		
		assertNotNull(queueManager);
		
		List<Queue> queueList = queueManager.getQueueList();
		
		assertNotNull(queueList);
		logger.debug("--> queueList size: {}",queueList.size());
		
	}
	
	
}
