package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produtos;

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		List<Produtos> produtos = new ArrayList<>();

		String path = "c:\\temp\\produtos.txt";
		String path1 = "c:\\temp\\out\\summary.csv";

		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		boolean success = new File(strPath+"\\out").mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String itemCsv = br.readLine();

			while (itemCsv != null) {
				String[] vect = itemCsv.split(",");
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer quantity = Integer.parseInt(vect[2]);
				produtos.add(new Produtos(name, price, quantity));

				itemCsv = br.readLine();
			}
		}

		for (Produtos list : produtos) {
			System.out.println(list);
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path1))){
			for(Produtos line :produtos) {
				bw.write(line.getName()+" "+line.getPrice()*line.getQuantity());
				bw.newLine();
			}
			
		}
		System.out.println("Diretorico criado com sucesso: "+success);
		sc.close();
	}

}
