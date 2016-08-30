package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Local;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Products;
import ebondtrader.jpa.Transaction;



@Local
public interface EBondBeanLocal {
	
	
	public void printing();
	
	public List<Bond> getAllBonds();
	public void getTransactions(Transaction t);
	public List<Transaction> getAlltrs();
	public List<Bond> getBondByIsin(String isin);
	public List<Bond> getBondByCouponPeriod(String coupon_Period);
	public List<Bond> getAllBondsByDate();
	public List<Bond> getBondBeforeMaturityDate(String filter);
	public List<Bond> getBondAfterMaturityDate(String filter);
	//public int getOrderid();
	//public void addBonds(Bond2 b2);


}
