package com.tectoro.bankproject.service;


import java.util.List;

import com.tectoro.bankproject.domain.AccountDetails;
import com.tectoro.bankproject.domain.TransactionDetails;

public interface BankService {
	
	public AccountDetails createAccount(AccountDetails accountDetails);
	public TransactionDetails deposit(TransactionDetails transactiondetails);
	public TransactionDetails checkBalance(List<TransactionDetails> transactionDetails) ;
}
