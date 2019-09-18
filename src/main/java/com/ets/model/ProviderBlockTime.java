package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderBlockTime Class
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "provider_block_time")

public class ProviderBlockTime {
	
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

	@ManyToOne
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


	private ObjectProperty<Date> blockTimeDate = new SimpleObjectProperty<Date>();

	@Column(name = "blockTimeDate")
	@Temporal(TemporalType.DATE)
	public Date getBlockTimeDate() {
		return blockTimeDate.get();
	}

	public void setBlockTimeDate(Date blockTimeDate) {
		this.blockTimeDate.set(blockTimeDate);
	}

	public ObjectProperty<Date> blockTimeDateProperty() {
		return this.blockTimeDate;
	}
	
	private StringProperty blockTime = new SimpleStringProperty(this, "blockTime");

	@Column(name = "block_time")
	public String getBlockTime() {
		return blockTime.get();
	}

	public void setBlockTime(String blockTime) {
		this.blockTime.set(blockTime);
	}

	public StringProperty blockTimeProperty() {
		return blockTime;
	}
	
		


	public ProviderBlockTime() {
		// TODO Auto-generated constructor stub
	}

}
