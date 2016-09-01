package mypackage;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ebondtrader.ejb.EBondBeanLocal;
import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Customer;

import ebondtrader.jpa.Transaction;

@Path("/bond")
public class BondResource {

	Context context = null;
	EBondBeanLocal bean;

	BondResource() {
		try {
			context = new InitialContext();
			bean = (EBondBeanLocal) context.lookup("java:app/EBondTraderEJB/EBondBean!ebondtrader.ejb.EBondBeanLocal");
		} catch (Exception e) {
			System.out.println("Error in creating bean");
			e.printStackTrace();
		}

	}

	@GET
	@Produces("application/json")
	public List<Bond> ret1Bond() {
		List<Bond> blist = bean.getAllBonds();
		return blist;

	}
	@GET
	@Produces("text/plain")
	@Path("/test")
	public String test() {
		
		return "Connection Done";

	}

	@GET
	@Produces("application/json")
	@Path("/transhis")
	public List<Transaction> retBond() {
		List<Transaction> blist = bean.getOrderHistory();
		return blist;

	}

	// @GET
	// @Produces("application/json")
	// @Path("/allBondsByDate")
	// public List<Bond> retBondByDate(){
	// List<Bond> blist=bean.getAllBondsByDate();
	// return blist;
	//
	// }

	// @GET
	// @Produces("application/json")
	// @Path("/allBondsByIsin")
	// public List<Bond> getBonds(@QueryParam("isin")@DefaultValue("") String
	// isin){
	//
	// // if(bean==null)
	// // return null;
	// if(!isin.equals("")){
	// System.out.println("in getBonds() function!");
	// List<Bond> bonds = bean.getBondByIsin(isin);
	// return bonds;
	//
	// }else {
	// return bean.getAllBonds();
	// }
	// }

	// @GET
	// @Produces("application/json")
	// @Path("/allBondsByCouponPeriod")
	// public List<Bond> getBond(@QueryParam("couponPeriod") @DefaultValue("")
	// String couponPeriod) {
	// if (!couponPeriod.equals("")) {
	// List<Bond> bond = bean.getBondByCouponPeriod(couponPeriod);
	// return bond;
	// } else
	// return bean.getAllBonds();
	// }

	// @GET
	// @Produces("application/json")
	// @Path("/allBondsByIssuerName")
	// public List<Bond>
	// getBondByIssuer(@QueryParam("issuerName")@DefaultValue("") String
	// issuerName) {
	// System.out.println("in getBond() function!");
	// if (!issuerName.equals("")) {
	// List<Bond> bond = bean.getBondByIssuerName(issuerName);
	// return bond;
	// } else
	// return bean.getAllBonds();
	// }
	// Filter for searching ISIN,Coupon Period, Fitch, Moodys,Snp and Issuer
	// name
	@GET
	@Produces("application/json")
	@Path("/allBondsByCustomSearch")
	public List<Bond> getBond(@QueryParam("isin") @DefaultValue("%") String isin,
			@QueryParam("couponPeriod") @DefaultValue("%") String couponPeriod,
			@QueryParam("fitch") @DefaultValue("%") String fitch,
			@QueryParam("moodys") @DefaultValue("%") String moodys, @QueryParam("snp") @DefaultValue("%") String snp,
			@QueryParam("issuerName") @DefaultValue("%") String issuerName,@QueryParam("currentYield") @DefaultValue("%") String currentYield) {
		if (isin.equals("%") && couponPeriod.equals("%") && fitch.equals("%") && moodys.equals("%") && snp.equals("%")
				&& issuerName.equals("%") && currentYield.toString().equals("%")) {
			return bean.getAllBonds();
		} else
			return bean.getBondByFilter(isin, couponPeriod, fitch, moodys, snp, issuerName,currentYield);
	}

	@GET
	@Produces("application/json")
	@Path("/allCustomers")
	public List<Customer> getAllCustomer() {
		return bean.getCustomer();
	}
	
	@GET
	@Produces("text/plain")
	@Consumes("application/json")
	@Path("/customerCheck")
	public String getValidityOfCustomer(@QueryParam("customerId") @DefaultValue("%") String customerId) {
		if(bean.checkCustomer(customerId)){
			return "yes";
		}else {
			return "no";
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/trans")
	public void updateHistory(Transaction t1) {
		System.out.println("Adding a new transaction");
		bean.updateHistory(t1);
	}
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/cancelOrder")
	public void cancelOrder(Transaction t2) {
		System.out.println("Cancelling a transaction");
		bean.cancelOrder(t2.getOrderId());
	}

}
