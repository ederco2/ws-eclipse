package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entites.Product;

public class Program {
	
	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV",900.00));
		list.add(new Product("Notebook",1200.00));
		list.add(new Product("Tablet",450.00));
		
		//Comparator<Product> comp = (p1,p2)->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); //arrow function
			/*new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				// TODO Auto-generated method stub
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
			*/
			
		
		list.sort((p1,p2)->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for (Product product : list) {
			System.out.println(product);
		}
	}

}
