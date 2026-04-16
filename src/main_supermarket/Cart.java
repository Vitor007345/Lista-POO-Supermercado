package main_supermarket;

import product.GroupOfItemProducts;
import product.ProductReadOnly;
import product.ItemProduct;

public class Cart extends GroupOfItemProducts<ProductReadOnly>{
	//constructors
	public Cart() {
		super();
	}
	public Cart(Cart cart) {
		super(cart);
	}
	
	//methods
	public double totalPrice() {
		double total = 0;
		for(ItemProduct<ProductReadOnly> IP : this.itemProducts) {
			total += IP.totalPrice();
		}
		return total;
	}
}
