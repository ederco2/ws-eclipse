package aplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Eder");
		list.add("Joao");
		list.add("Maria");
		list.add("Pedro");
		
		list.add(1, "Josi");
		list.remove(2);
		
		list.removeIf(x -> x.charAt(0) == 'M');
		
		
		
		System.out.println(list.size());
		for(String x:list) {
			System.out.println(x);
		}
		System.out.println("Codigo indexof: Josi: "+list.indexOf("Josi"));
		System.out.println("=============================");
		List<String> result = list.stream().filter(x -> x.charAt(0)=='P').collect(Collectors.toList());
		
		for (String string : result) {
			System.out.println(string);
		}
		System.out.println("=============================");

	}

}
