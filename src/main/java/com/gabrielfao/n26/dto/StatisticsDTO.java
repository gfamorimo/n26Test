package com.gabrielfao.n26.dto;

public class StatisticsDTO {

	private Double sum;
	
	private Double avg;
	
	private Double max;
	
	private Double min;
	
	private Long count;
	
	public StatisticsDTO() {
		super();
	}

	/**
	 * @param sum
	 * @param avg
	 * @param max
	 * @param min
	 * @param count
	 */
	public StatisticsDTO(Double sum, Double avg, Double max, Double min, Long count) {
		super();
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public Double getSum() {
		return (this.sum != null)?this.sum:0D;
	}

	public void setSum(Double value) {
		this.sum = value;
	}

	public Double getAvg() {
		return (this.avg != null)?this.avg:0D;
	}

	public void setAvg(Double value) {
		this.avg = value;
	}

	public Double getMax() {
		return (this.max != null)?this.max:0D;
	}

	public void setMax(Double value) {
		this.max = value;
	}

	public Double getMin() {
		return (this.min != null)?this.min:0D;
	}

	public void setMin(Double value) {
		this.min = value;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long value) {
		this.count = value;
	}
}
