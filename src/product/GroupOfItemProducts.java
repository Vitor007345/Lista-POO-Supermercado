package product;

import java.util.ArrayList;

public class GroupOfItemProducts<P extends ProductReadOnly> {
	//atributes
	private ArrayList<ItemProduct<P>> itemProducts;
	
	//constructors
	public GroupOfItemProducts() {
		this.itemProducts = new ArrayList<>();
	}
	
	//methods
	public boolean addItemProduct(ItemProduct<P> itemProduct) {
		return this.itemProducts.add(itemProduct);
	}
	
	public ItemProduct<P> getItemProduct(int id){
		for(ItemProduct<P> IP : itemProducts) {
			if(IP.getProduct().getId() == id) {
				return IP;
			}
		}
		return null;
	}
	
	public boolean removeItemProduct(int id) {
		for(int i = 0; i < itemProducts.size(); i++) {
			if(itemProducts.get(i).getProduct().getId() == id) {
				itemProducts.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String listAll() {
		String list = "";
		for(ItemProduct<P> IP : itemProducts) {
			list += IP.toString() + "\n";
		}
		return list;
	}
	
}
