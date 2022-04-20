package com.currency;

import java.util.*;
import java.text.DecimalFormat;
 
public class Currencyconverter {
 
	public static void main(String[] args) {
 
		double amount, country, rupee, usd, pound, euro, dirham, cad;
 
		DecimalFormat f = new DecimalFormat("##.##");
 
		
		// this code for getting input from the user to select the country
		
		try (Scanner sc = new Scanner(System.in)) 
		
		{
			System.out.println("Currency Converter\n");
 
			System.out.println("which currency You want to Convert ? ");
			
			System.out.println("\t1:India(INR)\n \t2:United States(USD) \n\t3:United Kingdom(GBP) \n\t4:Europe(Euro) \n\t5:United Arab Emirates(Dirham) \n\t6:Canada(CAD) ");
			country = sc.nextInt();
			
			System.out.println("How much Money you want to convert ?");
			amount = sc.nextFloat();
		}
 
		
		// this code for Indian Rupee conversion
		
		if (country == 1) 
		{
 
			usd = amount / 75.85;
			System.out.println( amount + " Rupee is : " + f.format(usd) + " $(Dollar)");
 
			pound = amount / 98.69;
			System.out.println( amount + " Rupee is : " + f.format(pound) + " £(Pound)");
 
			euro = amount / 82.57;
			System.out.println( amount + " Rupee is : " + f.format(euro) + " €(Euro)");
 
			dirham = amount / 20.64;
			System.out.println( amount + " Rupee is : " + f.format(dirham) + " د.إ(Dirham)");
 
			cad	 = amount / 60.22;
			System.out.println( amount + " Rupee is : " + f.format(cad) + " $(CAD)");
			
		}
		
		
		// this code for United States Doller Conversion
		
		else if (country == 2) 
			
		{
 
			rupee = amount * 75.85;
			System.out.println( amount + " Dollar is : " + f.format(rupee) + " ₹(Ruppes)");
 
			pound = amount * 0.77;
			System.out.println( amount + " Dollar is : " + f.format(pound) + " £(Pound)");
 
			euro = amount * 0.92;
			System.out.println( amount + " Dollar is : " + f.format(euro) + " €(Euro)");
 
			dirham = amount * 3.67;
			System.out.println( amount + " Dollar is : " + f.format(dirham) + " د.إ(Dirham)");
 
			cad = amount * 0.79;
			System.out.println( amount + " Dollar is : " + f.format(cad) + " $(CAD)");
			
		} 
		
		
		// this code for Briten's Greate Briten Pound conversion
		
		else if (country == 3)
		{
 
			rupee = amount * 98.63;
			System.out.println( amount + " pound is : " + f.format(rupee) + " ₹(Ruppes)");
 
			usd = amount * 1.30;
			System.out.println(amount + " pound is : " + f.format(usd) + " $(Dollar)");
 
			euro = amount * 1.19;
			System.out.println( amount + " pound is : " + f.format(euro) + " €(Euro)");
 
			dirham = amount * 4.77;
			System.out.println( amount + " pound is : " + f.format(dirham) + " د.إ(Dirham)");
 
			cad = amount * 1.64;
			System.out.println( amount + " pound is : " + f.format(cad) + " $(CAD)");
			
		} 
		
		
		// this code for Europes euro conversion
		 
		else if (country == 4) 
		{
			
			rupee = amount * 82.60;
			System.out.println( amount + " euro is : " + f.format(rupee) + " ₹(Ruppes)");
 
			usd = amount * 1.09;
			System.out.println( amount + " euro is : " + f.format(usd) + " $(Dollar)");
 
			pound = amount * 0.84;
			System.out.println( amount + " euro is : " + f.format(pound) + " £(Pound)");
 
			dirham = amount * 3.99;
			System.out.println( amount + " euro is : " + f.format(dirham) + " د.إ(Dirham)");
 
			cad = amount * 1.37;
			System.out.println( amount + " euro is : " + f.format(cad) + " $(CAD)");
			
		} 
		
		
		// thid code for United Arab Emirates Dirham conversion
		
		else if (country == 5) 
		{
 
			rupee = amount * 20.68;
			System.out.println( amount + " dirham is : " + f.format(rupee) + " ₹(Ruppes)");
 
			usd = amount * 0.27;
			System.out.println( amount + " dirham is : " + f.format(usd) + " $(Dollar)");
 
			pound = amount * 0.21;
			System.out.println( amount + " dirham is : " + f.format(pound) + " £(Pound)");
 
			euro = amount * 0.25;
			System.out.println( amount + " dirham is : " + f.format(euro) + " €(Euro)");
 
			cad = amount * 0.34;
			System.out.println( amount + " dirham is : " + f.format(cad) + " $(CAD)");
			
		} 
		
		
		// this code for Canada's Doller conversion
		
		else if (country == 6)
		{
			
			rupee = amount * 60.24;
			System.out.println( amount + " cad is : " + f.format(rupee) + " ₹(Ruppes)");
 
			usd = amount * 0.79;
			System.out.println( amount + " cad is : " + f.format(usd) + " $(Dollar)");
 
			pound = amount * 0.61;
			System.out.println( amount + " cad is : " + f.format(pound) + " £(Pound)");
 
			euro = amount * 0.73;
			System.out.println( amount + " cad is : " + f.format(euro) + " €(Euro)");
 
			dirham = amount * 2.91;
			System.out.println( amount + " cad is : " + f.format(dirham) + " د.إ(Dirham)");
			
		}
		
		else
		{
			System.out.println("Invalid input");
		}
		
	}
 
}
