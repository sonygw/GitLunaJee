package com.formation.model;

import java.util.Date;

public class Commande {

	private int idCommande;
	private String ref;
	private double prixHT;
	private String adresse;
	private int idClient;
	private String reglement;
	private String date;

	/**
	 * Constructeur vide
	 */
	public Commande() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructeur avec paramètres
	 * @param idCommande 
	 * @param ref
	 * @param prixHT
	 * @param adresse
	 * @param idClient
	 * @param date
	 * @param reglement
	 */
	public Commande(int idCommande, String ref, double prixHT, String adresse, int idClient, String date,
			String reglement) {
		super();
		this.idCommande = idCommande;
		this.ref = ref;
		this.prixHT = prixHT;
		this.adresse = adresse;
		this.idClient = idClient;
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

	public int getIdCommande() {
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
