package com.formation.service;

import java.util.ArrayList;

import com.formation.model.Commande;

public interface CommandeService {

	/**
	 * Selectionne toutes les commandes
	 * @return ArrayList de clients
	 */
	public ArrayList<Commande> SelectAllCommandes();
	/**
	 * Selectionne les Commandes d'un client
	 * @param idclient id du client
	 * @return
	 */
	public ArrayList<Commande> SelectCommandesClient(int idclient);
	
	/**
	 * selectionne une commande gr�ce � son ID
	 * @param id id de la commande
	 * @return un objet Commande
	 */
	public Commande SelectCommande(int id);
	/**
	 * Selectionne la derni�re commande
	 * @return un objet commande
	 */
	public boolean SelectLastCommande();
	/**
	 * Cr�er une commande 
	 * @param commande Objet commande � cr�er
	 * @return un bool de v�rif. vrai = reussi
	 */

	public boolean SaveOrUpdateCommande(Commande commande);
	/**
	 * Supprime la commande
	 * @param id id de la commande � supprimer
	 * @return un bool de v�rif. vrai = reussi
	 */
	
	public boolean DeleteCommande(Commande commande);
	
}
