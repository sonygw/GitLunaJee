package com.formation.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.formation.model.ArtCom;

/**
 * 
 * @author Lou
 *
 */
public interface ArtComDAO {
	/**
	 * retourne tous les ArtCom en fonction d'une commande
	 * 
	 * @param idCommande
	 *            ide de la commande
	 * @return ArrayList de ArtCom
	 */
	public ArrayList<ArtCom> SelectAllArtComFromCommande(int idCommande);

	/**
	 * Suppression du ArtCom
	 * 
	 * @param obj
	 *            objet commande
	 * @return ArrayList de ArtCom
	 */
	public boolean DeleteArtComFromCommande(ArtCom obj);

	/**
	 * Met � jour en base un ArtCom en fonction de l'ID
	 * 
	 * @param obj
	 *            objet commande
	 * @param idArtCom
	 * @return bool�en de verif
	 */
	public boolean UpdateArtComFromCommande(ArtCom obj, int idArtCom);

	/**
	 * Cr�er un ArtCom en base
	 * 
	 * @param obj
	 *            objet commande
	 * @return bool�en de verif
	 */
	public boolean CreateArtComFromCommande(ArtCom obj);

	/**
	 * Delete un ArtCom a partir d'un ID Commande
	 * 
	 * @param id
	 *            id de la commande
	 * @return bool�en de verif
	 */
	public boolean DeleteArtComFromIdCommande(int id);

	/**
	 * Delete un ArtCom � parrie d'un ID Article
	 * 
	 * @param id
	 *            id de la commande
	 * @return bool�en de verif
	 */
	public boolean DeleteArtComFromIdArticle(int id);
}
