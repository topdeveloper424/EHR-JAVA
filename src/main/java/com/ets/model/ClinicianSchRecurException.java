package com.ets.model;

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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@Entity
@Table(name = "clinician_sch_recur_exception")
public class ClinicianSchRecurException {



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
	private SimpleObjectProperty<Clinician> clinician = new SimpleObjectProperty<Clinician>(this, "clinician");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "clinician_id")
	public Clinician getClinician() {
		return clinician.get();
	}

	public void setClinician(Clinician clinician) {
		this.clinician.set(clinician);
	}

	public SimpleObjectProperty<Clinician> clinicianProperty() {
		return clinician;
	}

	
	// Column 4
		private SimpleObjectProperty<RecurEntry> recurEntry = new SimpleObjectProperty<RecurEntry>(this, "recurEntry");

		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "recur_entry_id")
		public RecurEntry getRecurEntry() {
			return recurEntry.get();
		}

		public void setRecurEntry(RecurEntry recurEntry) {
			this.recurEntry.set(recurEntry);
		}

		public SimpleObjectProperty<RecurEntry> recurEntryProperty() {
			return recurEntry;
		}
		// Column 4
		private SimpleObjectProperty<RecurPattern> recurPattern = new SimpleObjectProperty<RecurPattern>(this, "recurPattern");

		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "recur_pattern_id")
		public RecurPattern getRecurPattern() {
			return recurPattern.get();
		}

		public void setRecurPattern(RecurPattern recurPattern) {
			this.recurPattern.set(recurPattern);
		}

		public SimpleObjectProperty<RecurPattern> recurPatternProperty() {
			return recurPattern;
		}
		// Column 4
		private SimpleObjectProperty<OccurRange> occurRange = new SimpleObjectProperty<OccurRange>(this, "occurRange");

		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "occur_range_id")
		public OccurRange getOccurRange() {
			return occurRange.get();
		}

		public void setOccurRange(OccurRange occurRange) {
			this.occurRange.set(occurRange);
		}

		public SimpleObjectProperty<OccurRange> occurRangeProperty() {
			return occurRange;
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
	
	
	public ClinicianSchRecurException() {
		
	}

}
