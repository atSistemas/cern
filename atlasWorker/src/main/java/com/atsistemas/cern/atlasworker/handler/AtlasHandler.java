package com.atsistemas.cern.atlasworker.handler;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.atsistemas.cern.model.DataPack;

public class AtlasHandler {

	private static Logger logger = LoggerFactory.getLogger(AtlasHandler.class);
	
	
//	@Autowired
//	private DataPacktDao dataPackDao;
	
	public void handleMessage(DataPack dataPack) {
		
		logger.info("HandleMessage for dataPack with ExperimentId: {}",dataPack.getExperimentId());
		
		//TODO do something with dataPackDao
		
	}

}
