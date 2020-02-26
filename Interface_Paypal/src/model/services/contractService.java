package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class contractService {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	OnlinePaymentService onlinePaymentService ;
	
	public contractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double valueP = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {				
			Date date= addMonth(contract.getDate(),i);//trocar date por obj
			
			System.out.println("Erro: "+i+months);
			double updatedQuota = valueP + onlinePaymentService.interest(valueP, i);
            double fullQuota =  updatedQuota+ onlinePaymentService.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(date, fullQuota));
		}

	}

	private Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		//System.out.println(sdf.format(cal.getTime())); // daqui a 1 mês
		return cal.getTime();
	}
}
