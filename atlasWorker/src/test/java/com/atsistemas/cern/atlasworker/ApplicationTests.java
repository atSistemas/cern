package com.atsistemas.cern.atlasworker;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atsistemas.cern.atlasworker.Application;



@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Test
//	@Ignore
	public void contextLoads() {
		
		logger.debug("--> contextLoads");
		
		
	}

}
