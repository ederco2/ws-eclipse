package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	Date dataPay= new Date();
	
	System.out.println("Enter client data:");
	System.out.print("Name:");
	String name = sc.nextLine();
	System.out.print("Email:");
	String email = sc.nextLine();
	System.out.print("Birth date (DD/MM/YYYY): ");
	Date birthDate = sdf.parse(sc.next()); 
	
	Client client = new Client(name, email, birthDate);
	
	System.out.println("Enter order data: ");
	System.out.print("Status(PROCESSING): ");
	
	String statusPg = sc.next();
	
	
	
	Order order = new Order(dataPay, OrderStatus.valueOf(statusPg), client);
	
	System.out.println("How many items to this order? ");
	
	int n = sc.nextInt();	
	for(int i=1; i<=n;i++) {
		System.out.println("Enter #"+i+" item data:");
		System.out.println("Product name:");
		sc.nextLine();
		String productName =sc.nextLine();
		System.out.println("Product Price:");
		double productPrice=sc.nextDouble();
		
		Product product = new Product(productName, productPrice);
		
		System.out.print("Quantity:");
		int quantity = sc.nextInt();
		
		OrderItem orderItem = new OrderItem(quantity, productPrice,product);
		
		order.addOrderItems(orderItem);
		
	}	
	System.out.println("ORDER SUMARY: ");	
	System.out.println(order);
	
	sc.close();
	}

}
