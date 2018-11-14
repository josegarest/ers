package saludocupacional;
import java.lang.*;import java.sql.*;import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConexionSql
{
   static String bd = "saludocupacional";
   static String login = "root";
    public int nivelaislamiento;
   static String password = "salud";
   static String url = "jdbc:mysql://192.168.1.54/"+bd;
   public Connection conn = null;
   public Connection getConnection()

   {


      try
      {
         //Class.forName("org.hsqldb.jdbcDriver");
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         nivelaislamiento=conn.TRANSACTION_SERIALIZABLE;
         conn.setTransactionIsolation(nivelaislamiento);
         if (conn != null)
         {
            System.out.println("Conexi�n a base de datos "+url+" ... Ok");
          //  conn.close();
         }
      }
      catch(SQLException ex)
      {
         System.out.println("dionisio"+ex.getMessage());
      }
      catch(ClassNotFoundException ex)
      {
         System.out.println("dionisio"+ex.getMessage());
      }
     return(conn);
   }

   public  void CerrarConexion(){
       try{
        conn.close();
        System.out.println("Conexion Cerrada");
    }
    catch (SQLException e){
          e.getMessage();
      }
    }


}


















