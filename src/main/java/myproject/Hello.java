package myproject;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello Project!");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("Today is " + formatter.format(date) );
	}
}
