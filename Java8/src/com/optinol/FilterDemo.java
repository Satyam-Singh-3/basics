package com.optinol;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

	public static void main(String[] args) {
		
		List<Product>productList=new ArrayList<Product>();
		productList=getProducts().stream().filter((pr)->pr.getPrice()>1000.00).collect(Collectors.toList());
		
		productList.forEach(System.out::println);
		
		System.out.println("<----------------------------------------------------------------------------->");
		
		getProducts().stream().filter((product)->product.getPrice()>1000.00).forEach(System.out::println);
		
		System.out.println("<----------------------------!  !---------------------------------->");

		//<---------------------!Sorting product based on price!-------------------->
		
		//<---------------------!Anonymous!---------------------> 
		
		List<Product> sortedProductList = getProducts().stream().sorted(new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return (int) (o1.getPrice()-o2.getPrice());
			}
		}).collect(Collectors.toList());
		
		System.out.println(sortedProductList);
		
		System.out.println("<----------------------------!  !---------------------------------->");
		
		//<--------------!lambda expression!------------------------>
		
		List<Product>sortedProductList1=
	    getProducts().stream().sorted((o1,o2)->(int)(o1.getPrice()-o2.getPrice())).collect(Collectors.toList());
        sortedProductList1.forEach(System.out::println);
        
        System.out.println("<----------------------------!  !---------------------------------->");
		
		//<--------------!comparator.comparing()!------------------------>
        
        List<Product>sortedProductList2=
        		getProducts().stream().sorted(Comparator.comparing(Product::getPname)).collect(Collectors.toList());
                sortedProductList2.forEach(System.out::println);
                
         System.out.println("<----------------------------!  !---------------------------------->");
     
         //<--------------!comparator.comparing() in descending order!------------------------>
         
         List<Product>sortedProductList3=
         		getProducts().stream().sorted(Comparator.comparing(Product::getPname).reversed()).collect(Collectors.toList());
                 sortedProductList3.forEach(System.out::println);
                 
          System.out.println("<----------------------------!  !---------------------------------->");
      
        //<--------------!lambda expression descending order!------------------------>
  		
  		List<Product>sortedProductList4=
  	    getProducts().stream().sorted((o1,o2)->(int)(o2.getPrice()-o1.getPrice())).collect(Collectors.toList());
          sortedProductList4.forEach(System.out::println);
          
          System.out.println("<----------------------------!  !---------------------------------->");
  		
		
	}
	
//<----------------------------!getProducts()!--------------------->
	private static List<Product> getProducts(){
		List<Product>list=new ArrayList<Product>();
		list.add(new Product(1,"hp",1000.00));
		list.add(new Product(2,"dell",2000.00));
		list.add(new Product(3,"samsung",3000.00));
		list.add(new Product(4,"asus",4000.00));
		return list;
	}
}

//<------------------! product class !---------------------------->

class Product{
	private Integer pid;
	private String pname;
	private Double price;
	
	public Product() {
		super();
	}

	public Product(Integer pid, String pname, Double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public Integer getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
	
}
