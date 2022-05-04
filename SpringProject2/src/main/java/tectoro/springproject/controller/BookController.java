package tectoro.springproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tectoro.springproject.model.Book;

@RestController
public class BookController {
    
	
	@GetMapping("/book")
	public Book getBooks()
	{
		Book book=new Book();
		book.setId(101);
		book.setTitle("java");
		book.setAuthor("SunMicroSystem");
		
		return book;
	}
}
