package com.atsistemas.cern.lhcCollector.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atsistemas.cern.lhcCollector.Application;
import com.atsistemas.cern.lhcCollector.service.DataDispatchService;
import com.atsistemas.cern.model.DataPack;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class DataDispatchServiceTests {

	@Autowired
	DataDispatchService dataDispatchService;
	
//	@Ignore
	@Test
	public void dispatchTaskTest(){
		
		int messagesNumber = 10;
		
		DataPack dataPack = new DataPack("atlas");
		
		for(int i = 0 ; i < messagesNumber; i++){
			
			dataDispatchService.dispatchData(dataPack);
		}
		
		
	}
}
