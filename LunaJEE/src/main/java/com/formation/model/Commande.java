package com.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	private long idCommande;
	private String ref;
	private double prixHT;
	private String adresse;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Client client;
	
	
	private String reglement;
	private String date;

	/**
	 * Constructeur vide
	 */
	public Commande() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructeur avec param�tres
	 * @param idCommande 
	 * @param ref
	 * @param prixHT
	 * @param adresse
	 * @param idClient
	 * @param date
	 * @param reglement
	 */
	public Commande(int idCommande, String ref, double prixHT, String adresse, String date,
			String reglement) {
		super();
		this.idCommande = idCommande;
		this.ref = ref;
		this.prixHT = prixHT;
		this.adresse = adresse;
		this.date = date;
		this.reglement = reglement;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getReglement() {
		return reglement;
	}

	public void setReglement(String reglement) {
		this.reglement = reglement;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
