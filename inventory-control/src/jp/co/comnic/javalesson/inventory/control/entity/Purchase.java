package jp.co.comnic.javalesson.inventory.control.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PURCHASE database table.
 * 
 */
@Entity
@NamedQuery(name="Purchase.findAll", query="SELECT p FROM Purchase p")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Temporal(TemporalType.DATE)
	private Date consumptionDate;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int foodsId;

	private int price;

	private int quantity;

	public Purchase() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getConsumptionDate() {
		return this.consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFoodsId() {
		return this.foodsId;
	}

	public void setFoodsId(int foodsId) {
		this.foodsId = foodsId;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}