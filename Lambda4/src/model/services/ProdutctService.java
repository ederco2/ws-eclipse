package model.services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProdutctService {
	///soma produtos com a letra inicial
	public double filteredSum(List<Product> list,Predicate<Product> criteria) {
		double sum =0;
		for (Product product : list) {
			if (criteria.test(product)) {
				sum+=product.getPrice();
			}
		}
		return sum;
	}
}
