/**
 * 
 */
package com.tectoro.domain;

import java.io.Serializable;

/**
 * @author tectoro
 *
 */
public class LibraryDomain implements Serializable {
	
	private static final long serialVersionUID = -8954518363951947358L;
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPrice;
	
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	

}
