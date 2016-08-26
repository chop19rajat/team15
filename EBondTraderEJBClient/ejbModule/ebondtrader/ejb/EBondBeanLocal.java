package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Local;

import ebondtrader.jpa.Products;



@Local
public interface EBondBeanLocal {
	
	public void addCategoriesAndProducts();
	public List<Products> getProductsInCategory(String categoryName);
	
	public List<Products> getProducts();
	public void printing();
	public List<Products> getProductsByName(String name);


}
