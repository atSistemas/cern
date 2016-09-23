package com.atsistemas.cern.lhcCollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.cern.lhcCollector.service.DataDispatchService;
import com.atsistemas.cern.model.DataPack;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(value="/lhc-collector")
public class DispatchController {
	
	private static Logger logger = LoggerFactory.getLogger(DispatchController.class);
	
	@Autowired
	DataDispatchService dataDispatchService;
	
	@ApiOperation(value = "dispatchData", nickname = "dispatchData", response = String.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), 
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), 
			@ApiResponse(code = 500, message = "Failure") 
			})
	@RequestMapping(method = RequestMethod.POST, value = "dispatchData/")
	public void  dispatchData(@ApiParam(value = "dataPack", required = true) @RequestBody(required=true) DataPack dataPack){
		
		logger.debug("--> dispatchData: {}",dataPack.getId());
		dataDispatchService.dispatchData(dataPack);
	
}

}
