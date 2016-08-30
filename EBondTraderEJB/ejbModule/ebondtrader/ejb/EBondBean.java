package ebondtrader.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ebondtrader.jpa.Bond;

import ebondtrader.jpa.Transaction;

/**
 * Session Bean implementation class EBondBean
 */
@Remote(EBondBeanRemote.class)
@Local(EBondBeanLocal.class)
@Stateless
public class EBondBean implements EBondBeanRemote, EBondBeanLocal {
	
	@PersistenceContext(unitName="EBondTraderJPA-PU")
	EntityManager em;
    /**
     * Default constructor. 
     */
	


	
	
	
	
	
	public void printing(){
		System.out.println("In Bean");
	}
	
	

	
	
	public List<Bond> getAllBondsByDate(){
			return null;		
	}
	
	public void getTransactions(Transaction t){
		em.persist(t);
	}
	
public List<Bond> getAllBonds(){
	TypedQuery <Bond>query=em.createQuery("Select p from Bond as p",Bond.class);
	List<Bond> plist=(List<Bond>) query.getResultList();
	
	
	return plist;
		
	}

public List<Transaction> getAlltrs(){
	TypedQuery <Transaction>query=em.createQuery("Select p from Transaction as p",Transaction.class);
	List<Transaction> plist=(List<Transaction>) query.getResultList();
	
	
	return plist;
		
	}

public List<Bond> getBondByIsin(String isin) {

	String sql = "SELECT eb FROM Bond AS eb WHERE eb.isin LIKE '%" + isin + "%'";
	TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
	List<Bond> bond = (List<Bond>) myquery.getResultList();
	return bond;

}

public List<Bond> getBondByCouponPeriodAndFitchRevised(String isin, String coupon_Period, String fitch) {
	String sql = "SELECT eb FROM Bond AS eb WHERE eb.couponPeriod LIKE '" + coupon_Period + "'" + "AND eb.fitch LIKE '%" + fitch +"%'" + "AND eb.isin LIKE '%" + isin+"%'";
	System.out.println("in Revised method.");
	TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
	List<Bond> bond = (List<Bond>) myquery.getResultList();
	return bond;
}


public List<Bond> getBondByCouponPeriod(String coupon_Period) {
	String sql = "SELECT eb FROM Bond AS eb WHERE eb.couponPeriod = '" + coupon_Period + "'";
	System.out.println("in getBondByCoupon");
	TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
	List<Bond> bond = (List<Bond>) myquery.getResultList();
	return bond;
}
	

public List<Bond> getBondByIssuerName(String issuerName) {
	String sql = "SELECT eb FROM Bond AS eb WHERE eb.issuerName LIKE '%" + issuerName + "%'";
	System.out.println("in getBondByCoupon");
	TypedQuery<Bond> myquery = em.createQuery(sql, Bond.class);
	List<Bond> bond = (List<Bond>) myquery.getResultList();
	return bond;
}
	
	
	
	
	
	
	
	
	
    /**
     * Default constructor. 
     */
    public EBondBean() {
        // TODO Auto-generated constructor stub
    }





	

	


}
