package com.formation.DAO;

import java.util.ArrayList;

import com.formation.model.Client;

public interface ClientDAO {

	/**
	 * Sélection d'un client en fonction de son id.
	 * @param id du client
	 * @return un client suivant son id
	 */
	public Client SelectClient(int id);

	/**
	 * Sélection de tous les clients de la base de données sous forme d'ArrayList.
	 * @return Arraylist de tous les clients.
	 */
	public ArrayList<Client> SelectAllClients();
	/**
	 *  Sélection de tous les clients de la base de données avec tri par nom. 
	 * @param nom du client
	 * @return Arraylist de tous les clients triés par leur nom.
	 */
	public ArrayList<Client> SelectAllClientsByName(String nom);
	
	/**
	 * Suppression d'un objet Client.
	 * @param obj client
	 * @return booléen de vérification : vrai si réussi
	 */
	public boolean DeleteClient(Client obj);
	

	/**
	 * Modification d'un objet Client dans la base de données.
	 * @param obj client
	 * @param id du client
	 * @return booléen de vérification : vrai si réussi
	 */
	public boolean UpdateClient(Client obj, int id);
	

	/**
	 * Création d'un objet client dans la base de données.
	 * @param obj client
	 * @return booléen de vérification : vrai si reussi
	 */
	public boolean CreateClient(Client obj);
	
	
	/**
	 * Sélection du dernier client de la base de données.
	 * @return le dernier client de la base de données
	 */
	public Client SelectLastClient();

}
