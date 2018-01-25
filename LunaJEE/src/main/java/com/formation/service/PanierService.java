package com.formation.service;

import java.util.ArrayList;

import com.formation.model.Client;
import com.formation.model.Panier;

public interface PanierService {
	
	public boolean SaveOrUpdatePanier(Panier obj);
	public ArrayList<Panier> SelectPanierFromClient(Client client);
	public long SelectCountArticleFromPanier(Client obj);
	public boolean DeletePanier(Panier obj);
	public boolean DeletePanierFromClient(Client client);	
	public Panier SelectPanierById(int id);
	
}
