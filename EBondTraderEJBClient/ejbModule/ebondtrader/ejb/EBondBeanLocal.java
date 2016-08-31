package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Local;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Customer;
import ebondtrader.jpa.Transaction;



@Local
public interface EBondBeanLocal {
	
	
	
	public List<Customer> getCustomer();
	public List<Bond> getBondByFilter(String isin, String couponPeriod, String fitch,String moodys,String snp,String issuerName,String currentYield);
	public List<Bond> getAllBonds();
	public void updateHistory(Transaction t);
	public List<Transaction> getOrderHistory();
	
	//public List<Bond> getBondByIsin(String isin);
	//public List<Bond> getBondByCouponPeriod(String couponPeriod);
	//public List<Bond> getAllBondsByDate();
	//public List<Bond> getBondByIssuerName(String issuerName);
	//public int getOrderid();
	//public void addBonds(Bond2 b2);
	//public List<Bond> getBondByCouponPeriodAndFitchRevised(String isin, String couponPeriod, String fitch,String moodys,String snp);


}
