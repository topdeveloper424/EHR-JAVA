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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="drug_screen_mro")
public class DrugScreenMRO {
	
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
	
	private SimpleObjectProperty<Provider> mro = new SimpleObjectProperty<Provider>(this, "mro");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mro")
	public Provider getMro() {
		return mro.get();
	}

	public void setMro(Provider mro) {
		this.mro.set(mro);
	}

	public SimpleObjectProperty<Provider> mroProperty() {
		return mro;
	}
	
	private ObjectProperty<Date> requestDate  = new SimpleObjectProperty<Date>();

	@Column(name = "request_date")
	@Temporal(TemporalType.DATE)
	public Date getRequestDate() {
		return requestDate.get();
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate.set(requestDate);
	}

	public ObjectProperty<Date> requestDateProperty() {
		return this.requestDate;
	}
	
	private StringProperty mroReviewedOn  = new SimpleStringProperty(this, "mroReviewedOn");

	@Column(name = "mro_reviewed_on")
	public String getMroReviewedOn() {
		return mroReviewedOn.get();
	}

	public void setMroReviewedOn(String mroReviewedOn) {
		this.mroReviewedOn.set(mroReviewedOn);
	}

	public StringProperty mroReviewedOnProperty() {
		return mroReviewedOn;
	}
	
	private StringProperty employeeNotifiedOn      = new SimpleStringProperty(this, "employeeNotifiedOn");

	@Column(name = "employee_notified_on")
	public String getEmployeeNotifiedOn() {
		return employeeNotifiedOn.get();
	}

	public void setEmployeeNotifiedOn(String employeeNotifiedOn) {
		this.employeeNotifiedOn.set(employeeNotifiedOn);
	}

	public StringProperty employeeNotifiedOnProperty() {
		return employeeNotifiedOn;
	}
	
	private StringProperty finalDetermin = new SimpleStringProperty(this, "finalDetermin");

	@Column(name = "final_determin")
	public String getFinalDetermin() {
		return finalDetermin.get();
	}

	public void setfinalDetermin(String finalDetermin) {
		this.finalDetermin.set(finalDetermin);
	}

	public StringProperty finalDeterminProperty() {
		return finalDetermin;
	}
	
	private StringProperty splitSpecimenReq  = new SimpleStringProperty(this, "splitSpecimenReq");

	@Column(name = "split_specimen_req")
	public String getSplitSpecimenReq() {
		return splitSpecimenReq.get();
	}

	public void setSplitSpecimenReq(String splitSpecimenReq) {
		this.splitSpecimenReq.set(splitSpecimenReq);
	}

	public StringProperty splitSpecimenReqProperty() {
		return splitSpecimenReq;
	}
	
	private ObjectProperty<Date> finalDeterminDate    = new SimpleObjectProperty<Date>();

	@Column(name = "final_determin_date")
	@Temporal(TemporalType.DATE)
	public Date getFinalDeterminDate() {
		return finalDeterminDate.get();
	}

	public void setFinalDeterminDate(Date finalDeterminDate) {
		this.finalDeterminDate.set(finalDeterminDate);
	}

	public ObjectProperty<Date> finalDeterminDateProperty() {
		return this.finalDeterminDate;
	}
	
	private StringProperty splitResultReceived   = new SimpleStringProperty(this, "splitResultReceived");

	@Column(name = "split_result_received")
	public String getSplitResultReceived() {
		return splitResultReceived.get();
	}

	public void setSplitResultReceived(String splitResultReceived) {
		this.splitResultReceived.set(splitResultReceived);
	}

	public StringProperty splitResultReceivedProperty() {
		return splitResultReceived;
	}
	
	private StringProperty reportedToEmployerBy    = new SimpleStringProperty(this, "reportedToEmployerBy");

	@Column(name = "reported_to_employer_by")
	public String getReportedToEmployerBy() {
		return reportedToEmployerBy.get();
	}

	public void setReportedToEmployerBy(String reportedToEmployerBy) {
		this.reportedToEmployerBy.set(reportedToEmployerBy);
	}

	public StringProperty reportedToEmployerByProperty() {
		return reportedToEmployerBy;
	}
	
	private StringProperty comments     = new SimpleStringProperty(this, "comments");

	@Column(name = "comments")
	public String getComments() {
		return comments.get();
	}

	public void setComments(String comments) {
		this.comments.set(comments);
	}

	public StringProperty commentsProperty() {
		return comments;
	}

	public DrugScreenMRO() {
		
	}

}
