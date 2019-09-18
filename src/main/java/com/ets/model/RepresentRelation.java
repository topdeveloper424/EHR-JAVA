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
import javax.persistence.Table;

@Entity
@Table(name = "representative_relation")
public class RepresentRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "representative_id")
	private PatientAuthRep rep;
	
	
	@Column(name = "relation")
	private String relation;
	
	@Column(name = "relation_notes")
	private String relation_notes;
		
	public String getRelation_notes() {
		return relation_notes;
	}
	public void setRelation_notes(String relation_notes) {
		this.relation_notes = relation_notes;
	}
	public Patient getPat() {
		return patient;
	}
	public void setPat(Patient patient) {
		this.patient = patient;
	}
	public PatientAuthRep getRep() {
		return rep;
	}
	public void setRep(PatientAuthRep rep) {
		this.rep = rep;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
	
	public RepresentRelation() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
