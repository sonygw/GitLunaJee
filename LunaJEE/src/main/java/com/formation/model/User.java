package com.formation.model;

public class User {

	private int idUser;
	private String nom;
	private String login;
	private String motDePasse;
	private boolean admin;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int idUser, String nom, String login, String motDePasse, boolean admin) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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

	
}
