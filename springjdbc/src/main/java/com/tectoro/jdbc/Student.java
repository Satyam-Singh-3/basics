package com.tectoro.jdbc;

public class Student {
private int id;
private String name;
private String city;

//................................default constructor............................................
public Student() {
	super();
}
//.................................parameterized constructor.....................................

public Student(int id, String name, String city) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
}
//............................getters&&setters method.............................................

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public String getCity() {
	return city;
}

public void setId(int id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
}

//......................................to string method...............................................

}
