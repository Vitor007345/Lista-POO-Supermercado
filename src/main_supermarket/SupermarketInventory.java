package main_supermarket;

import product.GroupOfItemProducts;
import product.Product;

public class SupermarketInventory extends GroupOfItemProducts<Product>{
	//constructors
	public SupermarketInventory() {
		super();
	}
	public SupermarketInventory(SupermarketInventory inv) {
		super(inv);
	} 
}
