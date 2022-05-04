package com.tectoro.service.impl;

import com.tectoro.domain.Product;
import com.tectoro.service.VendingMachineService;

public class VendingMachineServiceImpl implements VendingMachineService {

	@Override
	public void displayProducts() {
		 System.out.println(" *********************************************");
	        System.out.println("     WELCOME TO THE VENDING MACHINE           ");
	        System.out.println(" *********************************************");
	        System.out.println("            Products available:               ");
	        System.out.println("                                              ");
	        for(Product product: Product.values()){
	            if(!Product.EMPTY.equals(product)) {
	                System.out.println("  " + product.name() + " - Price: " + product.getPrice() + "   ");
	            }
	        }
	        System.out.println("                                              ");
	        System.out.println(" Please select your product: ");

		
	}

}
