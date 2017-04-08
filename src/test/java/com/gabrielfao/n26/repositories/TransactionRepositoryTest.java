package com.gabrielfao.n26.validator.repositories;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielfao.n26.dto.StatisticsDTO;
import com.gabrielfao.n26.entities.Transaction;
import com.gabrielfao.n26.repositories.TransactionRepository;

@RunWith(SpringRunner.class)
public class TransactionRepositoryTest {
	
	@InjectMocks
	private TransactionRepository repository;
	
	private int quantityTransactions = 50;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testTransactionsCreationAndStatistics(){
		for(int i=1; i<= this.quantityTransactions; i++){
			repository.save(new Transaction(getAmount(), new Date()));
		}
		
		StatisticsDTO dto = this.repository.getStatistics();
		
		assertEquals(Long.valueOf(this.quantityTransactions), dto.getCount());
	}
		
	private Double getAmount(){
		return ThreadLocalRandom.current().nextDouble(0D, 250D);
	}

}
