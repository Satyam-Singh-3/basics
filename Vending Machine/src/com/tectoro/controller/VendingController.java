package com.tectoro.controller;

import java.util.Scanner;

import com.tectoro.service.VendingMachineService;
import com.tectoro.service.impl.VendingMachineServiceImpl;

public class VendingController {
	
private static VendingMachineService service = new VendingMachineServiceImpl();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		service.displayProducts();
		
//		System.out.println("Select the product");
//		String n = sc.nextLine();
//		service.selectProduct(Integer.parseInt(n));
//		
//		
//		
//		
//		service.displayCoins();
//		
//		int a,b,c,d,e;
//		
//		a = sc.nextInt();
//		b = sc.nextInt();
//		c = sc.nextInt();
//		d = sc.nextInt();
//		e = sc.nextInt();
//		
//		service.showCoins(a,b,c,d,e);
	}

}
