package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Rooms;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Quantos quartos precisa?");
		
		int n = sc.nextInt();
		sc.nextLine();
		Rooms[] quarto = new Rooms[10];
		
		for (int i = 0; i < n; i++) {
			
			System.out.print("Qual o nome do Estudante:");
			String name = sc.nextLine();
			System.out.print("Qual o Email:");			
			String emails = sc.nextLine();				
			System.out.print("Quartos vagos 0 a 9:");			
			int room = sc.nextInt();		
			sc.nextLine();
			quarto[room]= new Rooms(name, emails, room);			
		}		
		
		for (int i = 0; i < 10; i++) {
			if (quarto[i] != null){
				System.out.println("Busy Roms: "+quarto[i].getRooms()+", "+quarto[i].getName()+", "+quarto[i].getEmail());
			}
		}
		
		sc.close();
	}

}
