package product;

public class Product implements ProductReadOnly{
	private int id;
	private String name;
	private double price;
	
	//constructors
	
	public Product() {
		this(0, "", 0);
	}
	public Product(int id, String name, double price) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		
	}
	
	//validations
	private static boolean validId(int id) {
		return id>=0;
	}
	public static boolean validName(String name) {
		return name != null && name.length() > 0;
	}
	
	private static boolean validPrice(double price) {
		return price>=0;
	}
	
	//setters
	
	public boolean setId(int id) {
		if(validId(id)) {
			this.id = id;
			return true;
		}
		return false;
	}
	
	public boolean setName(String name) {
		if(validName(name)) {
			this.name = name;
			return true;
		}
		return false;
	}
	
	public boolean setPrice(double price) {
		if(validPrice(price)) {
			this.price = price;
			return true;
		}
		return false;
	}
	
	//getters
	@Override
	public int getId() {return this.id;}
	@Override
	public String getName() {return this.name;}
	@Override
	public double getPrice() {return this.price;}
	
	
	//methods
	@Override
	public boolean isValid() {
		return validId(this.id) && validName(name) && validPrice(this.price);
	}
	
	
	@Override
	public String toString() {
		return "[id: " + this.getId() + ", name: '" + this.getName() + "', price: " + this.getPrice() + "]";
	}
	
}
