package ebondtrader.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;




import com.fasterxml.jackson.annotation.JsonManagedReference;

import ebondtrader.jpa.Products;

@Entity
public class Categories implements Serializable{
	private int categoryId;
	private String categoryName;
	private String description;
	@JsonManagedReference
	private List<Products> product = new ArrayList<Products>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	
	

	public void setProduct(List<Products> product) {
		this.product = product;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setList(List<Products> p){
	this.product=p;
	}
	
	@OneToMany(mappedBy="category")
	@OrderBy("productId DESC")
	public List<Products> getProduct() {
		return product;
	}
	
}
