package com.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ArtCom {
	
	@Id
	@GeneratedValue
	private int idArtCom;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private int idCommande;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private int idArticle;
	private int quantite;
	
	public ArtCom() {
		// TODO Auto-generated constructor stub
	}

	public ArtCom(int idArtCom, int idCommande, int idArticle, int quantite) {
		super();
		this.idArtCom = idArtCom;
		this.idCommande = idCommande;
		this.idArticle = idArticle;
		this.quantite = quantite;
	}

	public int getIdArtCom() {
		return idArtCom;
	}

	public void setIdArtCom(int idArtCom) {
		this.idArtCom = idArtCom;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
