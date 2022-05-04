package com.tectoro.bankproject.dao.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.ResultSetExtractor;  


import com.tectoro.bankproject.dao.BankDao;
import com.tectoro.bankproject.domain.AccountDetails;
import com.tectoro.bankproject.domain.TransactionDetails;

@Repository
public class BankDaoImpl implements BankDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public AccountDetails createAccount(AccountDetails accountDetails) {

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("INSERT INTO ACCOUNT_DETAILS ");
			sqlQuery.append("(");
			sqlQuery.append("account_no , ");
			sqlQuery.append("name , ");
			sqlQuery.append("dob, ");
			sqlQuery.append("pan_no, ");
			sqlQuery.append("phone_no, ");
			sqlQuery.append("aadhar_no,");
			sqlQuery.append("email,");
			sqlQuery.append("address ");
			sqlQuery.append(") ");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?, ?, ?, ?, ?)");

			System.out.println(sqlQuery);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "id" });
					ps.setLong(1, accountDetails.getAccNo());
					ps.setString(2, accountDetails.getName());
					ps.setString(3, accountDetails.getDob());
					ps.setString(4, accountDetails.getPanNo());
					ps.setString(5, accountDetails.getPhnNo());
					ps.setString(6, accountDetails.getAdharNo());
					ps.setString(7, accountDetails.getEmail());
					ps.setString(8, accountDetails.getAddress());
					return ps;
				}
			}, keyHolder);
			accountDetails.setId(keyHolder.getKey().intValue());
			return accountDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransactionDetails deposit(TransactionDetails transactiondetails) {

		ResultSet set = null;
		double balance ;

		try
		{
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("insert into transaction_details");
			sqlQuery.append("(");
		//    sqlQuery.append("id , ");
		//	sqlQuery.append("transaction_id , ");
			sqlQuery.append("account_no, ");
			sqlQuery.append("deposit, ");
		    sqlQuery.append("withdraw, ");
			sqlQuery.append("balance,");
			sqlQuery.append("txnTime");
			sqlQuery.append(")");
			sqlQuery.append("values");
			sqlQuery.append("(?, ?, ?, ?, ?)");
			System.out.println(sqlQuery);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sqlQuery.toString(), new String[] { "transacId" });
					ps.setLong(1, transactiondetails.getDetails().getAccNo());
					ps.setDouble(2, transactiondetails.getDeposite());
					ps.setDouble(3, transactiondetails.getWithdraw());
					ps.setDouble(4, transactiondetails.getBalance());
					String str = transactiondetails.getTransacTime();
				    Date date = new Date();  
	                Timestamp ts=new Timestamp(date.getTime());  
					ps.setTimestamp(5,ts);
					return ps;
				}
			}, keyHolder);
			transactiondetails.setTransacId(keyHolder.getKey().longValue());
			return transactiondetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public TransactionDetails deposit1(TransactionDetails transactiondetails) {

		ResultSet set = null;
		double balance ;

		try
		{
			StringBuilder sql = new StringBuilder();
			sql.append("update table transaction_details");
			sql.append("set balance = "+transactiondetails.getBalance()+",");
			sql.append("withdraw = "+transactiondetails.getWithdraw());
			sql.append("where account_no = "+transactiondetails.getDetails().getAccNo());
			jdbcTemplate.execute(sql.toString());

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public TransactionDetails extractData(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDetails> getTdetails(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public TransactionDetails extractData(ResultSet rs) {
	//	TransactionDetails transactionDetails = null;
	//	try {
	//    List<TransactionDetails> list=new ArrayList<TransactionDetails>();
	//    while(rs.next())
	//    {
	//    	 transactionDetails = new TransactionDetails();
	//    	transactionDetails.setBalance(rs.getDouble(6));
	//    }
	//    return transactionDetails;
	//	}
	//    catch(Exception e) {
	//    	
	//    }
	//	return null;
	//
	//}

}
