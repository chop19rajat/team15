package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Remote;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Products;
import ebondtrader.jpa.Transaction;


@Remote
public interface EBondBeanRemote {
	public void addCategoriesAndProducts();
	public List<Products> getProductsInCategory(String categoryName);
	
	public List<Products> getProducts();
	public void printing();
	public List<Products> getProductsByName(String name);
	public List<Bond> getAllBonds();
	public void getTransactions(Transaction t);
	public List<Transaction> getAlltrs();
	//public int getOrderid();
	
	//public void addBonds(Bond2 b2);


}
