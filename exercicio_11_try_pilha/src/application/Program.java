package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		method1();
		System.out.println("End program");
	}
	
	public static void method1() {
		System.out.println("*****method1 start*****");
		method2();
		System.out.println("*****method1 end*****");
		
	}

	public static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****method2 start*****");
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position");
			e.printStackTrace();
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		}
		System.out.println("*****method2 end*****");
		sc.close();
	}
}
