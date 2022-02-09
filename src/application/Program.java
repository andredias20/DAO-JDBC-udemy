package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Department dp = new Department(1, "Books");
		
		
		
		Seller sl = new Seller(21, "Carlinhos", "carlito@gmail.com", new Date(), 2000.00, dp);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		
		System.out.println(sl);
		
	}
}
