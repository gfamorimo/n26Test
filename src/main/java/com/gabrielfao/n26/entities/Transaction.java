package com.gabrielfao.n26.entities;

import java.util.Date;

public class Transaction {
	
	private Long id;
	
	private Double amount;
	
	private Date timestamp;
	
	public Transaction() {
		super();
	}
	
	/**
	 * @param amount
	 * @param timestamp
	 */
	public Transaction(Double amount, Date timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double value) {
		this.amount = value;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date value) {
		this.timestamp = value;
	}

}
