package com.springbootex.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootex.domain.PCFDomain;
import com.springbootex.service.PCFService;

@RestController
@RequestMapping("/pcf-details")
public class PCFController {
	
	@Autowired
	private PCFService pcfService;
	
	@RequestMapping("/{pcfid}")
	public ResponseEntity<?> getPCFDetails(@PathVariable(value="pcfid") String pcfId) {
		PCFDomain pcfDomain = pcfService.getPCFDetails(pcfId);
		if(Optional.ofNullable(pcfDomain).isPresent()) {
			return new ResponseEntity<PCFDomain>(pcfDomain, HttpStatus.OK);
		}
		return new ResponseEntity<String>("unable find pcf domain details", HttpStatus.NOT_FOUND);
	}
	
	/*@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<String> savePCFDetails(@RequestBody PCFDomain pcfDomain){
		PCFDomain response = pcfService.savePcfDetails(pcfDomain);
		if(Optional.ofNullable(response).isPresent()) {
			return new ResponseEntity<String>("pcfdomain details saved " +response.toString(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("unable save pcf domain details", HttpStatus.NOT_FOUND);
	}*/
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<String> savePCFDetails(@RequestBody PCFDomain pcfDomain){
		String response = pcfService.savePcfDetails(pcfDomain);
		return new ResponseEntity<String>("pcfdomain details saved " +response.toString(), HttpStatus.OK);
	}

}
