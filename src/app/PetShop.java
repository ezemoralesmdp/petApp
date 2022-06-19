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
	
	//Usuario
	User loggedUser;
	
	//Juguetes
	Toy toy1 = new Toy("Pelota De Goma Caucho Maciza Para Perros 7.5 Cm", 1099.99);
	Toy toy2 = new Toy("Cuerda con nudos Perros", 1099.99);
	Toy toy3 = new Toy("Puzzle para perros comedero", 6590.00);
	Toy toy4 = new Toy("Juguete Perro Cuerda Circular", 3000);
	Toy toy5 = new Toy("Pescado Interactivo con Carga Micro USB", 5490.69);
	Toy toy6 = new Toy("Pelota Porfiada, Ratón y Plumas", 1200.50);
	
	//Ropas
	Clothe clothe1 = new Clothe("Poncho Capa Buzo Abrigo Polar Para Mascotas Talles Varios", 1445.99);
	Clothe clothe2 = new Clothe("Campera abrigo mascota para perro cachorro", 2962.00);
	Clothe clothe3 = new Clothe("Polar rosa talle 2 Perro", 1599.00);
	Clothe clothe4 = new Clothe("Polar naranja talle 3", 1599.00);
	
	//Comidas
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

	public PetShop(User loggedUser) {
		this.loggedUser = loggedUser;
		stockToys = new Stock<Toy>();
		stockClothes = new Stock<Clothe>();
		stockFoods = new Stock<Food>();
	}

	public void cargarProductos() {

		//Cargamos 30 productos "Toy" de cada uno
		for (int i = 0; i < amountToys; i++) {
			stockToys.addProduct(toy1);
			stockToys.addProduct(toy2);
			stockToys.addProduct(toy3);
			stockToys.addProduct(toy4);
			stockToys.addProduct(toy5);
			stockToys.addProduct(toy6);
		}

		//Cargamos 28 productos "Clothe" de cada uno
		for (int i = 0; i < amountClothes; i++) {
			stockClothes.addProduct(clothe1);
			stockClothes.addProduct(clothe2);
			stockClothes.addProduct(clothe3);
			stockClothes.addProduct(clothe4);
		}

		//Cargamos 100 productos "Food" de cada uno
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
			
			System.out.println("\n[SHOP - TIENDA]\n");
			
			System.out.println("1) Juguetes");
			System.out.println("2) Ropa");
			System.out.println("3) Alimentos");
			System.out.println("0) Salir");
			
			System.out.println();
			System.out.print("Opcion: ");
			
			option = input.nextInt();
			
			switch (option) {
			
			case 1:
				shopMenu_toys();
				break;
				
			case 2:
				shopMenu_clothes();
				break;
				
			case 3:
				shopMenu_foods();
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
				break;
			}
			
		} while (option >= 1 || option >= 3);
	}

	public void shopMenu_toys() {
		
		int option = 0;
		int newStockQuantity = 0;
		boolean notEnoughFounds;
		
		do {
			
			int confirmPurchase = 0;
		
			System.out.println("\nStock actual de Juguetes: " + stockToys.getQuantity());
			System.out.println("Stock actual de Ropa: " + stockClothes.getQuantity());
			System.out.println("Stock actual de Alimentos: " + stockFoods.getQuantity() + "\n");
			
			stockToys.showProducts(amountToys);
			System.out.println("[!] Para volver al menu principal ingrese: 0 (cero)\n");
			
			System.out.print("[!] Ingrese indice del producto que desea comprar: ");
			option = input.nextInt();
			
			System.out.println("\nSALDO: " + loggedUser.getMyWallet().getAmount());
			
			switch(option) {
			
				case 1:
					
					System.out.println(toy1.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					//Repetir operacion en todos los case PENDIENTE
					
					if(confirmPurchase == 1) {
						if(loggedUser.getMyWallet().getAmount()>toy1.getPrice()) {
							loggedUser.getMyWallet().subtractionCash(toy1.getPrice());
							newStockQuantity = stockToys.removeProductPerPurchase(toy1);
						}
						else {
							System.out.println("No dispone de suficiente saldo para realizar la operacion.");
							System.out.println("Te faltan: $" + (toy1.getPrice()-loggedUser.getMyWallet().getAmount()));
							confirmPurchase=0;
						}
					}
					
					System.out.println();
					
					break;
					
				case 2:
					
					System.out.println(toy2.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(toy2.getPrice());
						newStockQuantity = stockToys.removeProductPerPurchase(toy2);
					}
					
					System.out.println();
					
					break;
					
				case 3:
					
					System.out.println(toy3.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(toy3.getPrice());
						newStockQuantity = stockToys.removeProductPerPurchase(toy3);
					}
					
					System.out.println();
					
					break;
					
				case 4:
					
					System.out.println(toy4.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(toy4.getPrice());
						newStockQuantity = stockToys.removeProductPerPurchase(toy4);
					}
					
					System.out.println();
					
					break;
					
				case 5:
					
					System.out.println(toy5.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(toy5.getPrice());
						newStockQuantity = stockToys.removeProductPerPurchase(toy5);
					}
					
					System.out.println();
					
					break;
					
				default:
					System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
					break;
			}
			
			if(confirmPurchase == 1) {
				
				System.out.println("[!] Compra confirmada");
				System.out.println("Su saldo actual es de: $" + loggedUser.getMyWallet().getAmount());
			}
			
		}while(option >= 1 || option >= 5);
			
	}
	
	public void shopMenu_clothes() {
		
		int option = 0;
		int newStockQuantity = 0;
		
		do {
			
			int confirmPurchase = 0;
		
			System.out.println("\nStock actual de Ropa: " + stockClothes.getQuantity());
			System.out.println("Stock actual de Juguetes: " + stockToys.getQuantity());
			System.out.println("Stock actual de Alimentos: " + stockFoods.getQuantity() + "\n");
		
			stockClothes.showProducts(amountToys);
			System.out.println("[!] Para volver al menu principal ingrese: 0 (cero)\n");
			
			System.out.print("[!] Ingrese indice del producto que desea comprar: ");
			option = input.nextInt();
			
			System.out.println("\nSALDO: " + loggedUser.getMyWallet().getAmount());
			
			switch(option) {
			
				case 1:
					
					System.out.println(clothe1.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(clothe1.getPrice());
						newStockQuantity = stockClothes.removeProductPerPurchase(clothe1);
					}
					
					System.out.println();
					
					break;
					
				case 2:
					
					System.out.println(clothe2.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(clothe2.getPrice());
						newStockQuantity = stockClothes.removeProductPerPurchase(clothe2);
					}
					
					System.out.println();
					
					break;
					
				case 3:
					
					System.out.println(clothe3.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(clothe3.getPrice());
						newStockQuantity = stockClothes.removeProductPerPurchase(clothe3);
					}
					
					System.out.println();
					
					break;
					
				case 4:
					
					System.out.println(clothe4.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(clothe4.getPrice());
						newStockQuantity = stockClothes.removeProductPerPurchase(clothe4);
					}
					
					System.out.println();
					
					break;
					
					
				default:
					System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
					break;
			}
			
			if(confirmPurchase == 1) {
				
				System.out.println("[!] Compra confirmada");
				System.out.println("Su saldo actual es de: $" + loggedUser.getMyWallet().getAmount());
			}
			
		}while(option >= 1 || option >= 4);
		
		
	}
	
	public void shopMenu_foods() {
		
		int option = 0;
		int newStockQuantity = 0;
		
		do {
			
			int confirmPurchase = 0;
		
			System.out.println("\nStock actual de Alimentos: " + stockFoods.getQuantity());
			System.out.println("Stock actual de Juguetes: " + stockToys.getQuantity());
			System.out.println("Stock actual de Ropa: " + stockClothes.getQuantity() + "\n");
		
			stockFoods.showProducts(amountFoods);
			System.out.println("[!] Para volver al menu principal ingrese: 0 (cero)\n");
			
			System.out.print("[!] Ingrese indice del producto que desea comprar: ");
			option = input.nextInt();
			
			System.out.println("\nSALDO: " + loggedUser.getMyWallet().getAmount());
			
			switch(option) {
			
				case 1:
					
					System.out.println(food1.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food1.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food1);
					}
					
					System.out.println();
					
					break;
					
				case 2:
					
					System.out.println(food2.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food2.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food2);
					}
					
					System.out.println();
					
					break;
					
				case 3:
					
					System.out.println(food3.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food3.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food3);
					}
					
					System.out.println();
					
					break;
					
				case 4:
					
					System.out.println(food4.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food4.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food4);
					}
					
					System.out.println();
					
					break;
					
				case 5:
					
					System.out.println(food5.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food5.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food5);
					}
					
					System.out.println();
					
					break;
					
				case 6:
					
					System.out.println(food6.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food6.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food6);
					}
					
					System.out.println();
					
					break;
					
				case 7:
					
					System.out.println(food7.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food7.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food7);
					}
					
					System.out.println();
					
					break;
					
				case 8:
					
					System.out.println(food8.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food8.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food8);
					}
					
					System.out.println();
					
					break;
					
				case 9:
					
					System.out.println(food9.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food9.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food9);
					}
					
					System.out.println();
					
					break;
					
				case 10:
					
					System.out.println(food10.toString());
					
					System.out.println("[?] ¿Desea confirmar la compra?\n 1- Si | 2- No\n");
					
					System.out.print("Opcion: ");
					confirmPurchase = input.nextInt();
					
					if(confirmPurchase == 1) {
						loggedUser.getMyWallet().subtractionCash(food10.getPrice());
						newStockQuantity = stockFoods.removeProductPerPurchase(food10);
					}
					
					System.out.println();
					
					break;
					
					
				default:
					System.out.println("Error. Número de operación incorrecta, por favor vuelva a ingresar la opción");
					break;
			}
			
			if(confirmPurchase == 1) {
				
				System.out.println("[!] Compra confirmada");
				System.out.println("Su saldo actual es de: $" + loggedUser.getMyWallet().getAmount());
			}
			
		}while(option >= 1 || option >= 10);
		
	}
	
//	public <E> void purchaseOperation(Double productPrice,E product) {
//		int newStockQuantity = 0;
//		if(loggedUser.getMyWallet().getAmount()-productPrice>0) {
//			loggedUser.getMyWallet().subtractionCash(productPrice);
//			newStockQuantity = stockFoods.removeProductPerPurchase(product);
//		}
//	}

}