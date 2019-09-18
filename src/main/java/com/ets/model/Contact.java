package com.ets.model;

import java.util.List;

import javax.annotation.Generated;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "contact")


public class Contact {

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

	private StringProperty firstName = new SimpleStringProperty(this, "firstName");

	@Column(name = "first_name")

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	private StringProperty lastName = new SimpleStringProperty(this,"lastName");

	@Column(name = "last_name")

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	private StringProperty fullName = new SimpleStringProperty(this,"fullName");

	@Column(name = "full_name")

	public String getFullName() {
		return fullName.get();
	}

	public void setFullName(String fullName) {
		this.fullName.set(fullName);
	}

	public StringProperty fullNameProperty() {
		return fullName;
	}

	private StringProperty title = new SimpleStringProperty(this, "title");

	@Column(name = "title")

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public StringProperty titleProperty() {
		return title;
	}

	private StringProperty dept = new SimpleStringProperty(this, "dept");

	@Column(name = "dept")

	public String getDept() {
		return dept.get();
	}

	public void setDept(String dept) {
		this.dept.set(dept);
	}

	public StringProperty deptProperty() {
		return dept;
	}
	
	private StringProperty contactType = new SimpleStringProperty(this, "contactType");

	@Column(name = "contact_type")

	public String getContactType() {
		return contactType.get();
	}

	public void setContactType(String contactType ) {
		this.contactType.set(contactType);
	}

	public StringProperty contactTypeProperty() {
		return contactType ;
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
	
	
	private StringProperty mobile = new SimpleStringProperty(this, "mobile");

	@Column(name = "mobile")

	public String getMobile() {
		return mobile.get();
	}

	public void setMobile(String mobile) {
		this.mobile.set(mobile);
	}

	public StringProperty mobileProperty() {
		return mobile;
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
	
	
	private SimpleObjectProperty<CompanyProtocol> companyProtocol = new SimpleObjectProperty<CompanyProtocol>(this, "companyProtocol");

	@ManyToOne
	@JoinColumn(name = "company_protocol_id")
	public CompanyProtocol getCompanyProtocol() {
		return companyProtocol.get();
	}

	public void setCompanyProtocol(CompanyProtocol companyProtocol) {
		this.companyProtocol.set(companyProtocol);
	}

	public SimpleObjectProperty<CompanyProtocol> companyProtocolProperty() {
		return companyProtocol;
	}
	

	/*private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH , CascadeType.REMOVE})
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}

	public SimpleObjectProperty<Address> addressProperty() {
		return address;
	}*/

	/*private StringProperty encryptPswd = new SimpleStringProperty(this, "encryptPswd ");

	@Column(name = "encrypt_pswd")

	public String getEncryptPswd() {
		return encryptPswd.get() ;
	}

	public void setEncryptPswd (String encryptPswd ) {
		this.encryptPswd.set(encryptPswd);
	}

	public StringProperty encryptPswdProperty() {
		return encryptPswd;
	}*/

	
/*
	private StringProperty mailPrefix = new SimpleStringProperty(this, "mailPrefix");

	@Column(name = "mail_prefix")

	public String getMailPrefix() {
		return mailPrefix.get();
	}

	public void setMailPrefix(String mailPrefix) {
		this.mailPrefix.set(mailPrefix);
	}

	public StringProperty mailPrefixProperty() {
		return mailPrefix;
	}
*/
	
	
	private List<Carrier> carrier;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="contact")
	public List<Carrier> getCarrier() {
		return carrier;
	}

	public void setCarrier(List<Carrier> carrier) {
		this.carrier = carrier;
	}


	
	private List<Tpa> tpa;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="contact")
	public List<Tpa> getTpa() {
		return tpa;
	}

	public void setTpa(List<Tpa> tpa) {
		this.tpa = tpa;
	}

	/*private SimpleObjectProperty<Note> note = new SimpleObjectProperty<Note>(this, "note");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "note_id")
	public Note getNote() {
		return note.get();
	}

	public void setNote(Note note) {
		this.note.set(note);
	}

	public SimpleObjectProperty<Note> noteProperty() {
		return note;
	}*/
	
	private List<Clinic> clinic;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="contact")
	public List<Clinic> getClinic() {
		return clinic;
	}

	public void setClinic(List<Clinic> clinic) {
		this.clinic = clinic;
	}

	private List<Laboratory> lab;
	
   @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="contact")
	public List<Laboratory> getLab() {
		return lab;
	}

	public void setLab(List<Laboratory> lab) {
		this.lab = lab;
	}

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
	
/*	private List<Company> companies;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="contact")
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}*/
	
	
	
	
	private SimpleObjectProperty<Company> company = new SimpleObjectProperty<Company>(this, "company");
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company.get();
	}

	public void setCompany(Company company) {
		this.company.set(company);
	}

	public SimpleObjectProperty<Company> companyProperty() {
		return company;
	}
	

	public Contact() {

	}

}
