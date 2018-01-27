package com.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Service;

@Entity
@Service
public class Panier {

	@Id
	@GeneratedValue
	private long idPanier;

	@OneToOne(fetch = FetchType.EAGER)
	private Article article;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Client client;
	private int quantite;
	private double prixHT;

	public Panier() {
		// TODO Auto-generated constructor stub
	}

	public long getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public Panier(Article article, int quantite, double prixHT) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.prixHT = prixHT;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
