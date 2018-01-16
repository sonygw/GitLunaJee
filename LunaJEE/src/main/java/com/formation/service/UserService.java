package com.formation.service;

import java.util.ArrayList;

import com.formation.model.User;

public interface UserService {

	/**
	 * Selectionne un User en fonction de l'ID du User
	 * @param id ID du User
	 * @return un User qui correspond � l'ID
	 */
	public User SelectUser(int id);
	/**
	 * Selectionne tous les Users
	 * @return un ArrayList de User
	 */
	public ArrayList<User> SelectAllUsers();
	/**
	 * Update un User en fonction de l'ID
	 * @param user Objet User 
	 * @param id Identifiant de l'User qu'on veux update
	 * @return un bool de v�rif. true = reussi
	 */
	public boolean UpdateUser(User user);
	/**
	 * Cr�er un User en fonction d'un objet User
	 * @param user Objet User
	 * @return un bool de v�rif. true = reussi
	 */
	public boolean CreateUser(User user);
	/**
	 * Delete un User gr�ce � son ID
	 * @param id Identifiant de l'utilisateur
	 * @returnun bool de v�rif. true = reussi
	 */
	
	public boolean DeleteUser(User user);
	
}
