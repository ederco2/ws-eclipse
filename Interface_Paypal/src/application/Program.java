package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalService;
import model.services.contractService;

public class Program {

	public static void main(String[] args) throws ParseException {
			
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number:");
		Integer number= sc.nextInt();
		sc.nextLine();
		System.out.print("Date(dd/MM/yyyy): ");		
		Date dateC= sdf.parse(sc.nextLine());
		
		System.out.print("Contract value: ");
		Double valueAmount=sc.nextDouble();		
		
		System.out.print("Enter number of installments: ");
		int n=sc.nextInt();		
		
		Contract contract = new Contract(number, dateC,valueAmount);
		
		contractService contractService = new contractService(new PaypalService());
		
		contractService.processContract(contract,n);
			
		
		System.out.println("Installments: ");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
		sc.close();
	}

}
