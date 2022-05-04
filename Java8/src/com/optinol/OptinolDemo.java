package com.optinol;

import java.util.Optional;

public class OptinolDemo {

	public static void main(String[] args) {
		 
		String email=null; //"satyam2707singh@gmail.com";
		//Optional class example
		//Static Methods:empty,of,ofNullable.
		
		//Optional<Object>emptyOptional=Optional.empty();
		//System.out.println(emptyOptional);
		
		//of
		
		//Optional<Object>ofMail=Optional.of(email);
		//System.out.println(ofMail);
		
		//ofNullable
		
		Optional<String>ofNullable=Optional.ofNullable(email);
		System.out.println(ofNullable);
		
		//isPresent() method
		
		if(ofNullable.isPresent()) {
			System.out.println(ofNullable.get());
		}
		else {
			System.out.println("no value present");
		}
		
		//orElse() method:it returns default value if value of object is null
		
		String defaultOptinol =  ofNullable.orElse("defaultoptinol@gmail.com");
		System.out.println(defaultOptinol);
		
		
		//orElseGet() method
		
		String defaultOptinol2 = ofNullable.orElseGet(()->"defaulat@gmail.com");
		System.out.println(defaultOptinol2);
		
		//orElseThrow() method
		
		//String elseThrow = ofNullable.orElseThrow(()->new IllegalArgumentException("email not existed over here"));
		//System.out.println(elseThrow);
		
		//ifPresent() method
		
		Optional<String>gender=Optional.of("Male");
		
		Optional<String>emptyOptinol=Optional.empty();
		
		gender.ifPresent((s)->System.out.println("value is present"));
		
		emptyOptinol.ifPresent((s)->System.out.println("value is not present"));
		
		
		//filter()--->
		
		String s=" Satyam ";
		if(s!=null&&s.contains("Satyam")) {
			System.out.println("it is present here:"+s);
		}
		
		Optional<String>optionalString=Optional.of(s);
		optionalString.filter((str)->str.contains("Satyam")).ifPresent((str)->System.out.println(str));
		
		//Map()-->
		
		Optional<String>optionalString1=Optional.of(s);
		optionalString.filter((str)->str.contains("Satyam")).map(String::trim).ifPresent((str)->System.out.println("presented over here:"+str));
		
	}
}
