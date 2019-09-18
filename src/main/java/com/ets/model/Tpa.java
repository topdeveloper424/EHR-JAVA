package com.ets.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "tpa")

public class Tpa {

	/***************
	 * Column property ( 1 )
	 *****************************************/

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

	/***************
	 * Column property ( 2 )
	 *****************************************/

	private StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/

	private StringProperty name = new SimpleStringProperty(this, "name");

	@Column(name = "name")
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	// Column 4
	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}

	public SimpleObjectProperty<Address> addressProperty() {
		return address;
	}

	/***************
	 * Column property ( 5 )
	 *****************************************/

	private StringProperty planType = new SimpleStringProperty(this, "planType");

	@Column(name = "plan_type")
	public String getPlanType() {
		return planType.get();
	}

	public void setPlanType(String planType) {
		this.planType.set(planType);

	}

	public StringProperty planTypeProperty() {
		return planType;
	}

	// Column 4
	private SimpleObjectProperty<Contact> contact = new SimpleObjectProperty<Contact>(this, "contact");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact.get();
	}

	public void setContact(Contact contact) {
		this.contact.set(contact);
	}

	public SimpleObjectProperty<Contact> contactProperty() {
		return contact;
	}

	private SimpleObjectProperty<BillingAccount> billingAccount = new SimpleObjectProperty<BillingAccount>(this,
			"billingAccount");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "billing_ac_id")
	public BillingAccount getBillingAccount() {
		return billingAccount.get();
	}

	public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount.set(billingAccount);
	}

	public SimpleObjectProperty<BillingAccount> billingAccountProperty() {
		return billingAccount;
	}


	/*// Column 9
	private SimpleObjectProperty<Region> region = new SimpleObjectProperty<Region>(this, "region");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return region.get();
	}

	public void setRegion(Region region) {
		this.region.set(region);
	}

	public SimpleObjectProperty<Region> regionProperty() {
		return region;
	}

	// Column 9
	private SimpleObjectProperty<Complex> complex = new SimpleObjectProperty<Complex>(this, "complex");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "complex_id")
	public Complex getComplex() {
		return complex.get();
	}

	public void setComplex(Complex complex) {
		this.complex.set(complex);
	}

	public SimpleObjectProperty<Complex> complexProperty() {
		return complex;
	}

	// Column 10
	private SimpleObjectProperty<District> district = new SimpleObjectProperty<District>(this, "district");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	public District getDistrict() {
		return district.get();
	}

	public void setDistrict(District district) {
		this.district.set(district);
	}

	public SimpleObjectProperty<District> districtProperty() {
		return district;
	}*/

	/***************
	 * Column property ( 11 )
	 *****************************************/

	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	private List<Company> companies;

	@OneToMany(fetch = FetchType.LAZY , mappedBy="tpa" , cascade=CascadeType.ALL)
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Tpa() {

	}

}
