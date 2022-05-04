package com.tectoro.bankproject.dao;

import java.sql.ResultSet;
import java.util.List;

import com.tectoro.bankproject.domain.AccountDetails;
import com.tectoro.bankproject.domain.TransactionDetails;

public interface BankDao {

	AccountDetails createAccount(AccountDetails accountDetails);
	TransactionDetails deposit(TransactionDetails transactiondetails);
	public List<TransactionDetails> getTdetails(TransactionDetails  transactionDetails);
	 public TransactionDetails extractData(ResultSet rs);
}
