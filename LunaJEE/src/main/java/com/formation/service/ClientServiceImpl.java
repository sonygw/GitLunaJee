/**
 * 
 */
package com.formation.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.DAO.ClientDAO;
import com.formation.model.Client;

/**
 * @author SDJ09
 *
 */
@Repository
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDao;

	public ClientServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client SelectClient(int id) {

		return clientDao.SelectClient(id);

	}

	@Override
	public ArrayList<Client> SelectAllClients() {
		return clientDao.SelectAllClients();
	}

	@Override
	public boolean DeleteClient(Client obj) {
		return clientDao.DeleteClient(obj);
	}

	@Override
	public boolean UpdateClient(Client obj) {

		return clientDao.UpdateClient(obj);
	}

	@Override
	public boolean CreateClient(Client obj) {

		return clientDao.CreateClient(obj);
	}


	@Override
	public ArrayList<Client> SelectAllClientsByName(String nom) {

		return clientDao.SelectAllClientsByName(nom);
	}


	@Override
	public Client SelectLastClient() {

		return clientDao.SelectLastClient();

	}

}