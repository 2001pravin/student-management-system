package app;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.stream.FileImageInputStream;

public class jdbc2 {
 public static void main(String[] args) {
	 System.out.println("hi");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","pravin@2001");
		String q = "INSERT INTO student2(img)VALUES(?)";
	PreparedStatement pstmt	=connection.prepareStatement(q);
    FileInputStream fS = new FileInputStream("E:\\barki\\20230715143640_IMG_1962.JPG");
	pstmt.setBinaryStream(1, fS,fS.available());
	pstmt.executeUpdate();
	System.out.println("done...");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
}
}
