package app;

import java.util.ArrayList;

public class Stock <E>{

	private ArrayList<E> stock;
	private int quantity;

	public Stock() {
		stock=new ArrayList<E>();
	}
	
	public void addProduct(E elemento) {
		stock.add(elemento);
		quantity++;
	}
	
	public void showProducts(int eachProduct) {
		for (int i = 0; i < eachProduct; i++) {
			System.out.println(i+1+") ");
			System.out.println(stock.get(i).toString());
		}
	}
	
}
