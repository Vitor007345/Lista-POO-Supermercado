package main_supermarket;

public class ItemProduct {
	private Product product;
	private int qnt;
	
	
	
	public ItemProduct(Product product) {
		this(product, 0);
	}
	
	public ItemProduct(Product product, int qnt) {
		this.product = product;
		this.setQnt(qnt);
	}
	
	//setter
	boolean setQnt(int qnt) {
		if(qnt >= 0) {
			this.qnt = qnt;
			return true;
		}
		return false;
	}
	
	//getters
	public Product getProduct() {
		return product;
	}
	
	public int getQnt() {
		return qnt;
	}
	
	//methods
	
	public void add(int value) {
		this.qnt+= value;
	}
	
	
	
	
}
