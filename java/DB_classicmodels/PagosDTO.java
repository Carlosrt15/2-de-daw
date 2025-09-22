
public class PagosDTO {
	private int customerNumber;
	private	String checkNumber;
	private	double amount;
	
	
	public PagosDTO(int customerNumber, String checkNumber, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.amount = amount;
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCheckNumber() {
		return checkNumber;
	}


	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "PagosDTO [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", amount=" + amount
				+ "]";
	}
	
	
	
}
