package app;

public class PetShop {
	//Clase generica Stock que puede almacenar Juguetes, Ropa o Comida
	//Clase juguete, Clase ropa, Clase comida
	//Internamente tendria Objetos de tipo Producto
	//Producto tendria internamente un String y un Double
	
	private Stock<Toy> stockToys;
	private Stock<Clothe> stockClothes;
	private Stock<Food> stockFoods;
	
	public PetShop() {
		stockToys = new Stock<Toy>();
		stockClothes= new Stock<Clothe>();
		stockFoods= new Stock<Food>();
	}
	
	public void cargarProductos() {
		int amount=5;
		Toy toy1= new Toy("pelota",70.5);
		Toy toy2= new Toy("Hueso",80.4);
		Clothe clothe1=new Clothe("Abrigo",150);
		
		
		stockToys.addProduct(toy1);
		stockToys.addProduct(toy2);
		stockClothes.addProduct(clothe1);
		
		for (int i = 0; i < amount; i++) {
			stockToys.addProduct(toy1);
			stockToys.addProduct(toy2);
		}
		
		
	}
	
	
	
	
	
	
	
	
	/*{ "nombre": "Pelota De Goma Caucho Maciza Para Perros 7.5 Cm X 3 Unidades",
    		  "precio": 1099.99
    		},
    		{ "nombre": "Cuerda con nudos Perros",
    		  "precio": 1099.99
    		},
    		{ "nombre": "Puzzle para perros comedero",
    		  "precio": 6590.00
    		},
    		{ "nombre": "Juguete Perro Cuerda Circular",
    		  "precio": 3000
    		},
    		{ "nombre": "Pescado Interactivo con Carga Micro USB",
    		  "precio": 5490.69
    		},
    		{ "nombre": "Pelota Porfiada, Ratón y Plumas",
    		  "precio": 1200.50
    		},
    		
    		
    		{ "nombre": "Poncho Capa Buzo Abrigo Polar Para Mascotas Talles Varios",
    		  "precio": 1445.99
    		},
    		{ "nombre": "Camperas Abrigos Mascotas Perros Cachorros",
    		  "precio": 2962.00
    		},
    		{ "nombre": "Polar rosa talle 2 Perro",
    		  "precio": 1599.00
    		},
    		{ "nombre": "Polar azul talle 5 Perro",
    		  "precio": 1599.00
    		},
    		{ "nombre": "Polar rosa talle 2 Perro",
    		  "precio": 1599.00
    		},
    		{ "nombre": "Polar naranja talle 3",
    		  "precio": 1599.00
    		},    		
    		
    		
    		{ "nombre": "Royal Canin Urinary Care",
    		  "precio": 17490.00
    		},
    		{ "nombre": "Royal Canin Ageing 12+ Feline",
    		  "precio": 23990.00
    		},
    		{ "nombre": "Royal Canin Urinary Care",
    		  "precio": 17490.00
    		},
    		{ "nombre": "Royal Canin Hepatic Feline 1.5 kg",
    		  "precio": 19990.00
    		},
    		{ "nombre": "Royal Canin Mother & Babycat",
    		  "precio": 12990.00
    		},
    		{ "nombre": "Royal Canin Gastrointestinal Canine",
    		  "precio": 17090.00
    		},
    		{ "nombre": "Hill´s L/D Canine 7.98 kg",
    		  "precio": 78500.00
    		},
    		{ "nombre": "Hill’s Science Diet Puppy",
    		  "precio": 17990.00
    		},
    		{ "nombre": "Hill´s Natural Training Treat",
    		  "precio": 4990.00
    		},
    		{ "nombre": "Royal Canin Puppy X-Small",
    		  "precio": 11490.00
    		}*/
	
}
