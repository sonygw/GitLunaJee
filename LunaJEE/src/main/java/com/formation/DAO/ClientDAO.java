package com.formation.DAO;

import java.util.ArrayList;

import com.formation.model.Client;

public interface ClientDAO {

	/**
	 * S�lection d'un client en fonction de son id.
	 * @param id du client
	 * @return un client suivant son id
	 */
	public Client SelectClient(int id);

	/**
	 * S�lection de tous les clients de la base de donn�es sous forme d'ArrayList.
	 * @return Arraylist de tous les clients.
	 */
	public ArrayList<Client> SelectAllClients();
	/**
	 *  S�lection de tous les clients de la base de donn�es avec tri par nom. 
	 * @param nom du client
	 * @return Arraylist de tous les clients tri�s par leur nom.
	 */
	public ArrayList<Client> SelectAllClientsByName(String nom);
	
	/**
	 * Suppression d'un objet Client.
	 * @param obj client
	 * @return bool�en de v�rification : vrai si r�ussi
	 */
	public boolean DeleteClient(Client obj);
	

	/**
	 * Modification d'un objet Client dans la base de donn�es.
	 * @param obj client
	 * @param id du client
	 * @return bool�en de v�rification : vrai si r�ussi
	 */
	public boolean UpdateClient(Client obj);
	

	/**
	 * Cr�ation d'un objet client dans la base de donn�es.
	 * @param obj client
	 * @return bool�en de v�rification : vrai si reussi
	 */
	public boolean CreateClient(Client obj);
	
	
	/**
	 * S�lection du dernier client de la base de donn�es.
	 * @return le dernier client de la base de donn�es
	 */
	public Client SelectLastClient();

}
