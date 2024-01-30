
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Register {
	static String dbUrl="jdbc:mysql://localhost:3306/mahiladb";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";	
    String name,email,password;
	Register(String name,String email,String password){
		this.name=name;
		this.email=email;
		this.password=password;
}
	void reg() {
		Connection con = null;
		System.out.println(name);
   		try {
			Class.forName(dbDriver);  //class not found exception
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
			
		    String sql = "insert into train (name,email,password)"
				+ "values('"+name+"','"+email+"','"+password+"')";

			Statement s = con.createStatement();
			s.execute(sql);

		   	con.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
}
}