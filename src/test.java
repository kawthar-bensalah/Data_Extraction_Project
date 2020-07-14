
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
// import com.mysql.jdbc.Statement;


public class test {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
      String url="jdbc:mysql://127.0.0.1/mabdd";
      FileReader l = null;
      java.sql.Connection c= DriverManager.getConnection(url,"root","");
      try {
		l=new FileReader("subst.dic");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	BufferedReader b=new BufferedReader(l);
      String li=null;
      int i =1;
      String req = null;
      while((li=b.readLine())!=null)
      {
    	  req="INSERT INTO matable VALUES ('"+i+"','"+li+"')";
      
    //  Statement s= (Statement) c.createStatement();
    //  s.executeUpdate(req);
      i++;
      }
	}

}
