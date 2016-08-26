package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Remote;

import ebondtrader.jpa.Products;


@Remote
public interface EBondBeanRemote {
	public void addCategoriesAndProducts();
	public List<Products> getProductsInCategory(String categoryName);
	
	public List<Products> getProducts();
	public void printing();
	public List<Products> getProductsByName(String name);


}
