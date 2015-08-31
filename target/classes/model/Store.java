package com.hand.model;
// Generated 2015-8-28 8:59:03 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Store generated by hbm2java
 */
public class Store implements java.io.Serializable {

	private Byte storeId;
	private Address address;
	private Staff staff;
	private Date lastUpdate;
	private Set inventories = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set staffs = new HashSet(0);

	public Store() {
	}

	public Store(Address address, Staff staff, Date lastUpdate) {
		this.address = address;
		this.staff = staff;
		this.lastUpdate = lastUpdate;
	}

	public Store(Address address, Staff staff, Date lastUpdate, Set inventories, Set customers, Set staffs) {
		this.address = address;
		this.staff = staff;
		this.lastUpdate = lastUpdate;
		this.inventories = inventories;
		this.customers = customers;
		this.staffs = staffs;
	}

	public Byte getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Byte storeId) {
		this.storeId = storeId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getInventories() {
		return this.inventories;
	}

	public void setInventories(Set inventories) {
		this.inventories = inventories;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

}
