package ebondtrader.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	private int bondDuration;

	private float changePrice;

	private String couponPeriod;

	private float couponRate;

	private String currency;

	private float currentYield;

	private String fitch;

	private float high;

	private String isin;

	private String issuerName;

	private float lastPrice;

	private float low;

	@Temporal(TemporalType.TIMESTAMP)
	private Date maturityDate;

	private String moodys;

	private float pieceSize;

	private String snp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	public Bond() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBondDuration() {
		return this.bondDuration;
	}

	public void setBondDuration(int bondDuration) {
		this.bondDuration = bondDuration;
	}

	public float getChangePrice() {
		return this.changePrice;
	}

	public void setChangePrice(float changePrice) {
		this.changePrice = changePrice;
	}

	public String getCouponPeriod() {
		return this.couponPeriod;
	}

	public void setCouponPeriod(String couponPeriod) {
		this.couponPeriod = couponPeriod;
	}

	public float getCouponRate() {
		return this.couponRate;
	}

	public void setCouponRate(float couponRate) {
		this.couponRate = couponRate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getCurrentYield() {
		return this.currentYield;
	}

	public void setCurrentYield(float currentYield) {
		this.currentYield = currentYield;
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

	public String getIssuerName() {
		return this.issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public float getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(float lastPrice) {
		this.lastPrice = lastPrice;
	}

	public float getLow() {
		return this.low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public Date getMaturityDate() {
		return this.maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getMoodys() {
		return this.moodys;
	}

	public void setMoodys(String moodys) {
		this.moodys = moodys;
	}

	public float getPieceSize() {
		return this.pieceSize;
	}

	public void setPieceSize(float pieceSize) {
		this.pieceSize = pieceSize;
	}

	public String getSnp() {
		return this.snp;
	}

	public void setSnp(String snp) {
		this.snp = snp;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}