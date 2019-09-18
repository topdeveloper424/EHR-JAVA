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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@Entity
@Table(name="provider_block_exception")
public class ProviderBlockDayException {
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

	private SimpleObjectProperty<Provider> provider = new SimpleObjectProperty<Provider>(this, "provider");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	public Provider getProvider() {
		return provider.get();
	}

	public void setProvider(Provider provider) {
		this.provider.set(provider);
	}

	public SimpleObjectProperty<Provider> providerProperty() {
		return provider;
	}



	// Column 2
	private ObjectProperty<Date> excepDate = new SimpleObjectProperty<Date>();

	@Column(name = "excep_date")
	@Temporal(TemporalType.DATE)
	public Date getExcepDate() {
		return excepDate.get();
	}

	public void setExcepDate(Date excepDate) {
		this.excepDate.set(excepDate);
	}

	public ObjectProperty<Date> excepDateDateProperty() {
		return this.excepDate;
	}


}
