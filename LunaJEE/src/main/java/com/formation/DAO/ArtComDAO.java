package com.formation.DAO;

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
	 * Cr�er un ArtCom en base
	 * 
	 * @param obj
	 *            objet commande
	 * @return bool�en de verif
	 */

	ArtCom SaveOrUpdateArtCom(ArtCom obj);

	ArtCom DeleteArtCom(ArtCom obj);
}
