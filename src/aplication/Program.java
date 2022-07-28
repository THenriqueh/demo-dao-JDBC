package aplication;

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
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1 seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=== TEST 2  seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TEST 3  seller findByDepartment ===");
		List<Seller> list1 = sellerDao.findAll();
		for (Seller obj : list1) {
			System.out.println(obj);
		}
		System.out.println("=== TEST 4  seller findByDepartment ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insered new Id = " + newSeller.getId());
		
		System.out.println("=== TEST 5  seller findByDepartment ===");
		Seller seller2 = new Seller();
		seller2 = sellerDao.findById(1);
		seller2.setName("Martha");
		sellerDao.update(seller2);
		System.out.println("Update completed");
		System.out.println("=== TEST 6  seller findByDepartment ===");
		System.out.println("Enter Id:");
		int id = sc.nextInt();
		sellerDao.deletById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
