package model.DAO;

import java.util.List;

import model.entities.Client;

public interface ClientDao {
	public void insert(Client cli);
	
	public void update(Client cli);
	
	public void deleteById(Integer id);
	
	public Client findById(Integer id);
	
	public List<Client> findAll();
}
