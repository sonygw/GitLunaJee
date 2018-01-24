package com.formation.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Service;

@Service
@Entity
public class ArtCom {
	
	@Id
	@GeneratedValue
	private long idArtCom;
	private int quantite;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Article article;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Commande commande;
	
	public ArtCom() {
		// TODO Auto-generated constructor stub
	}

	
	public ArtCom(int quantite, Article article, Commande commande) {
		super();
		this.quantite = quantite;
		this.article = article;
		this.commande = commande;
	}


	public long getIdArtCom() {
		return idArtCom;
	}

	public void setIdArtCom(long idArtCom) {
		this.idArtCom = idArtCom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
	
	

}
