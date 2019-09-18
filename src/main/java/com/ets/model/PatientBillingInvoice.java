package com.ets.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "patient_billing_invoice")
public class PatientBillingInvoice {
	
	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");

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
	
	
	private  StringProperty total = new SimpleStringProperty(this, "total");
	
	@Column(name = "total")
	public  String getTotal(){
		return total.get();
	}
	
	public  void setTotal(String total){
		this.total.set(total);
		
	}
	
	public StringProperty totalProperty(){
		return total;
	}
	
	
	private ObjectProperty<Date> invoiceDate = new SimpleObjectProperty<Date>();

	@Column(name = "invoice_date")
	@Temporal(TemporalType.DATE)
	public Date getInvoiceDate() {
		return invoiceDate.get();
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate.set(invoiceDate);
	}

	public ObjectProperty<Date> invoiceDateProperty() {
		return this.invoiceDate;
	}
	
	
	private  StringProperty referance = new SimpleStringProperty(this, "referance");
	
	@Column(name = "referance")
	public  String getReferance(){
		return total.get();
	}
	
	public  void setReferance(String referance){
		this.referance.set(referance);
		
	}
	
	public StringProperty referanceProperty(){
		return referance;
	}
	
	
	private  StringProperty invoiceType = new SimpleStringProperty(this, "invoiceType");
	
	@Column(name = "invoice_type")
	public  String getInvoiceType(){
		return invoiceType.get();
	}
	
	public  void setInvoiceType(String invoiceType){
		this.invoiceType.set(invoiceType);
		
	}
	
	public StringProperty invoiceTypeProperty(){
		return invoiceType;
	}
	
	private  StringProperty status = new SimpleStringProperty(this, "status");
	
	@Column(name = "status")
	public  String getStatus(){
		return status.get();
	}
	
	public  void setStatus(String status){
		this.status.set(status);
		
	}
	
	public StringProperty statusProperty(){
		return status;
	}
	
	
	private SimpleObjectProperty<PatientVisit>  patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="patient_visit_id")
	 public PatientVisit getPatientVisit() {
			return patientVisit.get();
		}

		public void setPatientVisit(PatientVisit patientVisit) {
			this.patientVisit.set(patientVisit);
		}

		public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
			return patientVisit;
		}
		
		
		private SimpleBooleanProperty invoiceBatches = new SimpleBooleanProperty(this, "invoiceBatches");

		@Column(name = "invoice_batches")
		public boolean getInvoiceBatches() {
			return invoiceBatches.get();
		}

		public void setInvoiceBatches(boolean invoiceBatches) {
			this.invoiceBatches.set(invoiceBatches);
		}

		public BooleanProperty invoiceBatchesProperty() {
			return invoiceBatches;
		}

		
	
	
	

}
