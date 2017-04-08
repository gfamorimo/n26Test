package com.gabrielfao.n26.validator;

import org.springframework.stereotype.Component;

import com.gabrielfao.n26.entities.Transaction;
import com.gabrielfao.n26.exceptions.ValidatorException;

@Component
public class TransactionValidator {
	
	public void validate(Transaction entity){
		if(entity != null){
			if(entity.getAmount() == null){
				throw new ValidatorException();
			}
			
			if(entity.getTimestamp() == null){
				throw new ValidatorException();
			}
		}else{
			throw new ValidatorException();
		}
	}

}
