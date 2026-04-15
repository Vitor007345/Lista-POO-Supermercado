package product;

public interface ProductReadOnly {
	public int getId();
	public String getName();
	public double getPrice();
	
	public boolean isValid();
}
