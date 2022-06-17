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
	
}
