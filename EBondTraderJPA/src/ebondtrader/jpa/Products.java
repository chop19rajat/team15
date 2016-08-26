package ebondtrader.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Products implements Serializable{
	
	private int productID;
	
	
	private String productName;
	private double unitPrice;
	private int unitsInStock;
	private int reorderLevel;
	@JsonBackReference
	private Categories category;
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	
	
	
	public void setCategory(Categories category){
		this.category=category;
	
	}
	
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	public Categories getCategory(){
		return category;
		
	}
	
	
}