import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbTool{
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection connect() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
