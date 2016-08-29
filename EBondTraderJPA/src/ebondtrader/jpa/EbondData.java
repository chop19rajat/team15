package ebondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ebond_data database table.
 * 
 */
@Entity
@Table(name="ebond_data")
@NamedQuery(name="EbondData.findAll", query="SELECT e FROM EbondData e")
public class EbondData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float change;

	@Column(name="`Coupon Period`")
	private String coupon_Period;

	@Column(name="`Coupon Rate`")
	private float coupon_Rate;

	private String currency;

	private String fitch;

	private float high;

	private String isin;

	@Column(name="`Issuer Name`")
	private String issuer_Name;

	private float last;

	private float low;

	@Column(name="`Maurity Date`")
	private String maurity_Date;

	@Column(name="`Moody's`")
	private String moody_s;

	@Column(name="`Piece Size`")
	private String piece_Size;

	@Column(name="`S&P`")
	private String s_p;

	@Column(name="`Start Date`")
	private String start_Date;

	private float yield;

	public EbondData() {
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
		return this.coupon_Period;
	}

	public void setCoupon_Period(String coupon_Period) {
		this.coupon_Period = coupon_Period;
	}

	public float getCoupon_Rate() {
		return this.coupon_Rate;
	}

	public void setCoupon_Rate(float coupon_Rate) {
		this.coupon_Rate = coupon_Rate;
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
		return this.issuer_Name;
	}

	public void setIssuer_Name(String issuer_Name) {
		this.issuer_Name = issuer_Name;
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

	public String getMaurity_Date() {
		return this.maurity_Date;
	}

	public void setMaurity_Date(String maurity_Date) {
		this.maurity_Date = maurity_Date;
	}

	public String getMoody_s() {
		return this.moody_s;
	}

	public void setMoody_s(String moody_s) {
		this.moody_s = moody_s;
	}

	public String getPiece_Size() {
		return this.piece_Size;
	}

	public void setPiece_Size(String piece_Size) {
		this.piece_Size = piece_Size;
	}

	public String getS_p() {
		return this.s_p;
	}

	public void setS_p(String s_p) {
		this.s_p = s_p;
	}

	public String getStart_Date() {
		return this.start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public float getYield() {
		return this.yield;
	}

	public void setYield(float yield) {
		this.yield = yield;
	}

}