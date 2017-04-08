package com.gabrielfao.n26.repositories;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gabrielfao.n26.dto.StatisticsDTO;
import com.gabrielfao.n26.entities.Transaction;

@Service
public class TransactionRepository {

	private List<Transaction> transactions = new ArrayList<>();

	public void save(Transaction entity) {
		entity.setId(Long.valueOf(transactions.size()));

		transactions.add(entity);
	}

	public StatisticsDTO getStatistics() {
		StatisticsDTO dto = new StatisticsDTO();

		List<Transaction> transactionBetweenPeriod = this.transactions.stream()
				.filter(t -> t.getTimestamp().after(getDateLimit())).collect(Collectors.toList());
		
		dto.setCount(Long.valueOf(transactionBetweenPeriod.size()));
		dto.setSum(transactionBetweenPeriod.stream().mapToDouble(t -> t.getAmount()).sum());
		dto.setMax(transactionBetweenPeriod.stream().mapToDouble(t -> t.getAmount()).max().orElse(0D));
		dto.setMin(transactionBetweenPeriod.stream().mapToDouble(t -> t.getAmount()).min().orElse(0D));
		dto.setAvg(dto.getSum().equals(0D)?0D:dto.getSum()/dto.getCount());

		return dto;
	}
	
	private Date getDateLimit(){
		LocalDateTime ldt = LocalDateTime.now().minusSeconds(60);
		Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

}
