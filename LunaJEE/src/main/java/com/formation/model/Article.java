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
	private String code;
	private String description;
	private double prixHT;
	private int quantite;
	private String categorie;
	private boolean visible = true;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int idArticle, String code, String description, double prixHT, int quantite, String categorie) {
		super();
		this.idArticle = idArticle;
		this.code = code;
		this.description = description;
		this.prixHT = prixHT;
		this.quantite = quantite;
		this.categorie = categorie;
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

	
	
	
}
