package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of produtcs: ");
		int number = sc.nextInt();
		for (int i = 0; i < number ; i++) {
			System.out.print("Product #"+i+ "data:");
			System.out.print("Common, used or impoted (c/u/i)?");
			char c = sc.next().charAt(0);			
			sc.nextLine();
			if (c == 'i') {
				
				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Price:");
				double price = sc.nextDouble();
				System.out.print("Customs fee:");
				double customsFee =sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				products.add(product);
			}else if (c == 'c') {
				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Price:");
				double price = sc.nextDouble();
				Product product = new Product(name, price);
				products.add(product);
				
			}else if (c == 'u') {
				System.out.print("Name:");
				String name = sc.nextLine();
				System.out.print("Price:");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());		
				Product product = new UsedProduct(name, price, manufactureDate);
				products.add(product);
			}
		}
		System.out.println("Price TAGS:");
		for(Product p :products) {
			System.out.print(p.priceTag()+"\n");
		}
		sc.close();
		
	}
}
