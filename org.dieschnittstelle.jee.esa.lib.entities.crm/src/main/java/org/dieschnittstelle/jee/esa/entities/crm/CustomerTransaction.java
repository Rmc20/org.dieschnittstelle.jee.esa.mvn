package org.dieschnittstelle.jee.esa.entities.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1251851309422364868L;

	@Id
	@GeneratedValue
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private AbstractTouchpoint touchpoint;

	/*
	 * UE JPA1.1
	 */
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	//@OneToMany
	private List<CrmProductBundle> products = new ArrayList<CrmProductBundle>();

	private int value;

	private boolean completed;
	
	public CustomerTransaction() {
		System.out.println("constructor");
	}
	
	public CustomerTransaction(Customer customer,AbstractTouchpoint tp,List<CrmProductBundle> products) {
		this.customer = customer;
		this.touchpoint = tp;
		this.products = products;
		this.date = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AbstractTouchpoint getTouchpoint() {
		return touchpoint;
	}

	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		this.touchpoint = touchpoint;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String toString() {
		return "{CustomerTransaction " + this.id + " " + this.customer + " "
				+ this.touchpoint + ", " + this.products + "}";
	}

	public List<CrmProductBundle> getProducts() {
		return products;
	}

	public void setProducts(List<CrmProductBundle> products) {
		this.products = products;
	}
	
	/*
	 * lifecycle logging
	 */
	
	@PostLoad
	public void onPostLoad() {
		System.out.println("@PostLoad: " + this);
	}
	
	@PostPersist
	public void onPostPersist() {
		System.out.println("@PostPersist: " + this);		
	}
	
	@PostRemove
	public void onPostRemove() {
		System.out.println("@PostRemove: " + this);
	}

	@PostUpdate
	public void onPostUpdate() {
		System.out.println("@PostUpdate: " + this);
	}
	
	@PrePersist
	public void onPrePersist() {
		System.out.println("@PrePersist: " + this);
	}

	@PreRemove
	public void onPreRemove() {
		System.out.println("@PreRemove: " + this);
	}

	@PreUpdate
	public void onPreUpdate() {
		System.out.println("@PreUpdate: " + this);		
	}
	

}