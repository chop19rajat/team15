package ebondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int orderId;

	private BigDecimal accruedAmount;

	private BigDecimal cleanPrice;

	private BigDecimal dirtyPrice;

	private String isin;

	private BigDecimal settlementAmount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date settlementDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tradeDate;

	
	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	private BigDecimal tradeYield;

	public Transaction() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getAccruedAmount() {
		return this.accruedAmount;
	}

	public void setAccruedAmount(BigDecimal accruedAmount) {
		this.accruedAmount = accruedAmount;
	}

	public BigDecimal getCleanPrice() {
		return this.cleanPrice;
	}

	public void setCleanPrice(BigDecimal cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public BigDecimal getDirtyPrice() {
		return this.dirtyPrice;
	}

	public void setDirtyPrice(BigDecimal dirtyPrice) {
		this.dirtyPrice = dirtyPrice;
	}

	public String getIsin() {
		return this.isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public BigDecimal getSettlementAmount() {
		return this.settlementAmount;
	}

	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public Date getSettlementDate() {
		return this.settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public BigDecimal getTradeYield() {
		return this.tradeYield;
	}

	public void setTradeYield(BigDecimal tradeYield) {
		this.tradeYield = tradeYield;
	}

}