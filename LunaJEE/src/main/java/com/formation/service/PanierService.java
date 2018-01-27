package com.formation.service;

import java.util.ArrayList;

import com.formation.model.Client;
import com.formation.model.Panier;

public interface PanierService {
	
	/**
	 * Ajout ou modification d'un panier
	 * @param un objet Panier obj
	 * @return un booleen de verification true=reussi
	 */
	public boolean SaveOrUpdatePanier(Panier obj);
	
	/**
	 * Selection des lignes du panier d'un client
	 * @param Objet client
	 * @return une liste des lignes du panier (arrayList)
	 */
	public ArrayList<Panier> SelectPanierFromClient(Client client);
	
	/**
	 * Compte du nombre d'article du panier d'un client
	 * @param obj Client
	 * @return un nombre d'article sous forme de long
	 */
	public long SelectCountArticleFromPanier(Client obj);
	
	/**
	 * Suppression d'un panier
	 * @param obj panier
	 * @return un booleen de verification false = reussi
	 */
	public boolean DeletePanier(Panier obj);
	
	/**
	 * Suppression du panier d'un client
	 * @param objet client
	 * @return booleen de verification false = reussi
	 */
	public boolean DeletePanierFromClient(Client client);	
	
	/**
	 * Selection d'un panier par son Id
	 * @param id
	 * @return Objet panier
	 */
	public Panier SelectPanierById(int id);
	
}
