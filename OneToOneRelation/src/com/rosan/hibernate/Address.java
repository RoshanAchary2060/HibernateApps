package com.rosan.hibernate;

public class Address {
	private int addressId;
	private String city;
	private String street;
	private Person p;
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", street=" + street + ", p=" + p + "]";
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}

}
