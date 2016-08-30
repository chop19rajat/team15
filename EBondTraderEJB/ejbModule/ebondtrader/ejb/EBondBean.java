package ebondtrader.ejb;

import java.sql.PreparedStatement;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.QueryParam;

import ebondtrader.jpa.Bond;

/**
 * Session Bean implementation class EBondBean
 */
@Remote(EBondBeanRemote.class)
@Local(EBondBeanLocal.class)
@Stateless
public class EBondBean implements EBondBeanRemote, EBondBeanLocal {

	@PersistenceContext(unitName = "EBondTraderJPA-PU")
	EntityManager em;

	/**
	 * Default constructor.
	 */

	public List<Bond> getAllBonds() {
		// Query query = em.createQuery("Select eb from " +
		// Bond.class.getClass() + " eb");
		System.out.println("in getAllBonds()!");
		TypedQuery<Bond> query = em.createQuery("SELECT eb FROM Bond AS eb", Bond.class);
		System.out.println("created query!");
		List<Bond> bonds = (List<Bond>)query.getResultList();
		System.out.println("got result list!");
		return bonds;
	}

	public void printing() {
		System.out.println("In Bean");
	}

	public List<Bond> getBondByIsin(String isin) {

		String sql = "SELECT eb FROM Bond AS eb WHERE eb.isin = '" + isin + "'";
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;

	}

	@Override
	public List<Bond> getBondByCouponPeriod(String coupon_Period) {
		String sql = "SELECT eb FROM Bond AS eb WHERE eb.coupon_Period = '" + coupon_Period + "'";
		System.out.println("in getBondByCoupon");
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;
	}
	@Override
	public List<Bond> getBondByCouponPeriodAndFitch(String coupon_Period,String fitch ) {
		String sql = "SELECT eb FROM Bond AS eb WHERE eb.coupon_Period = '" + coupon_Period + "'" + "AND eb.fitch LIKE '%" + fitch +"'";
		System.out.println("in getBondByCoupon");
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;
	}
	
	@Override
	public List<Bond> getBondByFitch(String fitch) {
		String sql = "SELECT eb FROM Bond AS eb WHERE eb.fitch LIKE ' %" + fitch + "'";
		System.out.println("in getBondByCoupon");
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;
	}

	@Override
	public List<Bond> getBondByIssuerName(String issuerName) {
		String sql = "SELECT eb FROM Bond AS eb WHERE eb.issuerName LIKE '%" + issuerName + "%'";
		System.out.println("in getBondByCoupon");
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;
	}

//	@Override
//	public List<Bond> getBondByCouponPeriodAndFitchRevised(String isin, String coupon_Period, String fitch) {
//		String sql = "SELECT eb FROM Bond AS eb WHERE eb.coupon_Period like '" + coupon_Period + "'" + "AND eb.fitch LIKE '%" + fitch +"%'" + "AND eb.isin LIKE '%" + isin+"%'";
//		System.out.println("in Revised method.");
//		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
//		List<Bond> bond = (List<Bond>) myquery.getResultList();
//		return bond;
//	}
	@Override
	public List<Bond> getBondByCouponPeriodAndFitchRevised(String isin, String coupon_Period, String fitch,String moodys,String snp) {
		String sql = "SELECT eb FROM Bond AS eb WHERE eb.coupon_Period like '" + coupon_Period + "'" + "AND eb.fitch LIKE '%" + fitch +"%'" + "AND eb.isin LIKE '%" + isin+"%'"+"AND eb.moodys LIKE '" + moodys +"'" + "AND eb.snP LIKE '%" + snp+"%'"  ;
		System.out.println("in Revised method.");
		TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
		List<Bond> bond = (List<Bond>) myquery.getResultList();
		return bond;
	}
	

	/**
	 * Default constructor.
	 */

}
