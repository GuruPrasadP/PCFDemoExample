package com.springbootex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootex.domain.PCFDomain;
import com.springbootex.repository.PCFRepository;

@Service
public class PCFService {
	
	@Autowired
	private PCFRepository pcfRepository;

	public PCFDomain getPCFDetails(String pcfId) {
		return pcfRepository.findOne(pcfId);
	}

	/*public PCFDomain savePcfDetails(PCFDomain pcfDomain) {
		return pcfRepository.save(pcfDomain);
	}*/
	
	public String savePcfDetails(PCFDomain pcfDomain) {
		return pcfRepository.save(pcfDomain);
	}

}
