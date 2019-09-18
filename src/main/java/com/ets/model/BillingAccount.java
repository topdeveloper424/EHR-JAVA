package com.ets.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "billing_account")


public class BillingAccount {

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

	
	private List<Tpa> tpa;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="billingAccount")
	public List<Tpa> getTpa() {
		return tpa;
	}

	public void setTpa(List<Tpa> tpa) {
		this.tpa = tpa;
	}


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
	
	private StringProperty mainContact = new SimpleStringProperty(this, "mainContact");

	@Column(name = "mainContact")
	public String getMainContact() {
		return mainContact.get();
	}

	public void setMainContact(String mainContact) {
		this.mainContact.set(mainContact);
	}

	public StringProperty mainContactProperty() {
		return mainContact;
	}

	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "main_billing_address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}

	public SimpleObjectProperty<Address> addressProperty() {
		return address;
	}

	private StringProperty acType = new SimpleStringProperty(this, "acType");

	@Column(name = "ac_type")

	public String getAcType() {
		return acType.get();
	}

	public void setAcType(String acType) {
		this.acType.set(acType);
	}

	public StringProperty actypeProperty() {
		return acType;
	}

	/*private SimpleObjectProperty<Contact> contact = new SimpleObjectProperty<Contact>(this, "contact");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "main_contact_id")

	public Contact getContact() {
		return contact.get();
	}

	public void setContact(Contact contact) {
		this.contact.set(contact);
	}

	public SimpleObjectProperty<Contact> contactProperty() {
		return contact;
	}*/
	
	private SimpleBooleanProperty collectSent = new SimpleBooleanProperty(this, "collectSent");

	@Column(name = "collect_sent")
	public boolean getCollectSent() {
		return collectSent.get();
	}

	public void setCollectSent(boolean collectSent) {
		this.collectSent.set(collectSent);
	}

	public BooleanProperty collectSentProperty() {
		return collectSent;
	}

	private StringProperty stdFeeSchedule = new SimpleStringProperty(this, "stdFeeSchedule");

	@Column(name = "std_fee_schedule")
	public String getStdFeeSchedule() {
		return stdFeeSchedule.get();
	}

	public void setStdFeeSchedule(String stdFeeSchedule) {
		this.stdFeeSchedule.set(stdFeeSchedule);
	}

	public StringProperty stdFeeScheduleProperty() {
		return stdFeeSchedule;
	}

	private ObjectProperty<Date> collectDate = new SimpleObjectProperty<Date>();

	@Column(name = "collect_date")
	@Temporal(TemporalType.DATE)
	public Date getCollectDate() {
		return collectDate.get();
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate.set(collectDate);
	}

	public ObjectProperty<Date> collectDateProperty() {
		return this.collectDate;
	}

	private SimpleBooleanProperty stdPrice = new SimpleBooleanProperty(this, "stdPrice");

	@Column(name = "std_price")
	public boolean getStdPrice() {
		return stdPrice.get();
	}

	public void setStdPrice(boolean stdPrice) {
		this.stdPrice.set(stdPrice);
	}

	public BooleanProperty StdPriceProperty() {
		return stdPrice;
	}

	private StringProperty adjustPercent = new SimpleStringProperty(this, "adjustPercent");

	@Column(name = "adjust_percent")
	public String getAdjustPercent() {
		return adjustPercent.get();
	}

	public void setAdjustPercent(String adjustPercent) {
		this.adjustPercent.set(adjustPercent);
	}

	public StringProperty adjustPercentProperty() {
		return adjustPercent;
	}

	/*private SimpleObjectProperty<CptCode4Hcpcs> cpt = new SimpleObjectProperty<CptCode4Hcpcs>(this, "cpt");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cpt_code_id")
	public CptCode4Hcpcs getCpt() {
		return cpt.get();
	}

	public void setCpt(CptCode4Hcpcs cpt) {
		this.cpt.set(cpt);
	}

	public SimpleObjectProperty<CptCode4Hcpcs> cptProperty() {
		return cpt;
	}*/

	/*private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}*/
	

	public BillingAccount() {

	}
	
	private List<Company> companies;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="billingAccount" , cascade=CascadeType.ALL)
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}
