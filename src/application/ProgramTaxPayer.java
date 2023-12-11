package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class ProgramTaxPayer {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int number = sc.nextInt();
		
		for(int i=0; i<number;i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i+1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salary = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double service = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Gastos médicos: ");
			double health = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			sc.nextLine();
			
			TaxPayer taxPayer = new TaxPayer(salary,service,capital,health,education);
			list.add(taxPayer);			
		}
		
		System.out.println();
		int i=0;
		for (TaxPayer obj : list) {
			
			TaxPayer taxPayer = new TaxPayer(obj.getSalaryIncome(),obj.getServiceIncome(),obj.getCapitalIncome(),obj.getHealthSpending(),obj.getEducationSpenging());	
			
			i++;
			System.out.println("Resumo do "+ i + "o contribuinte:");			
			
			System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
			System.out.printf("Imposto devido: %.2f%n" , taxPayer.netTax());
			System.out.println();
		}
		
		sc.close();
	}

}
