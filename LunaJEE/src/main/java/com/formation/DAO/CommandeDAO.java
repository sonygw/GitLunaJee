package com.formation.DAO;

import java.util.ArrayList;

import com.formation.model.Commande;

public interface CommandeDAO {

	/**
	 * Selectionne toutes les commandes
	 * @return ArrayList de clients
	 */
	public ArrayList<Commande> SelectAllCommandes();
	/**
	 * Selectionne les Commandes d'un client
	 * @param idclient id du client
	 * @return une arrayList des commandes du client
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
	public Commande SelectLastCommande();
	/**
	 * Cr�er une commande 
	 * @param commande Objet commande � cr�er
	 * @return un objet commande
	 */
	
	public Commande SaveOrUpdateCommande(Commande commande);
	/**
	 * Supprime la commande
	 * @param commande a supprimer
	 * @return un objet commande
	 */
	
	public Commande DeleteCommande(Commande commande);
	
}
