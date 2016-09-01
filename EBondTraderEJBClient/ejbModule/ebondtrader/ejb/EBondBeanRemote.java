package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Remote;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Customer;
import ebondtrader.jpa.Transaction;

@Remote
public interface EBondBeanRemote {

	public List<Customer> getCustomer();

	public List<Bond> getBondByFilter(String isin, String couponPeriod, String fitch, String moodys, String snp,
			String issuerName, String currentYield);

	public List<Bond> getAllBonds();

	public void updateHistory(Transaction t);

	public List<Transaction> getOrderHistory();

	public void cancelOrder(int orderId);

	public List<Transaction> getTransactionByFilter(String isin, String customerId);

}
