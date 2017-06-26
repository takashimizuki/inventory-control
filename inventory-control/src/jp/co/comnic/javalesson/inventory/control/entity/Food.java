package jp.co.comnic.javalesson.inventory.control.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FOODS database table.
 * 
 */
@Entity
@Table(name="FOODS")
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public Food() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}