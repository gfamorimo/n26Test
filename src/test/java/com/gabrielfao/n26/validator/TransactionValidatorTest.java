package com.gabrielfao.n26.validator;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielfao.n26.entities.Transaction;
import com.gabrielfao.n26.exceptions.ValidatorException;

@RunWith(SpringRunner.class)
public class TransactionValidatorTest {
	
	@InjectMocks
	private TransactionValidator validator;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidTransaction(){
		Transaction t = new Transaction(10D, new Date());
		
		validator.validate(t);
	}
	
	@Test(expected=ValidatorException.class)
	public void testNotValidTransaction(){
		Transaction t = new Transaction(null, new Date());
		
		validator.validate(t);
	}

}
