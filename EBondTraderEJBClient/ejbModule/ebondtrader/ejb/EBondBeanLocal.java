package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Local;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Customer;
import ebondtrader.jpa.Transaction;



@Local
public interface EBondBeanLocal {
	
	
	public void printing();
	public List<Customer> getCustomer();
	public List<Bond> getBondByCouponPeriodAndFitchRevised(String isin, String coupon_Period, String fitch);
	public List<Bond> getAllBonds();
	public void getTransactions(Transaction t);
	public List<Transaction> getAlltrs();
	public List<Bond> getBondByIsin(String isin);
	public List<Bond> getBondByCouponPeriod(String coupon_Period);
	public List<Bond> getAllBondsByDate();
	public List<Bond> getBondByIssuerName(String issuerName);
	//public int getOrderid();
	//public void addBonds(Bond2 b2);


}
