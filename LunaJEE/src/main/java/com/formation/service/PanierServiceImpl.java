package com.formation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.DAO.PanierDAO;
import com.formation.model.Client;
import com.formation.model.Panier;

@Service
@Transactional
public class PanierServiceImpl implements PanierService {

	@Autowired
	private PanierDAO panierDao;
	
	@Override
	public boolean SaveOrUpdatePanier(Panier obj) {
		if(panierDao.SaveOrUpdatePanier(obj).getIdPanier()!=0)
			return true;
		else return false;
	}

	@Override
	public ArrayList<Panier> SelectPanierFromClient(Client client) {
		return panierDao.SelectPanierFromClient(client);
	}

	@Override
	public long SelectCountArticleFromPanier(Client obj) {
		return panierDao.SelectCountArticleFromPanier(obj);
		
	}

	@Override
	public boolean DeletePanier(Panier obj) {
		if(panierDao.DeletePanier(obj).getIdPanier()!=0)
		return false;
		else return true;
	}

	@Override
	public ArrayList<Panier> DeletePanierFromClient(Client client) {
		return panierDao.DeletePanierFromClient(client);
		
	}

}
