package com.tectoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.service.LibraryService;


@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService service;
	
	
	
	

}
