package com.vast.vo;

import java.util.Objects;

public class Examinor {
   
   private String ename;
   private int age;
   private String degree;
   private String loc;
   
   public Examinor() {
	   
   }

public Examinor(String ename, int age, String degree, String loc) {
	super();
	this.ename = ename;
	this.age = age;
	this.degree = degree;
	this.loc = loc;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getDegree() {
	return degree;
}

public void setDegree(String degree) {
	this.degree = degree;
}

public String getLoc() {
	return loc;
}

public void setLoc(String loc) {
	this.loc = loc;
}



@Override
public int hashCode() {
	return Objects.hash(age, degree, ename, loc);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Examinor other = (Examinor) obj;
	return age == other.age && Objects.equals(degree, other.degree) && Objects.equals(ename, other.ename)
			&& Objects.equals(loc, other.loc);
}

@Override
public String toString() {
	return "Examinor [ename=" + ename + ", age=" + age + ", degree=" + degree + ", loc=" + loc + "]";
}

  



 
}
