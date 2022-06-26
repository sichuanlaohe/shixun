

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        String sql="select * from user where user=? and password=?";
        boolean lg=false;

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DbTool.connect();
            ps=conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next()){
                lg=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DbTool.close(conn,ps,rs);

        }
        if(lg){
            HttpSession hs=req.getSession();
            hs.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/a");
        }
    }
}
