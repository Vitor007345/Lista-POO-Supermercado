package product;

public class ItemProduct<P extends ProductReadOnly> {
	private P product;
	private int qnt;
	
	
	
	public ItemProduct(P product) {
		this(product, 0);
	}
	
	public ItemProduct(P product, int qnt) {
		if(!this.setProduct(product)) {
			throw new IllegalArgumentException("Inavlid product");
		}
		if(!this.setQnt(qnt)) {
			throw new IllegalArgumentException("Negative value of qnt is invalid");
		}
	}
	
	//setter
	public boolean setQnt(int qnt) {
		if(qnt >= 0) {
			this.qnt = qnt;
			return true;
		}
		return false;
	}
	
	public boolean setProduct(P product) {
		if(product.isValid()) {
			this.product = product;
			return true;
		}
		return false;
	}
	
	//getters
	public P getProduct() {
		return product;
	}
	
	public int getQnt() {
		return qnt;
	}
	
	//methods
	
	public void add(int value) {
		this.qnt+= value;
	}
	
	public boolean remove(int value) {
		if(this.qnt - value >= 0) {
			this.qnt-= value;
			return true;
		}
		return false;
	}
	
	public double totalPrice() {
		return this.getProduct().getPrice() * this.getQnt();
	}
	
	@Override
	public String toString() {
		String productStr = this.getProduct().toString();
		return productStr.substring(0, productStr.length() - 1) + 
				", Amount: " + this.getQnt() + 
				", TotalPrice: " + this.totalPrice() + "]";
	}
	
	
	
	
}
