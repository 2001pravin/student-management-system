package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creating conection
			String url = "jdbc:mysql://localhost:3306/student";
			String username= "root"; 
			String password ="pravin@2001";
			Connection con = DriverManager.getConnection(url,username,password);
			if (con.isClosed()) {
				System.out.println("connection is closed");
			} else {
				System.out.println("connection is create");
				// create quree
        String q ="INSERT INTO student1(name,phone) VALUES(?,?)";
       
        PreparedStatement pstm=con.prepareStatement(q);
        System.out.println("enter name :");
		String name = br.readLine();
		pstm.setString(1, name);
		System.out.println("enter phone :");

		int phone = Integer.parseInt(br.readLine());
        pstm.setInt(2, phone);
        pstm.executeUpdate();
     
	        System.out.println("something is rong");

		
        con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}

}
