package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program_TestDepartment {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 1: DepartmentFindBy =====");
		System.out.println(depDao.findById(2)); 
		
		
		System.out.println("\n==== Test 2: DepartmentFindAll =====");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n==== Test 3: DepartmentInsert =====");
		
		Department dep = new Department(null, "Carloes");
		depDao.insert(dep);
		System.out.println("Insert Complete!");
		System.out.println(depDao.findById(dep.getId()));
		
		System.out.println("\n==== Test 4: DepartmentUpdate =====");
		dep.setName("Modified Department");
		depDao.update(dep);
		System.out.println(depDao.findById(dep.getId()));
		
		System.out.println("\n==== Test 5: DepartmentDelete =====");
		
		depDao.deleteById(2);
		
		
	}

}
