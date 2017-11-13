package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;

public class Statistics implements Serializable , Comparable<Statistics>{

	private InsuranceProduct product;
	Double Deal;
	Double note;

private Insurance insurance ;

	
	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	@Override
	public int compareTo(Statistics s) {
		
		if(s.getDeal() > this.getDeal())
		return 1;
		
		else
			
		return -1;
		
	}
	public InsuranceProduct getProduct() {
		return product;
	}
	public void setProduct(InsuranceProduct product) {
		this.product = product;
	}

	public Double getDeal() {
		return Deal;
	}

	public void setDeal(Double deal) {
		Deal = deal;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}


		
	}


	
	
	
	
	
	

