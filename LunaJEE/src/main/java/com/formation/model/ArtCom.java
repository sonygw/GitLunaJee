package com.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ArtCom {
	
	@Id
	@GeneratedValue
	private long idArtCom;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private long idCommande;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private long idArticle;
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

	public long getIdArtCom() {
		return idArtCom;
	}

	public void setIdArtCom(int idArtCom) {
		this.idArtCom = idArtCom;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public long getIdArticle() {
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
