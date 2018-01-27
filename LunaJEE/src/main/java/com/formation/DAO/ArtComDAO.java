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
	 * Cr�er ou modifier un ArtCom en base
	 * 
	 * @param obj
	 *            objet commande
	 * @return un artCom
	 */

	ArtCom SaveOrUpdateArtCom(ArtCom obj);

	/**
	 * Suppression d'un ArtCom
	 * @param obj ArtCom
	 * @return un artcom
	 */
	ArtCom DeleteArtCom(ArtCom obj);
}
