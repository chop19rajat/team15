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
import ebondtrader.jpa.Categories;
import ebondtrader.jpa.Products;
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
	
	/*@Override
	public void addBonds(Bond2 b2) {
		System.out.println("in ebondbean");
		Bond2 b1=new Bond2(b2.getIsin(),b2.getDescription());
		System.out.println(b1.getDescription());
		em.persist(b1);
		
	}*/

	
	
	public void addCategoriesAndProducts(){
		
		
		//EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("StudentOnlineRetailerJPA");
		//EntityManager entitymanager=emfactory.createEntityManager();
		//entitymanager.getTransaction().begin();
		System.out.println("adding objects");
		Categories category=new Categories();
		Products product1 = new Products();
		Products product2 = new Products();
		//category.setCategoryId(1);
		category.setCategoryName("Beverage");
		category.setDescription("Soft Drinks");
		
		//product1.setProductID(111);
		product1.setProductName("CocaCola");
		product1.setUnitPrice(50);
		product1.setUnitsInStock(100);
		product1.setReorderLevel(2);
		
		//product2.setProductID(112);
		product2.setProductName("Pepsi");
		product2.setUnitPrice(50);
		product2.setUnitsInStock(100);
		product2.setReorderLevel(2);
		
		product1.setCategory(category);
		product2.setCategory(category);
		
		List<Products> p1=Arrays.asList(product1,product2);
		category.setList(p1);
		//entitymanager.persist(category);
		//entitymanager.persist(product1);
		//entitymanager.persist(product2);
		em.persist(category);
		em.persist(product1);
		em.persist(product2);
		//entitymanager.getTransaction().commit();
		
	//	entitymanager.close();
		//emfactory.close();
		//Rajat Chopra
	}
	
	public void printing(){
		System.out.println("In Bean");
	}
	
	
	public List<Products> getProducts(){
		
		TypedQuery <Products>query=em.createQuery("Select p from Products as p",Products.class);
		List<Products> plist=(List<Products>) query.getResultList();
		for(Products p: plist){
			System.out.println(p.getProductName());
		}
		
		return plist;
		
	}
	public void getTransactions(Transaction t){
		em.persist(t);
	}
	
public List<Bond> getAllBonds(){
	TypedQuery <Bond>query=em.createQuery("Select p from Bond as p",Bond.class);
	List<Bond> plist=(List<Bond>) query.getResultList();
	
	
	return plist;
		
	}
//public int getOrderid(){
//	TypedQuery <Transaction> query=em.createQuery("Select max(orderId) as orderId from Transaction as t) ",Transaction.class);
//	Transaction plist= (Transaction) query.getResultList();
//	
//	
//	return plist.getOrderId();
//		
//	}
public List<Transaction> getAlltrs(){
	TypedQuery <Transaction>query=em.createQuery("Select p from Transaction as p",Transaction.class);
	List<Transaction> plist=(List<Transaction>) query.getResultList();
	
	
	return plist;
		
	}
	
	
	
	
	
	
	
	
	public List<Products> getProductsByName(String name){
		
		/*Query query=em.createQuery("Select p from Products as p where p.productName="+name);
		Products p=(Products) query.getSingleResult();
		return p;*/
		
		String sql = "SELECT p FROM Products AS p WHERE p.productName LIKE '%" + name + "%'";
        System.out.println(sql);
        TypedQuery<Products> query = em.createQuery(sql, Products.class);
        List<Products> prod = (List<Products>) query.getResultList();
        for(Products p2:prod){
        	System.out.println(p2.getProductID());
        }
        return  prod;
		
	}
	
	/*public List<Products> getProductsInCategory(Categories category){
		Query query=em.createQuery("Select p from Products as p where p.category ="+category);
		List<Products> plist=(List<Products>) query.getResultList();
		return plist;
		
	}*/
	public List<Products> getProductsInCategory(String categoryName) {

        TypedQuery<Products> query = em.createQuery("SELECT p FROM Products AS p WHERE p.category.categoryName = :name", Products.class);
        query.setParameter("name", categoryName);

        // Execute the query, and get a collection of products back.
        List<Products> products = query.getResultList();

        for (Products product: products) {
            System.out.println(product.getProductName());;
        }

        return products;
    }

	
    /**
     * Default constructor. 
     */
    public EBondBean() {
        // TODO Auto-generated constructor stub
    }


}
