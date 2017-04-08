package com.gabrielfao.n26.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfao.n26.dto.StatisticsDTO;
import com.gabrielfao.n26.entities.Transaction;
import com.gabrielfao.n26.repositories.TransactionRepository;
import com.gabrielfao.n26.validator.TransactionValidator;

@RestController
public class TransactionRest {
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private TransactionValidator validator;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/transactions", method = RequestMethod.POST)
	public void createTransaction(@RequestBody Transaction entity){
		validator.validate(entity);
		
		repository.save(entity);
	}
	
	@RequestMapping(path="/statistics", method = RequestMethod.GET)
	public StatisticsDTO getStatistics(){
		return repository.getStatistics();
	}

}
