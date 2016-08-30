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

@Path("/product")
public class ProductResource {

	Context context = null;
	EBondBeanLocal bean;

	ProductResource() {
		try {
			context = new InitialContext();
			bean = (EBondBeanLocal) context.lookup("java:app/EBondTraderEJB/EBondBean!ebondtrader.ejb.EBondBeanLocal");
			System.out.println("bean created!");
		} catch (Exception e) {
			System.out.println("Error in creating bean");
			e.printStackTrace();
		}

	}

	// @GET
	// @Produces("application/json")
	// public List<Products> retProducts{
	// List<Products> plist=bean.getProducts();
	// return plist;
	// }

	/*
	 * @GET
	 * 
	 * @Produces("application/json") public List<Products> getProductAsString(){
	 * 
	 * if(bean==null) return null; List<Products> prod = bean.getProducts();
	 * return prod;
	 * 
	 * }
	 */

//	s

	@POST
	@Consumes("text/plain")
	public void ret(String text) {
		System.out.println(text);
	}

	/*
	 * @GET
	 * 
	 * @Produces("application/json")
	 * 
	 * @Path("/{categoryName}") public List<Products>
	 * getProductsInCategory(@PathParam("categoryName") String categoryname){
	 * 
	 * if(bean==null) return null; List<Products> prod =
	 * bean.getProductsInCategory(categoryname); return prod;
	 * 
	 * }
	 */

	// @GET
	// @Produces("application/json")
	// @Path("/{bonds}/{isin}")
	// public List<Bond> getBond(@PathParam("bonds") String
	// bonds,@PathParam("isin") String isin){
	// return bean.getBondByIsin(isin);
	//
	// }

	/*
	 * @POST
	 * 
	 * @Consumes("text/plain")
	 * 
	 * @Produces("text/plain") public void putText(String content){
	 * System.out.println(content); System.out.println("hELLO"); }
	 */
	
	@GET
	@Produces("application/json")
	@Path("/allBondsByCustomSearch")
	public List<Bond> getBond(@QueryParam("isin") @DefaultValue("%") String isin, @QueryParam("coupon_Period") @DefaultValue("%") String coupon_Period,
			@QueryParam("fitch") @DefaultValue("%") String fitch,@QueryParam("moodys") @DefaultValue("%") String moodys,@QueryParam("snp") @DefaultValue("%") String snp) {
		if(isin.equals("%") && coupon_Period.equals("%") && fitch.equals("%") && moodys.equals("%") && snp.equals("%")){
			return bean.getAllBonds();
		}else return bean.getBondByCouponPeriodAndFitchRevised(isin, coupon_Period, fitch,moodys,snp); 
		}
		
	
}
