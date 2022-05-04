package com.tectoro.bankproject.service.serviceImpl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.tectoro.bankproject.dao.BankDao;
import com.tectoro.bankproject.domain.AccountDetails;
import com.tectoro.bankproject.domain.TransactionDetails;
import com.tectoro.bankproject.service.BankService;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDao bankDao;


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public AccountDetails createAccount(AccountDetails accountDetails) {
		return bankDao.createAccount(accountDetails);
	}

	@Override
	public TransactionDetails deposit(TransactionDetails transactiondetails) {
		    double balance = 0 ;
		   List<TransactionDetails> list = getTdetails(transactiondetails);
		   for(TransactionDetails t : list)
		   {
			balance = t.getBalance();
		   }
		 
	        if(balance == 0) {
              transactiondetails.setBalance(transactiondetails.getDeposite());
              bankDao.deposit(transactiondetails);
	        }else {
	        	
	        	
	        }
			List<TransactionDetails> list1 = bankDao.getTdetails(transactiondetails);
			TransactionDetails transactiondetails1 = new TransactionDetails();
			

		
		return bankDao.deposit(transactiondetails);
	}
//    public TransactionDetails checkBalance(TransactionDetails transactionDetails,TransactionDetails transactionDetails2)
//    {
//    	if(transactionDetails2.getBalance() != 0)
//    	{
//    	  System.out.println(transactionDetails2.getBalance())
//    	  ;
//    	  
//    	}
//    	else
//    	{
//      	  System.out.println("no sufficient balance");
//
//    	}TransactionDetails
//    	return null;
//    }
	public List<TransactionDetails> getTdetails(TransactionDetails transactionDetails) {
		
	StringBuilder sql = new StringBuilder();
	sql.append("select balance from transaction_details");
	sql.append("where account_no = ");
	sql.append(transactionDetails.getDetails().getAccNo());
	return jdbcTemplate.query(sql.toString(),new ResultSetExtractor<List<TransactionDetails>>() {
		    @Override  
		     public List<TransactionDetails> extractData(ResultSet rs) throws SQLException 
		            {  
		      
		        List<TransactionDetails> list=new ArrayList<TransactionDetails>();  
		        while(rs.next()){  
		        	TransactionDetails e =new TransactionDetails();  
		            e.setBalance(rs.getDouble(6));
		            deposit(e);
		        	
		        	}  
		        return list;  
		        }  
		    });  
}

	@Override
	public TransactionDetails checkBalance(List<TransactionDetails> transactionDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
