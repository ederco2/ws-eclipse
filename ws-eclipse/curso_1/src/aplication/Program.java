package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		
		
		Product[] Prod = new Product[n];
		
		for(int i=0; i<Prod.length; i++) {
			sc.nextLine();
			
			String name=sc.nextLine();			
			double price = sc.nextDouble();
			
			Prod[i]= new Product(name, price);
		}
		
		
		double sum=0.0;
		for (int i = 0; i <Prod.length; i++) {
			sum  += Prod[i].getPrice();
		}
			
		System.out.println("Media:"+sum/n);	
		
		
		for (int i = 0; i < Prod.length; i++) {
			System.out.println(Prod[i].toString());	
		}
		
		
		sc.close();

	}

}
