package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== TEST 1: seller findById ====");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: seller findAll ====");
		
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 4: seller Insert ====");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = "+ newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller Update ====");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Wane");
		sellerDao.update(seller);

		System.out.println("Updated!");
		
		System.out.println("\n==== TEST 5: seller Update ====");
		System.out.print("Enter id for delete test: ");
		int idDel = sc.nextInt();
		
		sellerDao.deleteById(idDel);
		
		System.out.println("Delete complete!");
		
		sc.close();
	}
}
