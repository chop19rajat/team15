package ebondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bond database table.
 * 
 */
@Entity
@NamedQuery(name="Bond.findAll", query="SELECT b FROM Bond b")
public class Bond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float change;

	@Column(name="`Coupon Period`")
	private String couponPeriod;

	@Column(name="`Coupon Rate`")
	private float couponRate;

	private String currency;

	private String fitch;

	private float high;

	private String isin;

	@Column(name="`Issuer Name`")
	private String issuerName;

	private float last;

	private float low;

	@Column(name="`Maturity Date`")
	private String maturityDate;

	@Column(name="`Moody's`")
	private String moodyS;

	private int pieceSize;

	@Column(name="`S&P`")
	private String sp;

	@Column(name="`Start Date`")
	private String startDate;

	private float yield;

	public Bond() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getChange() {
		return this.change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public String getCoupon_Period() {
		return this.couponPeriod;
	}

	public void setCoupon_Period(String coupon_Period) {
		this.couponPeriod = coupon_Period;
	}

	public float getCoupon_Rate() {
		return this.couponRate;
	}

	public void setCoupon_Rate(float coupon_Rate) {
		this.couponRate = coupon_Rate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFitch() {
		return this.fitch;
	}

	public void setFitch(String fitch) {
		this.fitch = fitch;
	}

	public float getHigh() {
		return this.high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public String getIsin() {
		return this.isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getIssuer_Name() {
		return this.issuerName;
	}

	public void setIssuer_Name(String issuer_Name) {
		this.issuerName = issuer_Name;
	}

	public float getLast() {
		return this.last;
	}

	public void setLast(float last) {
		this.last = last;
	}

	public float getLow() {
		return this.low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public String getMaturity_Date() {
		return this.maturityDate;
	}

	public void setMaturity_Date(String maturity_Date) {
		this.maturityDate = maturity_Date;
	}

	public String getMoody_s() {
		return this.moodyS;
	}

	public void setMoody_s(String moody_s) {
		this.moodyS = moody_s;
	}

	public int getPieceSize() {
		return this.pieceSize;
	}

	public void setPieceSize(int pieceSize) {
		this.pieceSize = pieceSize;
	}

	public String getS_p() {
		return this.sp;
	}

	public void setS_p(String s_p) {
		this.sp = s_p;
	}

	public String getStart_Date() {
		return this.startDate;
	}

	public void setStart_Date(String start_Date) {
		this.startDate = start_Date;
	}

	public float getYield() {
		return this.yield;
	}

	public void setYield(float yield) {
		this.yield = yield;
	}

}