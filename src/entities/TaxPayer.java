package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpenging;
	
	public TaxPayer() {
		
	}

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending,
			double educationSpenging) {		
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpenging = educationSpenging;
	}

	@Override
	public String toString() {
		
		return  "Salary="
				+ String.format("%.2f",salaryIncome) 
				+ ", serviceIncome="
				+ String.format("%.2f", serviceIncome)
				+", capitalIncome="
				+ String.format("%.2f", capitalIncome)
				+", healthSpending="
				+ String.format("%.2f", healthSpending)
				+", educationSpenging="
				+ String.format("%.2f", educationSpenging);		
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpenging() {
		return educationSpenging;
	}

	public void setEducationSpenging(double educationSpenging) {
		this.educationSpenging = educationSpenging;
	}
	
	
	public double salaryTax() {
		double salaryMonth = salaryIncome / 12;
		if (salaryMonth < 3000.00) {
			return 0.00;
		}else if (salaryMonth >= 3000.00 && salaryMonth <= 5000.00){
			return (salaryMonth * 10.00 / 100) * 12;
		}else {
			return (salaryMonth * 20 / 100) * 12;
		}
	}
	
	public double servicesTax() {
		return serviceIncome * 15 /100;
		
	}
	
	public double capitalTax() {
		return capitalIncome * 20 / 100;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double valorMaximoDeducao = grossTax() * 30 / 100;
		double valorDeducao = educationSpenging + healthSpending;
		if(valorDeducao < valorMaximoDeducao) {
			return educationSpenging + healthSpending;
		}else {
			return valorMaximoDeducao;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}

}
