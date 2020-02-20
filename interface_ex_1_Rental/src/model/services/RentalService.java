package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;
	
	private BrazilTaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2-t1) / 1000 / 60 / 60;//converte milisegundos pra hora.
		
		double basicPayment; 
		if (hours<=12.0) {
			basicPayment =Math.ceil(hours)*pricePerHour;//math.ceil ->arrendonda horas 4.10 pr 5
		}
		else {
			basicPayment =Math.ceil(hours/24)*pricePerDay; //preco por dia.
		}
		double tax = taxService.tax(basicPayment);//calcula a taxa de importo. muito show
		
		carRental.setInvoice(new Invoice(basicPayment,tax));//cria um objeto com nota de pagamento asscioando com o obj de aluguel
	}
}
