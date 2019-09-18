package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Address Class
 *Description: Entity class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

@Entity
@Table(name = "address")

public class Address {

	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}
	
	private StringProperty localAddress = new SimpleStringProperty(this, "localAddress");

	@Column(name = "local_address")
	public String getLocalAddress() {
		return localAddress.get();
	}

	public void setlocalAddress(String localAddress) {
		this.localAddress.set(localAddress);
	}

	public StringProperty localAddressProperty() {
		return localAddress;
	}

	private StringProperty city = new SimpleStringProperty(this, "city");

	@Column(name = "city")
	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}
	
	private StringProperty district = new SimpleStringProperty(this, "district");

	@Column(name = "district")
	public String getDistrict() {
		return district.get();
	}

	public void setDistrict(String district) {
		this.district.set(district);
	}

	public StringProperty districtProperty() {
		return district;
	}
	
	
	private StringProperty state = new SimpleStringProperty(this, "state");

	@Column(name = "state")
	public String getState() {
		return state.get();
	}

	public void setState(String state) {
		this.state.set(state);
	}

	public StringProperty stateProperty() {
		return state;
	}
	
	private StringProperty zip = new SimpleStringProperty(this, "zip");

	@Column(name = "zip")
	public String getZip() {
		return zip.get();
	}

	public void setZip(String zip) {
		this.zip.set(zip);
	}

	public StringProperty zipProperty() {
		return zip;
	}
	
	
	private StringProperty country = new SimpleStringProperty(this, "country");

	@Column(name = "country")
	public String getCountry() {
		return country.get();
	}

	public void setCountry(String country) {
		this.country.set(country);
	}

	public StringProperty countryProperty() {
		return country;
	}
	
	private StringProperty street = new SimpleStringProperty(this, "street");

	@Column(name = "street")
	public String getStreet() {
		return street.get();
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty streetProperty() {
		return street;
	}
	
	private StringProperty phone = new SimpleStringProperty(this, "phone");

	@Column(name = "phone")
	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public StringProperty phoneProperty() {
		return phone;
	}
	
	private StringProperty ext = new SimpleStringProperty(this, "ext");

	@Column(name = "ext")
	public String getExt() {
		return ext.get();
	}

	public void setExt(String ext) {
		this.ext.set(ext);
	}

	public StringProperty extProperty() {
		return ext;
	}
	
	private StringProperty fax = new SimpleStringProperty(this, "fax");

	@Column(name = "fax")
	public String getFax() {
		return fax.get();
	}

	public void setFax(String fax) {
		this.fax.set(fax);
	}

	public StringProperty faxProperty() {
		return fax;
	}
	
	private StringProperty email = new SimpleStringProperty(this, "email");

	@Column(name = "email")
	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty emailProperty() {
		return email;
	}
	
	private StringProperty county = new SimpleStringProperty(this, "county");

	@Column(name = "county")
	public String getCounty() {
		return county.get();
	}

	public void setCounty(String county) {
		this.county.set(county);
	}

	public StringProperty countyProperty() {
		return county;
	}
	
	private StringProperty secureFax = new SimpleStringProperty(this, "secureFax");

	@Column(name = "secure_fax")
	public String getSecureFax() {
		return secureFax.get();
	}

	public void setSecureFax(String secureFax) {
		this.secureFax.set(secureFax);
	}

	public StringProperty secureFaxProperty() {
		return secureFax;
	}
	
	
	private StringProperty phHome = new SimpleStringProperty(this, "phHome");

	@Column(name = "ph_home")
	public String getPhHome() {
		return phHome.get();
	}

	public void setPhHome(String phHome) {
		this.phHome.set(phHome);
	}

	public StringProperty phHomeProperty() {
		return phHome;
	}
	
	private StringProperty phOffice = new SimpleStringProperty(this, "phOffice");

	@Column(name = "ph_office")
	public String getPhOffice() {
		return phOffice.get();
	}

	public void setPhOffice(String phOffice) {
		this.phOffice.set(phOffice);
	}

	public StringProperty phOfficeProperty() {
		return phOffice;
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

}
