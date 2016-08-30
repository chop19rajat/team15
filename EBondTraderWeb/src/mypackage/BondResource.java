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
	@Produces("application/json")
	@Path("/transhis")
	public List<Transaction> retBond() {
		List<Transaction> blist = bean.getAlltrs();
		return blist;

	}

	@GET
	@Produces("application/json")
	@Path("/allBondsByDate")
	public List<Bond> retBondByDate() {
		List<Bond> blist = bean.getAllBondsByDate();
		return blist;

	}

	@GET
	@Produces("application/json")
	@Path("/allBondsByIsin")
	public List<Bond> getBonds(@QueryParam("isin") @DefaultValue("") String isin) {

		// if(bean==null)
		// return null;
		if (!isin.equals("")) {
			System.out.println("in getBonds() function!");
			List<Bond> bonds = bean.getBondByIsin(isin);
			return bonds;

		} else {
			return bean.getAllBonds();
		}
	}

	@GET
	@Produces("application/json")
	@Path("/allBondsByCouponPeriod")
	public List<Bond> getBond(@QueryParam("coupon_Period") @DefaultValue("") String coupon_Period) {
		if (!coupon_Period.equals("")) {
			List<Bond> bond = bean.getBondByCouponPeriod(coupon_Period);
			return bond;
		} else
			return bean.getAllBonds();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/trans")
	public void updateHistory(Transaction t1) {
		System.out.println("Adding a new transaction");
		bean.getTransactions(t1);
	}
	
	@GET
	@Produces("application/json")
	@Path("/after")
	public List<Bond> getBondsAfterMaturity(@QueryParam("filter") @DefaultValue("") String filter) {

		// if(bean==null)
		// return null;
		if (!filter.equals("")) {
			System.out.println("in getBonds() function!");
			List<Bond> bonds = bean.getBondAfterMaturityDate(filter);
			return bonds;

		} else {
			return bean.getAllBonds();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/before")
	public List<Bond> getBondsBeforeMaturity(@QueryParam("filter") @DefaultValue("") String filter) {

		// if(bean==null)
		// return null;
		if (!filter.equals("")) {
			System.out.println("in getBonds() function!");
			List<Bond> bonds = bean.getBondBeforeMaturityDate(filter);
			return bonds;

		} else {
			return bean.getAllBonds();
		}
	}

}
