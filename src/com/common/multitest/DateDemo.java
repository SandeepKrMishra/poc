package com.design;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Method {
private Date Anst;

	public String getAnst() {
		DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(Anst);
	}
	public void setAnst(Date anst) {
		Anst = anst;
	}
}
class Demo {
 void m(){
	SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
	String date = "1999-12-02";
     Date fd = null;
     String frmtDate;
     Date d;
     Method m = new Method();
     try {
		d = simpledateformat.parse(date);
		System.out.println("hello  " +d);
		 frmtDate =  simpledateformat.format(d);
		 System.out.println("hello frmtDate " +frmtDate);
		 Date dat=simpledateformat.parse(date);
		 System.out.println("hello Dat  " +dat.toString());
		 m.setAnst(dat);
		 System.out.println("hello m date before " +m);
		 
		 System.out.println();
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
 }
}

public class DateDemo {
	

	public static void main(String[] args) {
		Demo dm = new Demo();
		dm.m();
	}

}