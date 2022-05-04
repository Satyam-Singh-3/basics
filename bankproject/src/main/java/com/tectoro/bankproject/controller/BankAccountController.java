package com.tectoro.bankproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.bankproject.domain.AccountDetails;
import com.tectoro.bankproject.domain.TransactionDetails;
import com.tectoro.bankproject.service.BankService;

@RestController
@RequestMapping(value="/bankapi")
public class BankAccountController {
	
	@Autowired
	private BankService bankService;
	@PostMapping("/creatAccount")
	public AccountDetails  createAccount(@RequestBody AccountDetails accountDetails) {
		
		AccountDetails accountDetails1 = null;		
		try {
			accountDetails1 = bankService.createAccount(accountDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return accountDetails1;
	}
	
	
	@PostMapping("/deposit")
	public TransactionDetails deposit(@RequestBody TransactionDetails transactiondetails )
	{
		TransactionDetails details = null;
		try
		{
           details = bankService.deposit(transactiondetails)	;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return details;
	}
     
}
