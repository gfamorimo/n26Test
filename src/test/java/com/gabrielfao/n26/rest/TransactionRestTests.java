package com.gabrielfao.n26.rest;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielfao.n26.dto.StatisticsDTO;
import com.gabrielfao.n26.entities.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionRestTests {

	private final static String API_PATH = "/";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private int quantityTransactions = 50;
	
	@Test
	public void testValidator() {
		ResponseEntity<Transaction> responseEntity = this.restTemplate.postForEntity(API_PATH + "transactions",
				new Transaction(null, new Date()), Transaction.class);

		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}

	@Test
	public void testCreateTransactions() {
		//creating transactions with valid time (inside 60 seconds)
		for (int i = 1; i <= quantityTransactions; i++) {

			ResponseEntity<Transaction> responseEntity = this.restTemplate.postForEntity(API_PATH + "transactions",
					new Transaction(getAmount(), new Date()), Transaction.class);

			assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		}
		
		//trasactions with timestamp out of time
		for (int i = 1; i <= quantityTransactions; i++) {
			ResponseEntity<Transaction> responseEntity = this.restTemplate.postForEntity(API_PATH + "transactions",
					new Transaction(getAmount(), getDateOutOfLimit()), Transaction.class);

			assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		}
	}

	@Test
	public void testStatistics() {
		StatisticsDTO response = this.restTemplate.getForObject(API_PATH + "statistics", StatisticsDTO.class);
		
		assertEquals(quantityTransactions, response.getCount().intValue());
	}
	
	private Date getDateOutOfLimit(){
		LocalDateTime ldt = LocalDateTime.now().minusSeconds(61);
		Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}
	
	private Double getAmount(){
		return ThreadLocalRandom.current().nextDouble(0D, 250D);
	}

}
