package com.erp.stm.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

@SuppressWarnings("serial")
@Alias("Inventory")
public class Inventory implements Serializable {

	private String depotId;

	private String commodityType;

	private BigDecimal averagePrice;

	private Float quantity;

	private BigDecimal amount;

	private BigDecimal taxAmt;

	private BigDecimal averageTaxRate;

	public String getDepotId() {
		return depotId;
	}

	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}

	public BigDecimal getAverageTaxRate() {
		return averageTaxRate;
	}

	public void setAverageTaxRate(BigDecimal averageTaxRate) {
		this.averageTaxRate = averageTaxRate;
	}

}
