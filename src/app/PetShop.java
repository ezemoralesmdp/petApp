package app;

import java.util.Scanner;

public class PetShop {
	// Clase generica Stock que puede almacenar Juguetes, Ropa o Comida
	// Clase juguete, Clase ropa, Clase comida
	// Internamente tendria Objetos de tipo Producto
	// Producto tendria internamente un String y un Double

	Scanner input = new Scanner(System.in);

	private Stock<Toy> stockToys;
	private Stock<Clothe> stockClothes;
	private Stock<Food> stockFoods;
	private int amountToys = 5;
	private int amountClothes = 7;
	private int amountFoods = 10;

	public PetShop() {
		stockToys = new Stock<Toy>();
		stockClothes = new Stock<Clothe>();
		stockFoods = new Stock<Food>();
	}

	public void cargarProductos() {

		Toy toy1 = new Toy("Pelota De Goma Caucho Maciza Para Perros 7.5 Cm", 1099.99);
		Toy toy2 = new Toy("Cuerda con nudos Perros", 1099.99);
		Toy toy3 = new Toy("Puzzle para perros comedero", 6590.00);
		Toy toy4 = new Toy("Juguete Perro Cuerda Circular", 3000);
		Toy toy5 = new Toy("Pescado Interactivo con Carga Micro USB", 5490.69);
		Toy toy6 = new Toy("Pelota Porfiada, Ratón y Plumas", 1200.50);

		Clothe clothe1 = new Clothe("Poncho Capa Buzo Abrigo Polar Para Mascotas Talles Varios", 1445.99);
		Clothe clothe2 = new Clothe("Campera abrigo mascota para perro cachorro", 2962.00);
		Clothe clothe3 = new Clothe("Polar rosa talle 2 Perro", 1599.00);
		Clothe clothe4 = new Clothe("Polar naranja talle 3", 1599.00);

		Food food1 = new Food("Royal Canin Urinary Care", 17490.00);
		Food food2 = new Food("Royal Canin Ageing 12+ Feline", 23990.00);
		Food food3 = new Food("Royal Canin Urinary Care", 17490.00);
		Food food4 = new Food("Royal Canin Hepatic Feline 1.5 kg", 19990.00);
		Food food5 = new Food("Royal Canin Mother & Babycat", 12990.00);
		Food food6 = new Food("Royal Canin Gastrointestinal Canine", 17090.00);
		Food food7 = new Food("Hill´s L/D Canine 7.98 kg", 78500.00);
		Food food8 = new Food("Hill’s Science Diet Puppy", 17990.00);
		Food food9 = new Food("Hill´s Natural Training Treat", 4990.00);
		Food food10 = new Food("Royal Canin Puppy X-Small", 11490.00);

		for (int i = 0; i < amountToys; i++) {
			stockToys.addProduct(toy1);
			stockToys.addProduct(toy2);
			stockToys.addProduct(toy3);
			stockToys.addProduct(toy4);
			stockToys.addProduct(toy5);
			stockToys.addProduct(toy6);
		}

		for (int i = 0; i < amountClothes; i++) {
			stockClothes.addProduct(clothe1);
			stockClothes.addProduct(clothe2);
			stockClothes.addProduct(clothe3);
			stockClothes.addProduct(clothe4);
		}

		for (int i = 0; i < amountFoods; i++) {
			stockFoods.addProduct(food1);
			stockFoods.addProduct(food2);
			stockFoods.addProduct(food3);
			stockFoods.addProduct(food4);
			stockFoods.addProduct(food5);
			stockFoods.addProduct(food6);
			stockFoods.addProduct(food7);
			stockFoods.addProduct(food8);
			stockFoods.addProduct(food9);
			stockFoods.addProduct(food10);
		}

	}

	public void shopMenu() {
		int option = 0;

		do {
			System.out.println("1)Juguetes");
			System.out.println("2)Ropa");
			System.out.println("3)Alimentos");
			System.out.println("0)Salir");
			option = input.nextInt();
			switch (option) {
			case 1:
				shopMenu_toys();
				break;
			case 2:

				break;
			case 3:

				break;
			case 0:

				break;
			default:
				System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
				break;
			}
		} while (option < 1 || option > 3);
	}

	public void shopMenu_toys() {
			stockToys.showProducts(amountToys);
	}
}