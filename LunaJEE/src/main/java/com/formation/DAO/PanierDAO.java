package com.formation.DAO;

import java.util.ArrayList;

import com.formation.model.Client;
import com.formation.model.Panier;

public interface PanierDAO {
	
	public Panier SaveOrUpdatePanier(Panier obj);
	public ArrayList<Panier> SelectPanierFromClient(Client client);
	public int SelectCountArticleFromPanier();
	public Panier DeletePanier(Panier obj);
	public ArrayList<Panier> DeletePanierFromClient(Client client);
	

}
