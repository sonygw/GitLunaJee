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
	 * @return
	 */
	public ArrayList<Commande> SelectCommandesClient(int idclient);
	/**
	 * Selectionne les commandes d'un articles
	 * @param id id de l'article
	 * @return
	 */
	public ArrayList<Commande> SelectCommandesArticles(int id);
	/**
	 * selectionne une commande grâce à son ID
	 * @param id id de la commande
	 * @return un objet Commande
	 */
	public Commande SelectCommande(int id);
	/**
	 * Selectionne la dernière commande
	 * @return un objet commande
	 */
	public Commande SelectLastCommande();
	/**
	 * Créer une commande 
	 * @param commande Objet commande à créer
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean CreateCommande(Commande commande);
	/**
	 * Update une commande grâce à son ID
	 * @param commande objet commande a inserer
	 * @param id id de la commande à modifier
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean UpdateCommande(Commande commande, int id);
	/**
	 * Supprime la commande
	 * @param id id de la commande à supprimer
	 * @return un bool de vérif. vrai = reussi
	 */
	public boolean DeleteCommande(int id);
	
}
