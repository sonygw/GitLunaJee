package com.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
@Service
public class Client {

	@Id
	@GeneratedValue
	private long idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private boolean carteFidelite;
	private String numeroTelephone;
	private String remarques;
	private String date;
	private String code;
	private String login;
	private String motDePasse;
	private boolean admin;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Client(String nom, String prenom, String email, String adresse, boolean carteFidelite,
			String numeroTelephone, String remarques, String date, String code, String login, String motDePasse,
			boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.carteFidelite = carteFidelite;
		this.numeroTelephone = numeroTelephone;
		this.remarques = remarques;
		this.date = date;
		this.code = code;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean isCarteFidelite() {
		return carteFidelite;
	}

	public void setCarteFidelite(boolean carteFidelite) {
		this.carteFidelite = carteFidelite;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String fidel() {
		String reponse;
		if (carteFidelite)
			reponse = "Oui";
		else
			reponse = "Non";
		return reponse;

	}

}
