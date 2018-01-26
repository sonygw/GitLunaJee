package com.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
@Service
public class Article {

	@Id
	@GeneratedValue
	private long idArticle;

	private String nom;
	private String code;
	private String description;
	private double prixHT;
	private int quantite;
	private String categorie;
	private boolean visible = true;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(String nom, String code, String description, double prixHT, int quantite, String categorie,
			boolean visible) {
		super();
		this.nom = nom;
		this.code = code;
		this.description = description;
		this.prixHT = prixHT;
		this.quantite = quantite;
		this.categorie = categorie;
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", code=" + code + ", description=" + description
				+ ", prixHT=" + prixHT + ", quantite=" + quantite + ", categorie=" + categorie + ", visible=" + visible
				+ "]";
	}

}
