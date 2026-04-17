package product;

import java.util.ArrayList;

public class GroupOfItemProducts<P extends ProductReadOnly> {
	//atributes
	protected ArrayList<ItemProduct<P>> itemProducts;
	
	//constructors
	public GroupOfItemProducts() {
		this.itemProducts = new ArrayList<>();
	}
	
	public GroupOfItemProducts(GroupOfItemProducts<P> groupOfItemProducts) {
		this.itemProducts = new ArrayList<>(groupOfItemProducts.itemProducts);
	}
	
	
	//methods
	public boolean addItemProduct(ItemProduct<P> itemProduct) {
		return this.itemProducts.add(itemProduct);
	}
	
	public boolean addProduct(P product, int qnt) {
		return this.itemProducts.add(new ItemProduct<P>(product, qnt));
	}
	
	public ItemProduct<P> getItemProduct(int id){
		for(ItemProduct<P> IP : this.itemProducts) {
			if(IP.getProduct().getId() == id) {
				return IP;
			}
		}
		return null;
	}
	
	public boolean removeItemProduct(int id) {
		for(int i = 0; i < this.itemProducts.size(); i++) {
			if(this.itemProducts.get(i).getProduct().getId() == id) {
				this.itemProducts.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	public String listAll() {
		String list = "";
		for(ItemProduct<P> IP : this.itemProducts) {
			list += IP.toString() + "\n";
		}
		return list;
	}
	
}
