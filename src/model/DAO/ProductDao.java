package model.DAO;

import java.util.List;

import model.entities.Client;
import model.entities.Product;

public interface ProductDao {
	public void insert(Product prod);
	
	public void update(Product prod);
	
	public void deleteById(Integer id);
	
	public Client findById(Integer id);
	
	public List<Product> findAll();
}
