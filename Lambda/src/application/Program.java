package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import Util.ProductPredicate;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		double min=100.0;
		//Predicate<Product> pred = p->p.getPrice()>=100;//4º metodo

		//list.removeIf(new ProductPredicate());//1º metodo
		//list.removeIf(Product::staticProductPredicate);//2 metodo		
		//list.removeIf(Product::nonStaticProductPredicate);3ºmetodo
		//list.removeIf(pred);
		list.removeIf(p -> p.getPrice()>=min);
		
		list.forEach(System.out::println);
	
	}
}