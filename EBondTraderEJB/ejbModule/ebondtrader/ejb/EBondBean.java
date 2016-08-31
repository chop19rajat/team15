package ebondtrader.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ebondtrader.jpa.Bond;
import ebondtrader.jpa.Customer;
import ebondtrader.jpa.Transaction;

/**
 * Session Bean implementation class EBondBean
 */

@Remote(EBondBeanRemote.class)
@Local(EBondBeanLocal.class)
@Stateless
public class EBondBean implements EBondBeanRemote, EBondBeanLocal {

	// Creation of Entity Manager

	@PersistenceContext(unitName = "EBondTraderJPA-PU")
	EntityManager em;

	// Updating the database using persist

	public void updateHistory(Transaction t) {
		em.persist(t);
	}

	// Get data from the database

	public List<Bond> getAllBonds() {
		TypedQuery<Bond> query = em.createQuery("Select p from Bond as p", Bond.class);
		List<Bond> plist = (List<Bond>) query.getResultList();

		return plist;

	}

	// Get all the transactions (History)

	public List<Transaction> getOrderHistory() {
		TypedQuery<Transaction> query = em.createQuery("Select p from Transaction as p", Transaction.class);
		List<Transaction> plist = (List<Transaction>) query.getResultList();

		return plist;

	}

	// Get the list of clients

	public List<Customer> getCustomer() {
		TypedQuery<Customer> query = em.createQuery("Select p from Customer as p", Customer.class);
		List<Customer> customerList = (List<Customer>) query.getResultList();
		return customerList;

	}

	// filter search by ISIN

	/*
	 * public List<Bond> getBondByIsin(String isin) {
	 * 
	 * String sql = "SELECT eb FROM Bond AS eb WHERE eb.isin LIKE '%" + isin +
	 * "%'"; TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
	 * List<Bond> bond = (List<Bond>) myquery.getResultList(); return bond;
	 * 
	 * }
	 */

	// Filter function for searching ISIN,Coupon Period, Fitch,
	// Moodys,Snp,Issuer name and yield

	public List<Bond> getBondByFilter(String isin, String couponPeriod, String fitch, String moodys, String snp,
			String issuerName, String currentYield) {
		if (!currentYield.equals("%")) {

			String sql = "SELECT eb FROM Bond AS eb WHERE eb.couponPeriod LIKE '" + couponPeriod + "'"
					+ " AND eb.fitch LIKE '" + fitch + "'" + " AND eb.isin LIKE '%" + isin + "%'"
					+ " AND eb.moodys LIKE '" + moodys + "'" + " AND eb.snp LIKE '" + snp + "'"
					+ "AND eb.issuerName LIKE '%" + issuerName + "%'" + "AND eb.currentYield LIKE '" + currentYield
					+ "." + "%'";

			System.out.println("in Revised method.");
			System.out.println(sql);
			TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
			List<Bond> bond = (List<Bond>) myquery.getResultList();
			return bond;
		} else {
			String sql = "SELECT eb FROM Bond AS eb WHERE eb.couponPeriod LIKE '" + couponPeriod + "'"
					+ " AND eb.fitch LIKE '" + fitch + "'" + " AND eb.isin LIKE '%" + isin + "%'"
					+ " AND eb.moodys LIKE '" + moodys + "'" + " AND eb.snp LIKE '" + snp + "'"
					+ "AND eb.issuerName LIKE '%" + issuerName + "%'";

			TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
			List<Bond> bond = (List<Bond>) myquery.getResultList();
			return bond;
		}
	}
	
	// Canceling order
	
	public void cancelOrder(int orderId){
		String sql="UPDATE Transaction AS t SET status='Cancelled' where t.orderId='"+orderId+"'";
		Query myquery = em.createQuery(sql);
		myquery.executeUpdate();
	}
	// Filter to search bond by coupon period

	/*
	 * public List<Bond> getBondByCouponPeriod(String couponPeriod) { String sql
	 * = "SELECT eb FROM Bond AS eb WHERE eb.couponPeriod = '" + couponPeriod +
	 * "'"; System.out.println("in getBondByCoupon"); TypedQuery<Bond> myquery =
	 * em.createQuery(sql, Bond.class); List<Bond> bond = (List<Bond>)
	 * myquery.getResultList(); return bond; }
	 */

	// Filter to search bond by issuer name
	/*
	 * public List<Bond> getBondByIssuerName(String issuerName) { String sql =
	 * "SELECT eb FROM Bond AS eb WHERE eb.issuerName LIKE '%" + issuerName +
	 * "%'"; System.out.println("in getBondByCoupon"); TypedQuery<Bond> myquery
	 * = em.createQuery(sql, Bond.class); List<Bond> bond = (List<Bond>)
	 * myquery.getResultList(); return bond; }
	 */

	/**
	 * Default constructor.
	 */
	public EBondBean() {
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public List<Bond> getAllBondsByDate() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
