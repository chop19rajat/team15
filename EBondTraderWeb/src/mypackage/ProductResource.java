package mypackage;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ebondtrader.ejb.EBondBeanLocal;
import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Products;
import ebondtrader.jpa.Transaction;



@Path("/product")
public class ProductResource {
	
	
	Context context=null;
	EBondBeanLocal bean;
	
	ProductResource(){
		try{
			context=new InitialContext();
			bean=(EBondBeanLocal)context.lookup("java:app/EBondTraderEJB/EBondBean!ebondtrader.ejb.EBondBeanLocal");
		}
		catch(Exception e){
			System.out.println("Error in creating bean");
			e.printStackTrace();
		}
		
	}
	
	
	
//	@GET
//	@Produces("application/json")
//	public List<Products> retProducts{
//		List<Products> plist=bean.getProducts();
//		return plist;
//	}
	
	/*@GET
	@Produces("application/json")
	public List<Products> getProductAsString(){
		
		if(bean==null)
			return null;
		List<Products> prod = bean.getProducts();
		return prod;
		
	}*/

	
	
	
	
/*	@GET
	@Produces("application/json")
	public List<Products> getProductByName(@QueryParam("filter")@DefaultValue("")String filter){
		
		if(bean==null)
			return null;
		List<Products> prod = bean.getProductsByName(filter);
		return prod;
		
	}*/
	
	
	
	
	
	
	
	/*@POST
	@Consumes("text/plain")
	@Path("/post")
	public void ret(String text){
		System.out.println(text);
	}*/
	
	
	/*@POST
	@Consumes("application/json")
	@Path("/post")
	public void retBond(Bond2 b){
		bean.addBonds(b);
	//System.out.println(b.getDescription());
		//return b.Description;
		
	}*/
	
	
	
	
	/*@GET
	@Produces("application/json")
	@Path("/{categoryName}")
	public List<Products> getProductsInCategory(@PathParam("categoryName") String categoryname){
		
		if(bean==null)
			return null;
		List<Products> prod = bean.getProductsInCategory(categoryname);
		return prod;
		
	}*/
	
	
	
	@GET
	@Produces("text/plain")
	@Path("/{name}/{age}")
	public String retName(@PathParam("name") String name,@PathParam("age") String age){
		System.out.println("Hello");
		return name+age;
		
	}
	
	
	@GET
	@Produces("application/json")
	public List<Bond> ret1Bond(){
		List<Bond> blist=bean.getAllBonds();
		return blist;
		
	}
//	@GET
//	@Produces("application/json")
//	@Path("/qwert")
//	public int ret12Bond(){
//		int blist=bean.getOrderid();
//		return blist;
//		
//	}
	
	@GET
	@Produces("application/json")
	@Path("/transhis")
	public List<Transaction> retBond(){
		List<Transaction> blist=bean.getAlltrs();
		return blist;
		
	}
	

	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/trans")
	public void updateHistory(Transaction t1){
		System.out.println("asdfghjasakjskajskajskajs");
		bean.getTransactions(t1);
	}
	
	

}
