package entities;

public class ImportedProduct extends Product{
	private Double customsFee;
	
	public ImportedProduct() {
		// TODO Auto-generated constructor stub
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public void totalPrice() {
		price+=customsFee;		
	}
	
	@Override
	public String priceTag() {
		return  getName()+" $ "+"Nao consegui" +" (Custom fee: $ "+customsFee+")";
	}
}
